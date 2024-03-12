package common.components;

import common.Model;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class UIComponent extends Common {
    public static JPanel bigBox() {
        int boxPanelHeight = (int) (LayOut.getContentPanel().getHeight() * 0.92);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(LayOut.getContentPanel().getWidth() - 25, boxPanelHeight));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar borde vacío de 5 píxeles
        return panel;
    }

    public static JScrollPane tableModel(Map<Integer, Model> data) {
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

        JTable table = configureTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        return scrollPane;
    }

    public static JScrollPane table(String[] columns, List<Object[]> rows) {
        DefaultTableModel model = new DefaultTableModel();

        for (String columnName : columns) {
            model.addColumn(columnName);
        }

        for (Object[] rowData : rows) {
            model.addRow(rowData);
        }

        JTable table = configureTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        return scrollPane;
    }

    private static JTable configureTable(DefaultTableModel model) {
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

        // Agregar borde alrededor de la tabla
        table.setBorder(new CompoundBorder(
            new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
            new EmptyBorder(5, 5, 5, 5)
        ));
        return table;
    }
}
