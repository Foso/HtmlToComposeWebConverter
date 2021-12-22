package de.jensklingenberg.htmltocfw.converter.node

import org.jsoup.nodes.TextNode

class CFWTextNode(private val textNode: TextNode) : MyNode {
    override fun print(): String {
        return if (textNode.text().isNotBlank()) {
            val text = textNode.text().replace("\"", "\\\"")
            ("Text(\"${text}\")\n")
        } else {
            ""
        }
    }

}