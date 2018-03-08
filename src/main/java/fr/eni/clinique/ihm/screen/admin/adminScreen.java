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

import fr.eni.clinique.bll.exception.BLLException;
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
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConfirmDelete();
			}
		});
		delete.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/minus.png")));
		panel.add(delete);

		JButton resetPassword = new JButton("Réinitialiser");
		resetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminScreen instance = adminScreen.getInstance();
				
				new resetPasswordDialog(instance.personnels.get(instance.table.getSelectedRow()));
			}
		});
		resetPassword.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/unlock.png")));
		panel.add(resetPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 170, 606, 310);
		frmGestionDuPersonnel.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		String[] identifier = {"Nom", "Role", "Mot de passe"};
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(0, 0, 606, 310);
		
		this.tableModel = new DefaultTableModel() {

			   @Override
			   public boolean isCellEditable(int row, int column) {
			       
			       return false;
			   }
		};
		this.tableModel.setColumnIdentifiers(identifier);
		this.table.setModel(this.tableModel);
		
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
			//System.out.println(personnel);
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
		try {
			this.personnelListener.newPersonnel(personnel);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void deletePersonnel(){
		try {
			this.personnelListener.deletePersonnel(this.personnels.get(this.table.getSelectedRow()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void resetPassword(Personnel personnel){
		try {
			this.personnelListener.resetPwdPersonnel(personnel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
