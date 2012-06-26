package com.outr.webframework.tags

import com.outr.webframework.WebAttribute

/**
 * @author Matt Hicks <mhicks@sgine.org>
 */
class Button extends Tag {
  def this(accessKey: String = null,
           clazz: String = null,
           contextEditable: String = null,
           contextMenu: String = null,
           dir: String = null,
           draggable: String = null,
           dropZone: String = null,
           hidden: String = null,
           id: String = null,
           lang: String = null,
           spellCheck: String = null,
           tabIndex: String = null,
           title: String = null,
           content: String = null) = {
    this()
    up(this.accessKey, accessKey)
    up(this.clazz, clazz)
    up(this.contextEditable, contextEditable)
    up(this.contextMenu, contextMenu)
    up(this.dir, dir)
    up(this.draggable, draggable)
    up(this.dropZone, dropZone)
    up(this.hidden, hidden)
    up(this.id, id)
    up(this.lang, lang)
    up(this.spellCheck, spellCheck)
    up(this.tabIndex, tabIndex)
    up(this.title, title)
    if (content != null) {
      contents += content
    }
    // TODO: add tag-specific attributes
  }

  def tag = "button"

  val autoFocus = WebAttribute[String]("autofocus")
  val disabled = WebAttribute[Boolean]("disabled")((b: Boolean) => if (b) "disabled" else "", this)
  val form = WebAttribute[String]("form")
  val formAction = WebAttribute[String]("formAction")
  val formEncType = WebAttribute[String]("formenctype")
  val formMethod = WebAttribute[String]("formmethod")
  val formNoValidate = WebAttribute[String]("formnovalidate")
  val formTarget = WebAttribute[String]("formtarget")
  val name = WebAttribute[String]("name")
  val buttonType = WebAttribute[String]("type")
  val value = WebAttribute[String]("value")
}
