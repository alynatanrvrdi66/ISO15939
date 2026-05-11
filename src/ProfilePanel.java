import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePanel extends JPanel {

    private JTextField usernameField;
    private JTextField schoolField;
    private JTextField sessionField;

    private JButton nextButton;
    private MainFrame frame;

    public ProfilePanel(MainFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        JLabel titleLabel = new JLabel("Profile Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        centerPanel.add(titleLabel, gbc);

        // username
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        centerPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;

        usernameField = new JTextField(15);

        centerPanel.add(usernameField, gbc);


        // school
        gbc.gridx = 0;
        gbc.gridy = 2;

        centerPanel.add(
                new JLabel("School:"),
                gbc
        );

        gbc.gridx = 1;

        schoolField = new JTextField(15);

        centerPanel.add(schoolField, gbc);


        // session
        gbc.gridx = 0;
        gbc.gridy = 3;

        centerPanel.add(
                new JLabel("Session Name:"),
                gbc
        );

        gbc.gridx = 1;

        sessionField = new JTextField(15);

        centerPanel.add(sessionField, gbc);


        // button
        nextButton = new JButton("Next");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        centerPanel.add(nextButton, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // Button Action
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String school = schoolField.getText().trim();
                String session = sessionField.getText().trim();


                if(username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your username.");
                    return;
                }
                if(school.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your school.");
                    return;
                }
                if(session.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your session name.");
                    return;
                }

                // Create user
                User user =
                        new User(username, school, session);

                System.out.println("User Created:");
                System.out.println(user.getUserName());

                frame.nextStep();
            }
        });
        }
    }
