package fr.eni.clinique.ihm.screen.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Personnel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPersonnelScreen {

	public JFrame frmAjouterDuPersonnel;
	private JTextField name;
	private JPasswordField pw;
	private JComboBox<String> role;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPersonnelScreen window = new AddPersonnelScreen();
					window.frmAjouterDuPersonnel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPersonnelScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterDuPersonnel = new JFrame();
		frmAjouterDuPersonnel.setTitle("Ajouter du personnel");
		frmAjouterDuPersonnel.setResizable(false);
		frmAjouterDuPersonnel.setType(Type.POPUP);
		frmAjouterDuPersonnel.setBounds(100, 100, 545, 388);
		frmAjouterDuPersonnel.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(194, 37, 46, 14);
		frmAjouterDuPersonnel.getContentPane().add(lblNom);
		
		name = new JTextField();
		name.setBounds(250, 34, 86, 20);
		frmAjouterDuPersonnel.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblRole = new JLabel("Role : ");
		lblRole.setBounds(194, 62, 46, 14);
		frmAjouterDuPersonnel.getContentPane().add(lblRole);
		
		JLabel lblNewLabel = new JLabel("Mot de passe :");
		lblNewLabel.setBounds(169, 87, 71, 14);
		frmAjouterDuPersonnel.getContentPane().add(lblNewLabel);
		
		pw = new JPasswordField();
		pw.setBounds(250, 84, 86, 20);
		frmAjouterDuPersonnel.getContentPane().add(pw);
		
		role = new JComboBox<String>();
		role.setModel(new DefaultComboBoxModel<String>(new String[] {"vet", "sec", "adm"}));
		role.setSelectedIndex(0);
		role.setBounds(250, 59, 86, 20);
		frmAjouterDuPersonnel.getContentPane().add(role);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!name.getText().equals("") && !(pw.getPassword().length==0)){
					Personnel newPersonnel = new Personnel();
					newPersonnel.setNom(name.getText());
					newPersonnel.setRole((String) role.getSelectedItem());
					String pwString = "";
					for(char car : pw.getPassword()){
						pwString += car;
					}
					newPersonnel.setMotPasse(pwString);
					newPersonnel.setArchive(false);
					AdminScreen.getInstance().addPersonnel(newPersonnel);
					name.setText("");
					pw.setText("");
				}
			}
		});
		btnAjouter.setBounds(247, 135, 89, 23);
		frmAjouterDuPersonnel.getContentPane().add(btnAjouter);
	}
}
