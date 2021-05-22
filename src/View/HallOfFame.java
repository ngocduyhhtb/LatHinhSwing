package View;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class HallOfFame extends JFrame {
    public HallOfFame(String title, ResultSet resultSet) throws HeadlessException {
        super(title);

        JScrollPane scrollPane = new JScrollPane(createTable(resultSet));

        add(createTitle(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 500);
    }

    public void display() {
        setVisible(true);
    }

    private JPanel createTitle() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel titleLabel = new JLabel("ACHIEVEMENT");
        titleLabel.setPreferredSize(new Dimension(300, 50));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);

        return titlePanel;
    }

    private JTable createTable(ResultSet resultSet) {
        Vector<Vector<Object>> row = new Vector<>();
        Vector<Object> title = new Vector<>();
        title.add("ID");
        title.add("User Name");
        title.add("Score");
        title.add("Level");
        try {
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                data.add(resultSet.getString(1));
                data.add(resultSet.getString(2));
                data.add(resultSet.getString(3));
                data.add(resultSet.getString(4));
                row.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new Table(row, title);
    }
}

