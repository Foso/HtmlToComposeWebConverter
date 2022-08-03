package de.jensklingenberg.htmltocfw.converter.node

import de.jensklingenberg.htmltocfw.converter.parseAttributes
import de.jensklingenberg.htmltocfw.converter.visitor.Visitor
import org.jsoup.nodes.Element

/**
 * This class generates the code for
 * [org.jetbrains.compose.web.dom.Input]
 */
class InputNode(private val attrs: List<ComposeAttribute>, val type: String) : MyNode {
    private val TAG = "Input"
    override fun accept(visitor: Visitor) {
        visitor.visitInput(this)
    }

    override fun toString(): String {
        var str = "$TAG "

        val arguments = mutableListOf<String>()

        if (attrs.isNotEmpty()) {
            arguments.add(parseAttributes(attrs))
        }

        if (type.isNotBlank()) {
            arguments.add("type = InputType.${type}")
        }

        str += "(" + arguments.joinToString { it } + ")"
        str += "\n"
        return str
    }

    companion object {
        fun createInput(node: Element): InputNode {
            val htmlAttributes = node.attributes()
            val typeValue = htmlAttributes.get("type").capitalize()
            htmlAttributes.remove("type")

            return InputNode(node.attributes().toList().map { ComposeAttribute(it.key, it.value) }, typeValue)
        }
    }

}
