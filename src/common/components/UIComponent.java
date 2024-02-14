package common.components;

import common.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Map;

public class UIComponent extends CommonComponent {
    public static JPanel bigBox() {
        int boxPanelHeight = (int) (LayOutComponent.getContentPanel().getHeight() * 0.92);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(LayOutComponent.getContentPanel().getWidth() - 25, boxPanelHeight));
        panel.setBackground(BACKGROUND_COLOR);
        return panel;
    }

    public static JTable table(Map<Integer, Model> data) {
        DefaultTableModel model = new DefaultTableModel();

        if (!data.isEmpty()) {
            Model firstObject = data.values().iterator().next();
            model.addColumn("ID");
            for (String attributeName : firstObject.getAttributeNames()) {
                model.addColumn(attributeName);
            }
        }

        for (Map.Entry<Integer, Model> entry : data.entrySet()) {
            Model modelObject = entry.getValue();
            Object[] rowData = new Object[model.getColumnCount()];
            rowData[0] = entry.getKey();
            int columnCount = 1;
            for (Object attributeValue : modelObject.getAttributeValues()) {
                rowData[columnCount++] = attributeValue;
            }
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setForeground(TEXT_COLOR);
        table.setBackground(BACKGROUND_COLOR);
        table.setForeground(TEXT_COLOR);
        table.setBackground(BACKGROUND_COLOR);
        table.setGridColor(TEXT_COLOR);

        JTableHeader header = table.getTableHeader();
        header.setForeground(TEXT_COLOR);
        header.setBackground(COLUMN_BACKGROUND_COLOR);

        return table;
    }
}
