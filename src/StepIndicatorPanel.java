import javax.swing.*;
import java.awt.*;

public class StepIndicatorPanel extends JPanel {

    private JLabel profileLabel;
    private JLabel defineLabel;
    private JLabel planLabel;
    private JLabel collectLabel;
    private JLabel analyseLabel;

    public StepIndicatorPanel() {

        setLayout(new GridLayout(1, 5));

        profileLabel = new JLabel("Profile", SwingConstants.CENTER);
        defineLabel = new JLabel("Define", SwingConstants.CENTER);
        planLabel = new JLabel("Plan", SwingConstants.CENTER);
        collectLabel = new JLabel("Collect", SwingConstants.CENTER);
        analyseLabel = new JLabel("Analyse", SwingConstants.CENTER);

        Font font = new Font("Arial", Font.BOLD, 15);

        profileLabel.setFont(font);
        defineLabel.setFont(font);
        planLabel.setFont(font);
        collectLabel.setFont(font);
        analyseLabel.setFont(font);

        add(profileLabel);
        add(defineLabel);
        add(planLabel);
        add(collectLabel);
        add(analyseLabel);

        updateSteps(1);
    }

    public void updateSteps(int currentStep) {

        resetColors();

        if(currentStep >= 1)
            profileLabel.setForeground(Color.GREEN);

        if(currentStep >= 2)
            defineLabel.setForeground(Color.GREEN);

        if(currentStep >= 3)
            planLabel.setForeground(Color.GREEN);

        if(currentStep >= 4)
            collectLabel.setForeground(Color.GREEN);

        if(currentStep >= 5)
            analyseLabel.setForeground(Color.GREEN);


        switch(currentStep) {

            case 1:
                profileLabel.setForeground(Color.BLUE);
                break;

            case 2:
                defineLabel.setForeground(Color.BLUE);
                break;

            case 3:
                planLabel.setForeground(Color.BLUE);
                break;

            case 4:
                collectLabel.setForeground(Color.BLUE);
                break;

            case 5:
                analyseLabel.setForeground(Color.BLUE);
                break;
        }
    }

    private void resetColors() {

        profileLabel.setForeground(Color.GRAY);
        defineLabel.setForeground(Color.GRAY);
        planLabel.setForeground(Color.GRAY);
        collectLabel.setForeground(Color.GRAY);
        analyseLabel.setForeground(Color.GRAY);
    }
}