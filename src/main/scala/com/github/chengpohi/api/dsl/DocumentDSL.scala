/**
  * chengpohi@gmail.com
  */
package com.github.chengpohi.api.dsl

import org.jsoup.nodes.Document

/**
  * htmlparser
  * Created by chengpohi on 15/10/2016.
  */
class DocumentDSL(d: Document) extends HtmlParserDefinition {
  override val doc: Document = d
  case object select {
    def to(selectType: SelectType): Definition = selectType match {
      case `text` => TextDefinition()
    }
    def attr(_attr: String): Definition = AttrDefinition(_attr)
  }

  implicit class PathRoute(key: String) {
    def ->(value: String): String = {
      key + " " + value
    }
  }
}
