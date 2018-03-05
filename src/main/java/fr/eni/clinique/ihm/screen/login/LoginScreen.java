package fr.eni.clinique.ihm.screen.login;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.ihm.controller.LoginController;
import fr.eni.clinique.ihm.listener.LoginActionListener;
import fr.eni.clinique.ihm.model.LoginModel;

public class LoginScreen extends JFrame {

	private LoginActionListener actionListener;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7298363167287558010L;

	private JPanel loginPanel;
	private JTextField nomTxt;
	private JPasswordField motPasseTxt;
	private JButton validateButton;
	private static LoginScreen window;
	private Personnel personnel;
	private LoginController loginController;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LoginModel loginModel = new LoginModel();
					LoginController loginController = new LoginController(loginModel);

					window = new LoginScreen(AppConstants.APP_NAME);
					window.setLocationRelativeTo(null);
					window.setVisible(true);

					window.setActionListener(loginController);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		// <<
		validateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionListener != null) {
					ConnexionPage();
				}
			}
		});
		// >>

		addFormRow("Nom", nomTxt, 1);
		addFormRow("Mot de passe", motPasseTxt, 2);
		loginPanel.add(validateButton, createGridBagConstraints(0.7, 1, 3));

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

	/*
	 * private void ConnexionPage(){
	 * 
	 * //actionListener.ConnexionPage(nomTxt.getText().trim(),
	 * motPasseTxt.getText().trim()); window.dispose();
	 * 
	 * }
	 */

	public void setActionListener(LoginActionListener actionListener) {

		if (actionListener != null) {

			this.actionListener = actionListener;
		}
	}

	private void ConnexionPage() {
		
		LoginModel loginModel = new LoginModel();
		LoginController loginController = new LoginController(loginModel);
		
		String pwString = "";
		for (char car : motPasseTxt.getPassword()) {
			
			pwString += car;
		}
		this.personnel = loginController.ConnexionPage(nomTxt.getText(), pwString);
		if (loginController != null) {
			setVisible(false);
			dispose();
		}
	}
}
