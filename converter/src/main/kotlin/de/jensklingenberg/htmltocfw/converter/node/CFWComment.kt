package de.jensklingenberg.htmltocfw.converter.node

import de.jensklingenberg.htmltocfw.converter.visitor.Visitor
import org.jsoup.nodes.Comment

class CFWComment(private val comment: Comment) : MyNode {
    override fun accept(visitor: Visitor) {
        visitor.visitComment(this)
    }

    override fun toString(): String {
        return ("//" + comment.data + "\n")
    }

}