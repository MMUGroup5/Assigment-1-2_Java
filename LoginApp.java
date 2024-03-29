import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private LoginCallback loginCallback;

    public void setLoginCallback(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    public interface LoginCallback {
        void onLogin(String username, String userType);
    }
    
    public LoginApp() {

        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 600);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, gbc);

        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        gbc.gridy++;
        add(usernamePanel, gbc);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        gbc.gridy++;
        add(passwordPanel, gbc);

        userTypeComboBox = new JComboBox<>(new String[]{"Student", "Lecturer", "Admin"});
        JPanel userTypePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel userTypeLabel = new JLabel("User Type:");
        userTypePanel.add(userTypeLabel);
        userTypePanel.add(userTypeComboBox);
        gbc.gridy++;
        add(userTypePanel, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String userType = (String) userTypeComboBox.getSelectedItem();
                performLogin(username, password, userType);
            }
        });
        gbc.gridy++;
        add(loginButton, gbc);
    }

    private void performLogin(String username, String password, String userType) {
        switch (userType) {
            case "Admin":
                // Admin login logic
                performAdminLogin(username, password);
                break;
            case "Student":
                // Student login logic
                performStudentLogin(username, password);
                break;
            case "Lecturer":
                // Lecturer login logic
                performLecturerLogin(username, password);
                break;
            default:
                System.out.println("Invalid user type");
        }

        dispose();

        if (loginCallback != null) {
            loginCallback.onLogin(username, userType);
        }
    }

    private void performStudentLogin(String username, String password){};
    private void performAdminLogin(String username, String password){};
    private void performLecturerLogin(String username, String password){};

    
}
