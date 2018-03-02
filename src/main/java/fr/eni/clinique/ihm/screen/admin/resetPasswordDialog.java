package fr.eni.clinique.ihm.screen.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.bo.Personnel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class resetPasswordDialog extends JDialog {

	private static resetPasswordDialog currentInstance;
	private final JPanel contentPanel = new JPanel();
	public JPasswordField newPassword;
	public Personnel personnel;

	/**
	 * Create the dialog.
	 */
	public resetPasswordDialog(Personnel personnel) {
		this.personnel = personnel;
		currentInstance = this;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRinitialisationDuMot = new JLabel("R\u00E9initialisation du mot de passe pour : ");
		lblRinitialisationDuMot.setBounds(106, 26, 185, 14);
		contentPanel.add(lblRinitialisationDuMot);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText(this.personnel.getNom());
		lblNewLabel.setBounds(169, 51, 46, 14);
		contentPanel.add(lblNewLabel);

		newPassword = new JPasswordField();
		newPassword.setBounds(154, 76, 86, 20);
		contentPanel.add(newPassword);
		newPassword.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						resetPasswordDialog currentInstance = resetPasswordDialog.getInstance();
						adminScreen mainViewInstance = adminScreen.getInstance();

						if (!(currentInstance.newPassword.getPassword().length == 0)) {
							String newPwString = "";
							for (char car : currentInstance.newPassword.getPassword()) {
								newPwString += car;
							}
							currentInstance.personnel.setMotPasse(newPwString);
							mainViewInstance.resetPassword(currentInstance.personnel);
							currentInstance.dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						resetPasswordDialog currentInstance = resetPasswordDialog.getInstance();
						currentInstance.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			this.setVisible(true);
		}
	}

	protected static resetPasswordDialog getInstance() {
		// TODO Auto-generated method stub
		return currentInstance;
	}
}
