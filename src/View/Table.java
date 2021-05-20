package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

public class Table extends JTable {
    private final Vector<Vector<Object>> vector;

    public Table(Vector<Vector<Object>> vector, Vector<Object> vector1)
    {
        super(vector, vector1);
        this.vector = vector;
        initGUI();
    }

    private void initGUI()
    {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.setRowHeight(30);
        this.setDefaultRenderer(String.class, centerRenderer);
        this.setDefaultRenderer(Integer.class, centerRenderer);
        this.setFont(new Font("arial", Font.PLAIN, 20));

        JTableHeader header = this.getTableHeader();
        header.setPreferredSize(new Dimension(10, 40));
        header.setFont(new Font("arial", Font.BOLD, 20));
        header.setOpaque(false);
        header.setBackground(Color.blue);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int col)
    {
        Component comp = super.prepareRenderer(renderer, row, col);

        return comp;
    }
}
