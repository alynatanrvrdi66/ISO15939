import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private int currentStep;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private ProfilePanel profilePanel;
    private DefinePanel definePanel;
    private PlanPanel planPanel;
    private CollectPanel collectPanel;
    private AnalysePanel analysePanel;
    private StepIndicatorPanel stepIndicator;


    public MainFrame() {
        setTitle("ISO 15939 Measurement Simulator");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        stepIndicator = new StepIndicatorPanel();

        currentStep = 1;

        profilePanel = new ProfilePanel(this);
        definePanel = new DefinePanel(this);
        planPanel = new PlanPanel(this);
        collectPanel = new CollectPanel(this);
        analysePanel = new AnalysePanel(this);

        mainPanel.add(profilePanel, "PROFILE");
        mainPanel.add(definePanel, "DEFINE");
        mainPanel.add(planPanel, "PLAN");
        mainPanel.add(collectPanel, "COLLECT");
        mainPanel.add(analysePanel, "ANALYSE");

        setLayout(new BorderLayout());

        add(stepIndicator, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "PROFILE");
        setVisible(true);
    }
    public void nextStep() {
        currentStep++;
        switch (currentStep) {

            case 2:
                cardLayout.show(mainPanel, "DEFINE");
                break;

            case 3:
                cardLayout.show(mainPanel, "PLAN");
                break;

            case 4:
                cardLayout.show(mainPanel, "COLLECT");
                break;

            case 5:
                cardLayout.show(mainPanel, "ANALYSE");
                break;
        }
        stepIndicator.updateSteps(currentStep);
    }
    public void previousStep() {
        currentStep--;
        switch (currentStep) {

            case 1:
                cardLayout.show(mainPanel, "PROFILE");
                break;

            case 2:
                cardLayout.show(mainPanel, "DEFINE");
                break;

            case 3:
                cardLayout.show(mainPanel, "PLAN");
                break;

            case 4:
                cardLayout.show(mainPanel, "COLLECT");
                break;
        }
        stepIndicator.updateSteps(currentStep);
    }
    public int getCurrentStep() {
        return currentStep;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
