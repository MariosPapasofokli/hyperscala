package org.hyperscala.ui.clipboard

import org.hyperscala.module.Module
import org.powerscala.Version
import org.hyperscala.web.{Website, Webpage}
import org.hyperscala.html._
import org.hyperscala.jquery.jQuery
import org.hyperscala.realtime.Realtime
import org.hyperscala.ui.Rangy
import org.hyperscala.css.attributes.Display
import org.hyperscala.Message
import org.powerscala.enum.{Enumerated, EnumEntry}
import org.powerscala.event.processor.UnitProcessor
import org.powerscala.event.Listenable

/**
 * Clipboard offers a mechanism to manage storage and retrieval of items on the server level as an alternative for a
 * native clipboard.
 *
 * @author Matt Hicks <matt@outr.com>
 */
object Clipboard extends Module {
  /**
   * Creates a new ClipboardInstance each time it is called (once per webpage instance).
   */
  val WebpageInstanceCreator = () => new ClipboardInstance
  /**
   * Stores the ClipboardInstance in the session.
   */
  val SessionInstanceCreator = () => Website().session.getOrSet("clipboard_module", new ClipboardInstance)

  val name = "clipboard"
  val version = Version(1)

  override def dependencies = List(jQuery.LatestWithDefault, Realtime, Rangy)

  /**
   * Creates new ClipboardInstances. This can be overridden to pre-populate or share instances across multiple pages.
   *
   * By default a single instance is tied to a single webpage instance (WebpageInstanceCreator).
   */
  var creator: () => ClipboardInstance = WebpageInstanceCreator

  def init() {
    Website().register("/js/clipboard.js", "clipboard.js")
  }

  def load() {
    Webpage().head.contents += new tag.Script(mimeType = "text/javascript", src = "/js/clipboard.js")
    apply()   // Make sure the clipboard instance is created
  }

  def apply() = Webpage().store.getOrSet("clipboard_module", creator())

  def connect(tags: HTMLTag*) = tags.foreach {
    case t => if (!t.clazz.contains("use-clipboard")) {
      t.clazz += "use-clipboard"
    }
  }
}

class ClipboardInstance extends Listenable {
  /**
   * Fired when an event occurs in the client and is sent to the server. This is primarily caused by a keyboard Cut,
   * Copy, or Paste action occurring in the browser.
   *
   * By default no direct handling is enabled for these events. If you wish to use the built-in default handling then
   * call <code>configureDefaultHandling()</code>.
   */
  val clientEvent = new UnitProcessor[ClipboardEvent]("clipboard_event")

  /**
   * Fired when a ClipboardEntry is added to the clipboard. This may occur programmatically or resulting from handling
   * on a <code>clientEvent</code>.
   */
  val entryAdded = new UnitProcessor[ClipboardEntry]("clipboard_entry")

  /**
   * Configures basic handling of clientEvents for Cut, Copy, and Paste.
   */
  def configureDefaultHandling() = {
    clientEvent.on {
      case evt => evt.clipType match {
        case ClipType.Copy => if (evt.selected != null && evt.selected.nonEmpty) {
          addFromEvent(evt)
        }
        case ClipType.Cut => if (evt.selected != null && evt.selected.nonEmpty) {
          addFromEvent(evt)
          // TODO: support cutting
        }
        case ClipType.Paste => // TODO: support pasting
      }
    }
  }

  /**
   * Adds a BasicClipboardEntry based on a ClipboardEvent. The type is defined as "html". This is directly used by
   * <code>configureDefaultHandling()</code> but can be called by more advanced use-cases.
   */
  def addFromEvent(evt: ClipboardEvent) = {
    this += BasicClipboardEntry("html", "HTML content", evt.selected, evt.element)
  }

  private var _list = List.empty[ClipboardEntry]
  private val hiddenDiv = new tag.Div(id = "clipboard_instance") {
    style.display := Display.None

    override def receive(event: String, message: Message) = event match {
      case "cut" => fireClipEvent(ClipType.Cut, message)
      case "copy" => fireClipEvent(ClipType.Copy, message)
      case "paste" => fireClipEvent(ClipType.Paste, message)
      case _ => super.receive(event, message)
    }
  }
  Webpage().body.contents += hiddenDiv

  def +=(entry: ClipboardEntry): Unit = synchronized {
    _list = entry :: _list
    entryAdded.fire(entry)
  }

  def headOption = list.headOption

  /**
   * Removes all entries from clipboard.
   */
  def clear() = synchronized {
    _list = List.empty
  }

  def list = _list

  private def fireClipEvent(clipType: ClipType, message: Message) = {
    val element = Webpage().html.byId[HTMLTag](message[String]("id"))
    val mouseX = message[Int]("mouseX")
    val mouseY = message[Int]("mouseY")
    val selected = message[String]("selected")
    val evt = ClipboardEvent(clipType, element, mouseX, mouseY, selected)
    clientEvent.fire(evt)
  }
}

class ClipType private() extends EnumEntry

object ClipType extends Enumerated[ClipType] {
  val Cut = new ClipType
  val Copy = new ClipType
  val Paste = new ClipType
}

case class ClipboardEvent(clipType: ClipType, element: Option[HTMLTag], mouseX: Int, mouseY: Int, selected: String)

trait ClipboardEntry {
  def entryType: String
  def description: String
  def value: Any
  def owner: Option[HTMLTag]
  def timestamp: Long
}

case class BasicClipboardEntry(entryType: String,
                               description: String,
                               value: Any,
                               owner: Option[HTMLTag],
                               timestamp: Long = System.currentTimeMillis()) extends ClipboardEntry