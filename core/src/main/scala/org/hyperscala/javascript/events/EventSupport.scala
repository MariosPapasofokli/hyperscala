package org.hyperscala.javascript.events

import org.hyperscala.{WebAttribute, BodyContent}
import org.hyperscala.js.JavaScriptContent

/**
 * @author Matt Hicks <mhicks@sgine.org>
 */
trait EventSupport extends BodyContent {
  object event {
    val afterPrint = WebAttribute[JavaScriptContent]("onbeforeprint")
    val beforePrint = WebAttribute[JavaScriptContent]("onbeforeprint")
    val beforeOnLoad = WebAttribute[JavaScriptContent]("onbeforeonload")
    val hasChange = WebAttribute[JavaScriptContent]("onhaschange")
    val load = WebAttribute[JavaScriptContent]("onload")
    val message = WebAttribute[JavaScriptContent]("onmessage")
    val offline = WebAttribute[JavaScriptContent]("onoffline")
    val online = WebAttribute[JavaScriptContent]("ononline")
    val pageHide = WebAttribute[JavaScriptContent]("onpagehide")
    val pageShow = WebAttribute[JavaScriptContent]("onpageshow")
    val popState = WebAttribute[JavaScriptContent]("onpopstate")
    val redo = WebAttribute[JavaScriptContent]("onredo")
    val resize = WebAttribute[JavaScriptContent]("onresize")
    val storage = WebAttribute[JavaScriptContent]("onstorage")
    val undo = WebAttribute[JavaScriptContent]("onundo")
    val unLoad = WebAttribute[JavaScriptContent]("onunload")
    val blur = WebAttribute[JavaScriptContent]("onblur")
    val change = WebAttribute[JavaScriptContent]("onchange")
    val contextMenu = WebAttribute[JavaScriptContent]("oncontextmenu")
    val focus = WebAttribute[JavaScriptContent]("onfocus")
    val formChange = WebAttribute[JavaScriptContent]("onformchange")
    val formInput = WebAttribute[JavaScriptContent]("onforminput")
    val input = WebAttribute[JavaScriptContent]("oninput")
    val invalid = WebAttribute[JavaScriptContent]("oninvalid")
    val reset = WebAttribute[JavaScriptContent]("onreset")
    val select = WebAttribute[JavaScriptContent]("onselect")
    val submit = WebAttribute[JavaScriptContent]("onsubmit")
    val keyDown = WebAttribute[JavaScriptContent]("onkeydown")
    val keyPress = WebAttribute[JavaScriptContent]("onkeypress")
    val keyUp = WebAttribute[JavaScriptContent]("onkeyup")
    val click = WebAttribute[JavaScriptContent]("onclick")
    val doubleClick = WebAttribute[JavaScriptContent]("ondblclick")
    val drag = WebAttribute[JavaScriptContent]("ondrag")
    val dragEnd = WebAttribute[JavaScriptContent]("ondragend")
    val dragEnter = WebAttribute[JavaScriptContent]("ondragenter")
    val dragLeave = WebAttribute[JavaScriptContent]("ondragleave")
    val dragOver = WebAttribute[JavaScriptContent]("ondragover")
    val dragStart = WebAttribute[JavaScriptContent]("ondragstart")
    val drop = WebAttribute[JavaScriptContent]("ondrop")
    val mouseDown = WebAttribute[JavaScriptContent]("onmousedown")
    val mouseMove = WebAttribute[JavaScriptContent]("onmousemove")
    val mouseOut = WebAttribute[JavaScriptContent]("onmouseout")
    val mouseOver = WebAttribute[JavaScriptContent]("onmouseover")
    val mouseUp = WebAttribute[JavaScriptContent]("onmouseup")
    val mouseWheel = WebAttribute[JavaScriptContent]("onmousewheel")
    val scroll = WebAttribute[JavaScriptContent]("onscroll")
    val abort = WebAttribute[JavaScriptContent]("onabort")
    val canPlay = WebAttribute[JavaScriptContent]("oncanplay")
    val canPlayThrough = WebAttribute[JavaScriptContent]("oncanplaythrough")
    val durationChange = WebAttribute[JavaScriptContent]("ondurationchange")
    val emptied = WebAttribute[JavaScriptContent]("onemptied")
    val ended = WebAttribute[JavaScriptContent]("onended")
    val error = WebAttribute[JavaScriptContent]("onerror")
    val loadedData = WebAttribute[JavaScriptContent]("onloadeddata")
    val loadedMetaData = WebAttribute[JavaScriptContent]("onloadedmetadata")
    val loadStart = WebAttribute[JavaScriptContent]("onloadstart")
    val pause = WebAttribute[JavaScriptContent]("onpause")
    val play = WebAttribute[JavaScriptContent]("onplay")
    val playing = WebAttribute[JavaScriptContent]("onplaying")
    val progress = WebAttribute[JavaScriptContent]("onprogress")
    val rateChange = WebAttribute[JavaScriptContent]("onratechange")
    val readyStateChange = WebAttribute[JavaScriptContent]("onreadystatechange")
    val seeked = WebAttribute[JavaScriptContent]("onseeked")
    val seeking = WebAttribute[JavaScriptContent]("onseeking")
    val stalled = WebAttribute[JavaScriptContent]("onstalled")
    val suspend = WebAttribute[JavaScriptContent]("onsuspend")
    val timeUpdate = WebAttribute[JavaScriptContent]("ontimeupdate")
    val volumeChange = WebAttribute[JavaScriptContent]("onvolumechange")
    val waiting = WebAttribute[JavaScriptContent]("onwaiting")
  }
}