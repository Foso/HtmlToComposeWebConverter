package de.jensklingenberg.htmltocfw.converter.node

import de.jensklingenberg.htmltocfw.converter.getAttributesText
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

class TextAreaNode(private val element: Element) : MyNode {

    override fun print(): String {
        var str = "TextArea("
        str += getAttributesText(element.attributes().asList())

        if (element.childNodes().isNotEmpty() && element.childNodes().first() is TextNode) {
            str += ",value= \"${(element.childNodes().first() as TextNode).text()}\""
        }
        str += ")"
        return str
    }

}