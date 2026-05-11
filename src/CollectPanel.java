import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CollectPanel extends JPanel {
    private MainFrame frame;
    private JTable collectTable;
    private DefaultTableModel tableModel;

    private JButton backButton;
    private JButton nextButton;

    public CollectPanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Data Collection", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLabel, BorderLayout.NORTH);

        String[] columns = {
                "Metric",
                "Direction",
                "Range",
                "Value",
                "Score (1-5)",
                "Coeff / Unit"
        };

        tableModel = new DefaultTableModel(columns, 0);

        collectTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(collectTable);

        add(scrollPane, BorderLayout.CENTER);

        tableModel.addRow(new Object[] {
                "SUS Score",
                "Higher",
                "0-100",
                89,
                5,
                "50 / points"
        });

        tableModel.addRow(new Object[] {
                "Onboarding Time",
                "Lower",
                "0-60",
                5,
                5,
                "50 / minutes"
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
