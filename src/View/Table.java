package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

public class Table extends JTable {
    private final Vector<Vector<Object>> vector;

    public Table(Vector<Vector<Object>> vector, Vector<Object> vector1) {
        super(vector, vector1);
        this.vector = vector;
        initGUI();
    }

    private void initGUI() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.setRowHeight(30);
        this.setDefaultRenderer(String.class, centerRenderer);
        this.setDefaultRenderer(Integer.class, centerRenderer);
        this.setFont(new Font("arial", Font.PLAIN, 14));

        JTableHeader header = this.getTableHeader();
        header.setPreferredSize(new Dimension(10, 20));
        header.setFont(new Font("arial", Font.BOLD, 14));
        header.setForeground(Color.decode("#ffffff"));
        header.setOpaque(false);
        header.setBackground(Color.decode("#194d33"));
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        return super.prepareRenderer(renderer, row, col);
    }
}
