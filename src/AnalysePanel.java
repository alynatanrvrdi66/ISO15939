import javax.swing.*;
import java.awt.*;

public class AnalysePanel extends JPanel {

    private MainFrame frame;

    private JTextArea analysisArea;

    private JButton backButton;

    public AnalysePanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout(20,20));

        setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

        JLabel titleLabel = new JLabel("Quality Analysis", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        add(titleLabel, BorderLayout.NORTH);


        JPanel leftPanel = new JPanel();

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Dimension Scores"),
                        BorderFactory.createEmptyBorder(15,15,15,15)
                )
        );

        leftPanel.add(Box.createVerticalStrut(20));

        String[] scores = {
                "• Usability: 4.5 / 5",
                "• Reliability: 3.2 / 5",
                "• Performance: 4.0 / 5",
                "• Accessibility: 4.7 / 5",
                "• Security: 3.8 / 5",
                "",
                "Strongest Dimension: Accessibility",
                "Weakest Dimension: Reliability"
        };

        for(String text : scores) {

            JLabel label = new JLabel(text);

            label.setFont(new Font("Arial", Font.PLAIN, 17));

            label.setAlignmentX(Component.LEFT_ALIGNMENT);

            leftPanel.add(label);

            leftPanel.add(Box.createVerticalStrut(10));
        }

        RadarChartPanel radarChart = new RadarChartPanel();

        JPanel centerPanel = new JPanel(new GridLayout(1,2,20,20));

        centerPanel.add(leftPanel);
        centerPanel.add(radarChart);

        add(centerPanel, BorderLayout.CENTER);


        analysisArea = new JTextArea();

        analysisArea.setEditable(false);

        analysisArea.setLineWrap(true);

        analysisArea.setWrapStyleWord(true);

        analysisArea.setFont(new Font("Arial", Font.PLAIN, 16));

        analysisArea.setMargin(
                new Insets(15,15,15,15)
        );

        analysisArea.setText(

                "GAP ANALYSIS\n\n" +

                        "The Reliability dimension received the " +
                        "lowest evaluation score among all " +
                        "measured dimensions.\n\n" +

                        "Main issues detected:\n\n" +

                        "- High MTTR values\n" +
                        "- Unstable uptime performance\n" +
                        "- Weak recovery mechanisms\n\n" +

                        "The current reliability score is 3.2 " +
                        "while the target quality level is 5.0.\n\n" +

                        "This creates a quality gap of 1.8 " +
                        "points.\n\n" +

                        "Recommended improvements:\n\n" +

                        "- Improve fault tolerance\n" +
                        "- Optimize recovery workflows\n" +
                        "- Reduce downtime duration\n" +
                        "- Improve monitoring systems\n\n" +

                        "Accessibility achieved the highest " +
                        "score and currently represents the " +
                        "strongest quality dimension."
        );

        JScrollPane scrollPane = new JScrollPane(analysisArea);

        scrollPane.setBorder(BorderFactory.createTitledBorder("Gap Analysis"));

        scrollPane.setPreferredSize(new java.awt.Dimension(300,220));

        add(scrollPane, BorderLayout.SOUTH);


        // BUTTONS
        JPanel buttonPanel = new JPanel();

        backButton = new JButton("Back");

        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.PAGE_END);

        backButton.addActionListener(e -> {
            frame.previousStep();
        });
    }
}