package org.hyperscala.html

import org.hyperscala._
import css.StyleSheet
import org.hyperscala.html.attributes._
import org.hyperscala.html.constraints._

/**
 * NOTE: This file has been generated. Do not modify directly!
 * @author Matt Hicks <mhicks@hyperscala.org>
 */
class Area extends Container[BodyChild] with BodyChild with HTMLTag {
  lazy val xmlLabel = "area"

  def this(name: String = null,
           accessKey: java.lang.Character = null,
           clazz: List[String] = null,
           contentEditable: ContentEditable = null,
           contextMenu: String = null,
           dir: Direction = null,
           draggable: Draggable = null,
           dropZone: DropZone = null,
           hidden: java.lang.Boolean = null,
           id: String = null,
           lang: String = null,
           spellCheck: java.lang.Boolean = null,
           style: StyleSheet = null,
           tabIndex: java.lang.Integer = null,
           title: String = null,
           alt: String = null,
           coords: String = null,
           href: String = null,
           hrefLang: String = null,
           media: String = null,
           mimeType: String = null,
           rel: String = null,
           shape: String = null,
           target: String = null,
           content: BodyChild = null) = {
    this()
    up(this.name, name)
    up(this.accessKey, accessKey)
    up(this.clazz, clazz)
    up(this.contentEditable, contentEditable)
    up(this.contextMenu, contextMenu)
    up(this.dir, dir)
    up(this.draggable, draggable)
    up(this.dropZone, dropZone)
    up(this.hidden, hidden)
    up(this.id, id)
    up(this.lang, lang)
    up(this.spellCheck, spellCheck)
    up(this.style, style)
    up(this.tabIndex, tabIndex)
    up(this.title, title)
    up(this.alt, alt)
    up(this.coords, coords)
    up(this.href, href)
    up(this.hrefLang, hrefLang)
    up(this.media, media)
    up(this.mimeType, mimeType)
    up(this.rel, rel)
    up(this.shape, shape)
    up(this.target, target)
    if (content != null) contents += content
  }

  val alt = PropertyAttribute[String]("alt", null)
  val coords = PropertyAttribute[String]("coords", null)
  val href = PropertyAttribute[String]("href", null)
  val hrefLang = PropertyAttribute[String]("hreflang", null)
  val media = PropertyAttribute[String]("media", null)
  val mimeType = PropertyAttribute[String]("type", null)
  val rel = PropertyAttribute[String]("rel", null)
  val shape = PropertyAttribute[String]("shape", null)
  val target = PropertyAttribute[String]("target", null)
}