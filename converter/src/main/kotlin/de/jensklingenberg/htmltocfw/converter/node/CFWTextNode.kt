package de.jensklingenberg.htmltocfw.converter.node

import de.jensklingenberg.htmltocfw.converter.visitor.Visitor
import org.jsoup.nodes.TextNode

/**
 * This class generates the code for
 * [org.jetbrains.compose.web.dom.Text]
 */
class CFWTextNode(private val textNode: TextNode) : MyNode {
    override fun toString(): String {
        return if (textNode.text().isNotBlank()) {
            val text = textNode.text().replace("\"", "\\\"")
            "Text(\"" + text + "\")\n"
        } else {
            ""
        }
    }

    override fun accept(visitor: Visitor) {
        visitor.visitText(this)
    }

}