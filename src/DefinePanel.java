import javax.swing.*;
import java.awt.*;

public class DefinePanel extends JPanel {
    private MainFrame frame;
    private JRadioButton productButton;
    private JRadioButton processButton;

    private JRadioButton educationButton;
    private JRadioButton healthButton;

    private JComboBox<String> scenarioBox;

    private JButton nextButton;
    private JButton backButton;

    public DefinePanel(MainFrame frame) {
        this.frame = frame;

        setLayout(new GridLayout(12, 1, 10, 10));

        JLabel titleLabel = new JLabel("Quality Definition", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(titleLabel);

        // QUALITY TYPE
        JLabel qualityLabel = new JLabel("Select Quality Type:");

        add(qualityLabel);

        productButton = new JRadioButton("Product Quality");

        processButton = new JRadioButton("Process Quality");

        ButtonGroup qualityGroup = new ButtonGroup();

        qualityGroup.add(productButton);
        qualityGroup.add(processButton);

        add(productButton);
        add(processButton);



        // MODE
        JLabel modeLabel = new JLabel("Select Mode:");

        add(modeLabel);

        educationButton = new JRadioButton("Education");

        healthButton = new JRadioButton("Health");

        ButtonGroup modeGroup = new ButtonGroup();

        modeGroup.add(educationButton);
        modeGroup.add(healthButton);

        add(educationButton);
        add(healthButton);


        // SCENARIO
        JLabel scenarioLabel =
                new JLabel("Select Scenario:");

        add(scenarioLabel);

        scenarioBox = new JComboBox<>();

        add(scenarioBox);

        educationButton.addActionListener(e -> {

            scenarioBox.removeAllItems();

            scenarioBox.addItem(
                    "Scenario C - Team Alpha"
            );

            scenarioBox.addItem(
                    "Scenario D - Team Beta"
            );
        });


        // Health scenarios
        healthButton.addActionListener(e -> {

            scenarioBox.removeAllItems();

            scenarioBox.addItem(
                    "Scenario A - Hospital System"
            );

            scenarioBox.addItem(
                    "Scenario B - Clinic System"
            );
        });


        // Buttons
        backButton = new JButton("Back");
        nextButton = new JButton("Next");

        add(backButton);
        add(nextButton);

        backButton.addActionListener(e -> {
            frame.previousStep();
        });

        nextButton.addActionListener(e -> {
            frame.nextStep();
        });
    }
}