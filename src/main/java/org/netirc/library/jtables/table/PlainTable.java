/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 netirc.org development team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.netirc.library.jtables.table;

import org.netirc.library.jtables.JTablesBuilder;
import org.netirc.library.jtables.component.AbstractTable;

import java.util.ArrayList;
import java.util.List;

public class PlainTable extends AbstractTable {
    public static JTablesBuilder<PlainTable> build() {
        return new JTablesBuilder<>(new PlainTable());
    }

    @Override
    public List<String> render() {
        if (isCached()) {
            return cache();
        }

        List<String> render = new ArrayList<>();

        if (isEmpty()) {
            render.add(getClass().getSimpleName() + ": There is nothing to display.");
            return render;
        }

        int rowIndex = 0;
        for (List<String> row : rows) {
            for (String col : columns) {
                render.add(col + ": " + row.get(rowIndex));
                rowIndex++;
            }

            render.add("----");
            rowIndex = 0;
        }

        return cache(render);
    }
}
