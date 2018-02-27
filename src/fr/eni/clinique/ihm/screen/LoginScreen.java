package fr.eni.clinique.ihm.screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.common.AppConstants;

public class LoginScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7298363167287558010L;

	private JPanel loginPanel;
	private JTextField nomTxt;
	private JPasswordField motPasseTxt;
	private JButton validateButton;
	
    public LoginScreen(String title) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        setTitle(title);
        setUp();
    }
    
    private void setUp() {
        setContentPane(createLoginPanel());
        
        nomTxt = createTextField(AppConstants.EMPTY, "Entrez le nom du personnel ici");
        motPasseTxt = createPasswordField(AppConstants.EMPTY, "Entrez le mot de passe du personnel ici");
        validateButton = new JButton();
        validateButton.setText("Valider");
        
        addFormRow("Nom", nomTxt, 1);
        addFormRow("Mot de passe", motPasseTxt, 2);  
        loginPanel.add(validateButton,createGridBagConstraints(0.7, 1, 3));

    }
    
    private JPanel createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setOpaque(true);
        loginPanel.setLayout(new GridBagLayout());
        return loginPanel;
    }
    
    private void addFormRow(String label, JComponent component, int lineNumber) {
        loginPanel.add(createLabel(label.concat(":")), createGridBagConstraints(0.3, 0, lineNumber));
        loginPanel.add(component, createGridBagConstraints(0.7, 1, lineNumber));
    }
    
    private JLabel createLabel(String text) {
        return new JLabel(text);
    }
    
    private JTextField createTextField(String defaultValue, String tooltip) {
        
        JTextField textField = new JTextField(defaultValue);
        textField.setToolTipText(tooltip);
        return textField;
    }
    
    private JPasswordField createPasswordField(String defaultValue, String tooltip) {
        
        JPasswordField passwordField = new JPasswordField(defaultValue);
        passwordField.setToolTipText(tooltip);
        return passwordField;
    }
    
    private GridBagConstraints createGridBagConstraints(double weight, int cellX, int cellY) {
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.gridx = cellX;
        gridBagConstraints.gridy = cellY;
        gridBagConstraints.weightx = weight;
        
        return gridBagConstraints;
    }
}
