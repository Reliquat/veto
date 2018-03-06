package fr.eni.clinique.ihm.screen.client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.listener.ClientActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ScreenRechercheClient {

	private JFrame frmRechercher;
	private JTextField txtRechercher;
	private ScreenClient screenClient;
	private ClientActionListener actionListener;
	private JTable table;
	private List<Client> resultSearch; 
	private DefaultTableModel tableModel;
	
	/**
	 * Create the application.
	 */
	public ScreenRechercheClient(ClientActionListener actionListener) {
		this.screenClient = ScreenClient.getInstance();
		this.actionListener = actionListener;
		this.actionListener.setRecherche(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmRechercher = new JFrame();
		frmRechercher.setResizable(false);
		frmRechercher.setAlwaysOnTop(true);
		frmRechercher.setTitle("R\u00E9sultat de la recherche");
		frmRechercher.setBounds(100, 100, 720, 500);
		frmRechercher.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nom du client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Nom du client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Nom du client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 684, 78);
		frmRechercher.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btwRechercher = new JButton("Rechercher");
		btwRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(txtRechercher.getText());
				actionListener.RechercherClientScreen(txtRechercher.getText());
			}
		});
		btwRechercher.setBounds(573, 11, 101, 56);

		panel.add(btwRechercher);
		
		txtRechercher = new JTextField();
		txtRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		txtRechercher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRechercher.setBounds(10, 24, 553, 31);
		panel.add(txtRechercher);
		txtRechercher.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(10, 100, 684, 350);
		frmRechercher.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					Client selectedClient = resultSearch.get(table.getSelectedRow());
					screenClient.update(null, selectedClient);
					frmRechercher.dispose();
				}
			}
		});
		this.tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nom", "Code postal", "Ville"
				}
			){
			@Override
			   public boolean isCellEditable(int row, int column) {
			       
			       return false;
			   }
		};
		table.setModel(this.tableModel);
		
		table.setBounds(10, 11, 664, 328);
		panel_1.add(table);
		this.frmRechercher.setVisible(true);
	}
	
	public void setResult(List<Client> clients) {
		this.resultSearch = clients;
		this.tableModel.setRowCount(0);
		
		System.out.println(this.getClass()+" "+clients);
		
		for(Client client : this.resultSearch){
			System.out.println("Dans le for.");
			this.tableModel.addRow(new String[]{client.getNomClient()+ ' ' + client.getPrenomClient(), client.getCodePostal(), client.getVille()});
		}
		
	}
}
