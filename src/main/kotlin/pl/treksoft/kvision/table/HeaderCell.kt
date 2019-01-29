/*
 * Copyright (c) 2017-present Robert Jaros
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package pl.treksoft.kvision.table

import pl.treksoft.kvision.html.Align
import pl.treksoft.kvision.html.TAG
import pl.treksoft.kvision.html.Tag

/**
 * HTML table header cell component.
 *
 * @constructor
 * @param content text content of the cell
 * @param rich determines if [content] can contain HTML code
 * @param align text align
 * @param classes a set of CSS class names
 * @param init an initializer extension function
 */
open class HeaderCell(
    content: String? = null,
    rich: Boolean = false,
    align: Align? = null,
    classes: Set<String> = setOf(),
    init: (HeaderCell.() -> Unit)? = null
) : Tag(TAG.TH, content, rich, align, classes) {

    init {
        @Suppress("LeakingThis")
        init?.invoke(this)
    }

    companion object {
        /**
         * DSL builder extension function.
         *
         * It takes the same parameters as the constructor of the built component.
         */
        fun Row.headerCell(
            content: String? = null,
            rich: Boolean = false,
            align: Align? = null,
            classes: Set<String> = setOf(), init: (HeaderCell.() -> Unit)? = null
        ): HeaderCell {
            val cell = HeaderCell(content, rich, align, classes, init)
            this.add(cell)
            return cell
        }
    }

}