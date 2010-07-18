/*
Copyright 2008-2010 Gephi
Authors : Eduardo Ramos <eduramiba@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.datalaboratory.impl.manipulators.attributecolumns.mergestrategies;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.data.attributes.api.AttributeUtils;
import org.gephi.datalaboratory.api.AttributeColumnsMergeStrategiesController;
import org.gephi.datalaboratory.spi.ManipulatorUI;
import org.gephi.datalaboratory.spi.attributecolumns.mergestrategies.AttributeColumnsMergeStrategy;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author Eduardo Ramos <eduramiba@gmail.com>
 */
public class AverageNumber implements AttributeColumnsMergeStrategy{
    private AttributeTable table;
    private AttributeColumn[] columns;

    public void setup(AttributeTable table, AttributeColumn[] columns) {
        this.table=table;
        this.columns=columns;
    }

    public void execute() {
        String title=JOptionPane.showInputDialog(null, NbBundle.getMessage(AverageNumber.class, "AverageNumber.dialog.text"));
        if(title!=null){
            Lookup.getDefault().lookup(AttributeColumnsMergeStrategiesController.class).averageNumberMerge(table, columns, title);
        }
    }

    public String getName() {
        return NbBundle.getMessage(AverageNumber.class, "AverageNumber.name");
    }

    public String getDescription() {
        return NbBundle.getMessage(AverageNumber.class, "AverageNumber.description");
    }

    public boolean canExecute() {
        return AttributeUtils.getDefault().areAllNumberOrNumberListColumns(columns);
    }

    public ManipulatorUI getUI() {
        return null;
    }

    public int getType() {
        return 100;
    }

    public int getPosition() {
        return 0;
    }

    public Icon getIcon() {
        return ImageUtilities.loadImageIcon("org/gephi/datalaboratory/impl/manipulators/resources/balance.png",true);
    }

}
