package fr.eni.clinique.ihm.screen.rdv;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import javafx.scene.control.DatePicker;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenRdv extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Client> clients;
	private List<Personnel> vetos;
	private static ScreenRdv curInstance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenRdv frame = new ScreenRdv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ScreenRdv getInstance(){
		
		return curInstance;
	}
	
	/**
	 * Create the frame.
	 */
	public ScreenRdv() {
		curInstance = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Pour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 256, 171);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox clientCombo = new JComboBox();
		clientCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		clientCombo.setBounds(47, 54, 28, 20);
		panel.add(clientCombo);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(49, 42, 46, 14);
		panel.add(lblClient);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(47, 85, 46, 14);
		panel.add(lblAnimal);
		
		JComboBox animalCombo = new JComboBox();
		animalCombo.setBounds(47, 98, 28, 20);
		panel.add(animalCombo);
		
		JButton addClientBtn = new JButton("Plus");
		addClientBtn.setBounds(170, 53, 51, 23);
		panel.add(addClientBtn);
		
		JButton addAnimalButton = new JButton("Plus");
		addAnimalButton.setBounds(170, 97, 51, 23);
		panel.add(addAnimalButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Par", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(276, 11, 256, 171);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVtrinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVtrinaire.setBounds(37, 46, 58, 14);
		panel_1.add(lblVtrinaire);
		
		JComboBox vetoCombo = new JComboBox();
		vetoCombo.setBounds(37, 60, 28, 20);
		panel_1.add(vetoCombo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Quand", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(542, 11, 256, 171);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(43, 37, 46, 14);
		panel_2.add(lblDate);
		
		
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(43, 105, 46, 14);
		panel_2.add(lblHeure);
		
		JComboBox heureCombo = new JComboBox();
		heureCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		heureCombo.setBounds(43, 120, 37, 20);
		panel_2.add(heureCombo);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(83, 123, 15, 14);
		panel_2.add(lblH);
		
		JComboBox minuteCombo = new JComboBox();
		minuteCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
		minuteCombo.setBounds(90, 120, 37, 20);
		panel_2.add(minuteCombo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 788, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Heure", "Nom du client", "Race", "Animal"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(542, 473, 181, 33);
		contentPane.add(panel_3);
		
		JButton btnSupprimer = new JButton("Supprimer");
		panel_3.add(btnSupprimer);
		
		JButton btnValider = new JButton("Valider");
		panel_3.add(btnValider);
	}
	
	public void init(List<Client> clients, List<Personnel> vetos){
		this.clients = clients;
		this.vetos = vetos;
	}

	public void setAgenda(Personnel personnel) {
		// TODO Auto-generated method stub
		
	}
}
