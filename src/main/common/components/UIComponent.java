package main.common.components;

import main.common.Model;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * The UIComponent class provides utility methods for creating and configuring UI components
 * such as panels and tables.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>bigBox() - Creates a large JPanel with specific dimensions and styles.</li>
 *   <li>tableModel(Map&lt;Integer, Model&gt; data) - Creates a JScrollPane containing a table
 *   populated with data from a map.</li>
 *   <li>table(String[] columns, List&lt;Object[]&gt; rows) - Creates a JScrollPane containing a table
 *   populated with specified columns and rows.</li>
 *   <li>scrollPane(JPanel panel) - Creates a JScrollPane containing a specified JPanel.</li>
 *   <li>configureTable(DefaultTableModel model) - Configures the properties of a JTable.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.14
 */
public class UIComponent extends Common {

    /**
     * Creates a large JPanel with specific dimensions and styles.
     *
     * @return A JPanel with predefined dimensions and styles.
     */
    public static JPanel bigBox() {
        int boxPanelHeight = (int) (LayOut.getContentPanel().getHeight() * 0.92);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(LayOut.getContentPanel().getWidth() - 25, boxPanelHeight));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return panel;
    }

    /**
     * Creates a JScrollPane containing a table populated with data from a map.
     *
     * @param data A map containing data to populate the table.
     * @return A JScrollPane containing the populated table.
     */
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

    /**
     * Creates a JScrollPane containing a table populated with specified columns and rows.
     *
     * @param columns An array of column names.
     * @param rows A list of row data.
     * @return A JScrollPane containing the populated table.
     */
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

    /**
     * Creates a JScrollPane containing a specified JPanel.
     *
     * @param panel The JPanel to be contained in the JScrollPane.
     * @return A JScrollPane containing the specified JPanel.
     */
    public static JScrollPane scrollPane(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane;
    }

    /**
     * Configures the properties of a JTable.
     *
     * @param model The table model to be used for the JTable.
     * @return A configured JTable.
     */
    private static JTable configureTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setForeground(TEXT_COLOR);
        table.setBackground(BACKGROUND_COLOR);
        table.setForeground(TEXT_COLOR);
        table.setBackground(BACKGROUND_COLOR);
        table.setGridColor(TEXT_COLOR);
        table.setRowHeight(25);

        JTableHeader header = table.getTableHeader();
        header.setForeground(TEXT_COLOR);
        header.setBackground(COLUMN_BACKGROUND_COLOR);

        table.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)));
        return table;
    }
}
