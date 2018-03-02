package fr.eni.clinique.ihm.screen.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.listener.PersonnelActionListener;
import java.awt.Color;

public class adminScreen implements Observer {

	private static adminScreen actualInstance;
	public JFrame frmGestionDuPersonnel;
	private JTable table;
	private DefaultTableModel tableModel;
	private PersonnelActionListener personnelListener;
	private ArrayList<Personnel> personnels = new ArrayList<>();

	/**
	 * Create the application.
	 */
	public adminScreen() {
		actualInstance = this;
		initialize();
	}
	
	public static adminScreen getInstance(){
		return actualInstance;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuPersonnel = new JFrame();
		frmGestionDuPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuPersonnel.setResizable(false);
		frmGestionDuPersonnel.setTitle("Gestion du personnel");
		frmGestionDuPersonnel.setBounds(100, 100, 632, 520);
		frmGestionDuPersonnel.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 606, 129);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmGestionDuPersonnel.getContentPane().add(panel);

		JButton addPersonnel = new JButton("Ajouter");
		addPersonnel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddPersonnelScreen addScreen = new AddPersonnelScreen();
				addScreen.frmAjouterDuPersonnel.setVisible(true);
			}
		});
		addPersonnel.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/plus.png")));
		panel.add(addPersonnel);

		JButton delete = new JButton("Supprimer");
		delete.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/minus.png")));
		panel.add(delete);

		JButton btnNewButton = new JButton("Réinitialiser");
		btnNewButton.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/unlock.png")));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 170, 606, 310);
		frmGestionDuPersonnel.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		String[] identifier = {"Nom", "Role", "Mot de passe"};
		table = new JTable();
		table.setBounds(0, 0, 606, 310);
		this.tableModel = (DefaultTableModel) table.getModel();
		this.tableModel.setColumnIdentifiers(identifier);
		tableModel.fireTableDataChanged();
		panel_1.add(table);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable observable, Object personnels) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		if (personnels instanceof ArrayList<?>) {
			refresh((ArrayList<Personnel>) personnels);
		}

	}

	private void refresh(ArrayList<Personnel> personnels) {
		this.personnels.clear();
		this.personnels.addAll(personnels);
		this.tableModel.setRowCount(0);
		for (Personnel personnel : this.personnels) {
			System.out.println(personnel);
			String[] dataTable = { personnel.getNom(), personnel.getRole(), personnel.getMotPasse() };
			this.tableModel.addRow(dataTable);
		}
		this.table.setModel(tableModel);
		this.tableModel.fireTableDataChanged();
	}

	public void setActionListener(PersonnelActionListener personnelListener) {

		if (personnelListener != null) {

			this.personnelListener = personnelListener;

			try {

				// Fire Initialisation Event.
				this.personnelListener.init();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void addPersonnel(Personnel personnel){
		ArrayList<Personnel> addReturn = new ArrayList<>();
		addReturn.addAll(this.personnels);
		addReturn.add(personnel);
		this.update(null, addReturn);
	}
}
