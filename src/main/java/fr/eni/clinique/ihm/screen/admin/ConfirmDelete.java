package fr.eni.clinique.ihm.screen.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmDelete extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3330276356188474713L;
	private static ConfirmDelete currentInstance;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public ConfirmDelete() {
		currentInstance = this;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lblSouhaitezVousVraiment = new JLabel("Souhaitez vous vraiment supprimer cette personne ?");
			contentPanel.add(lblSouhaitezVousVraiment);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						AdminScreen.getInstance().deletePersonnel();
						ConfirmDelete.getInstance().dispose();
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
					public void mouseClicked(MouseEvent arg0) {
						ConfirmDelete.getInstance().dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}
	
	public static ConfirmDelete getInstance(){
		return currentInstance;
	}

}
