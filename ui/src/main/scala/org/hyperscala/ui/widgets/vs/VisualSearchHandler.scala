package org.hyperscala.ui.widgets.vs

import com.outr.webcommunicator.netty.handler.RequestHandler
import com.outr.webcommunicator.netty._
import org.jboss.netty.channel.{MessageEvent, ChannelHandlerContext}
import org.jboss.netty.handler.codec.http.HttpRequest
import scala.Some

/**
 * @author Matt Hicks <matt@outr.com>
 */
class VisualSearchHandler(visualSearch: VisualSearch) extends RequestHandler {
  def apply(webapp: NettyWebapp, context: ChannelHandlerContext, event: MessageEvent) = event.getMessage match {
    case request: HttpRequest => {
      val url = request2URL(request)

      val requestType = url.parameters("requestType").head
      val response = requestType match {
        case "facets" => {
          visualSearch.facets.collect {
            case f if (f.allowMultiple || !visualSearch.queryHasFacet(f.name)) => "\"%s\"".format(f.name)
          }.mkString("[", ", ", "]")
        }
        case "values" => {
          val facetName = url.parameters("facet").head
          val term = url.parameters("term").head
          visualSearch.facet(facetName) match {
            case Some(facet) => {
              val results = facet.search(term)
              val resultString = results.map(r => "{\"value\": \"%s\", \"label\": \"%s\"}".format(r.value, r.label)).mkString("[", ", ", "]")
              "{\"resultType\": \"%s\", \"results\": %s}".format(facet.resultType.name(), resultString)
            }
            case None => "{\"results\": []}"
          }
        }
      }
      RequestHandler.streamString(response, context, request, "text/plain")
    }
  }
}