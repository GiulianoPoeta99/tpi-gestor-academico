package common.components;

import common.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CommonComponent {
    public static final Color TEXT_COLOR = Color.decode("#CCCCCC");

    public static JLabel h1(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font("Arial", Font.BOLD, 24)); // Tamaño y tipo de fuente para H1
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente
        return label;
    }

     public static JPanel bigBox() {
        int boxPanelHeight = (int) (LayOutComponent.getContentPanel().getHeight() * 0.92); // 80% del alto del contentPanel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(LayOutComponent.getContentPanel().getWidth() - 25, boxPanelHeight));
        panel.setBackground(Color.decode("#222222"));
        return panel;
    }

    public static final Color BACKGROUND_COLOR = Color.decode("#222222");
    public static final Color COLUMN_BACKGROUND_COLOR = Color.decode("#333333");

    public static JTable table(Map<Integer, Model> data) {
        // Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel();

        // Agregar columnas basadas en los atributos del primer objeto en el mapa
        if (!data.isEmpty()) {
            Model firstObject = data.values().iterator().next();
            model.addColumn("ID");
            for (String attributeName : firstObject.getAttributeNames()) {
                model.addColumn(attributeName);
            }
        }

        // Agregar filas al modelo
        for (Map.Entry<Integer, Model> entry : data.entrySet()) {
            Model modelObject = entry.getValue();
            Object[] rowData = new Object[model.getColumnCount()];
            rowData[0] = entry.getKey(); // ID en la primera columna
            int columnCount = 1;
            for (Object attributeValue : modelObject.getAttributeValues()) {
                rowData[columnCount++] = attributeValue;
            }
            model.addRow(rowData);
        }

        // Crear y configurar la tabla
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setForeground(TEXT_COLOR); // Establecer color de la fuente
        table.setBackground(BACKGROUND_COLOR); // Establecer color de fondo

        // Configurar color de fondo y fuente de las columnas
        JTableHeader header = table.getTableHeader();
        header.setForeground(TEXT_COLOR); // Color de la fuente de las columnas
        header.setBackground(COLUMN_BACKGROUND_COLOR); // Color de fondo de las columnas

        return table;
    }
}