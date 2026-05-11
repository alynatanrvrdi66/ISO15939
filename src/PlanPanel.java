import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlanPanel extends JPanel {
    private MainFrame frame;
    private JTable metricTable;
    private DefaultTableModel tableModel;

    private JButton backButton;
    private JButton nextButton;

    public PlanPanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Measurement Planning", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLabel, BorderLayout.NORTH);

        String[] columns = {
                "Metric",
                "Coefficient",
                "Direction",
                "Range",
                "Unit"
        };

        tableModel = new DefaultTableModel(columns, 0);
        metricTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(metricTable);

        add(scrollPane, BorderLayout.CENTER);

        tableModel.addRow(new Object[] {
                "SUS Score",
                50,
                "Higher",
                "0-100",
                "points"
        });

        tableModel.addRow(new Object[] {
                "Onboarding Time",
                50,
                "Lower",
                "0-60",
                "minutes"
        });

        JPanel buttonPanel = new JPanel();

        backButton = new JButton("Back");
        nextButton = new JButton("Next");

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            frame.previousStep();
        });

        nextButton.addActionListener(e -> {
            frame.nextStep();
        });
    }
}
