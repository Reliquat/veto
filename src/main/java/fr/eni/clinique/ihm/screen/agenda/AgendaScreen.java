 package fr.eni.clinique.ihm.screen.agenda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class AgendaScreen extends JFrame {

	private JPanel contentPane;
	private JTable rdvTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaScreen frame = new AgendaScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgendaScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "De", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(10, 11, 637, 80);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("V\u00E9t\u00E9rinaire");
		panel.add(lblNewLabel);
		
		JComboBox listeVeto = new JComboBox();
		panel.add(listeVeto);
		
		JLabel lblDate = new JLabel("Date");
		panel.add(lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 637, 276);
		contentPane.add(scrollPane);
		
		rdvTable = new JTable();
		rdvTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Heure", "Nom du client", "Animal", "Race"
			}
		));
		scrollPane.setViewportView(rdvTable);
		
		JButton dossierMedical = new JButton("Dossier m\u00E9dical");
		dossierMedical.setBounds(516, 399, 131, 38);
		contentPane.add(dossierMedical);
	}
}
