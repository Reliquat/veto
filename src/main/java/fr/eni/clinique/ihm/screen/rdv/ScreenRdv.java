package fr.eni.clinique.ihm.screen.rdv;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.listener.RdvActionListener;
import fr.eni.clinique.ihm.screen.client.ScreenAjoutClient;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class ScreenRdv extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Client> clients;
	private List<Personnel> vetos;
	
	private JComboBox clientCombo;
	private JComboBox animalCombo;
	private JComboBox vetoCombo;
	private DefaultTableModel tableModel;
	private static ScreenRdv curInstance;
	private RdvActionListener actionListener;
	private JDatePickerImpl datePicker;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

	public static ScreenRdv getInstance() {

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
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Pour", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 256, 171);
		contentPane.add(panel);
		panel.setLayout(null);

		clientCombo = new JComboBox();
		clientCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshAnimalCombo(clients.get(clientCombo.getSelectedIndex()));
			}
		});
		clientCombo.setBounds(47, 54, 113, 20);
		panel.add(clientCombo);

		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(49, 42, 46, 14);
		panel.add(lblClient);

		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(47, 85, 46, 14);
		panel.add(lblAnimal);

		animalCombo = new JComboBox();
		animalCombo.setBounds(47, 98, 113, 20);
		panel.add(animalCombo);

		JButton addClientBtn = new JButton("Plus");
		addClientBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ScreenAjoutClient();
			}
		});
		addClientBtn.setBounds(170, 53, 63, 23);
		panel.add(addClientBtn);

		JButton addAnimalButton = new JButton("Plus");
		addAnimalButton.setBounds(170, 97, 63, 23);
		panel.add(addAnimalButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Par", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(276, 11, 256, 171);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblVtrinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVtrinaire.setBounds(37, 46, 58, 14);
		panel_1.add(lblVtrinaire);

		vetoCombo = new JComboBox();
		

		vetoCombo.setBounds(37, 60, 120, 20);
		panel_1.add(vetoCombo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Quand", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(542, 11, 256, 171);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(43, 37, 46, 14);
		panel_2.add(lblDate);

		UtilDateModel model = new UtilDateModel();
		model.setDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.MONTH, Calendar.DAY_OF_MONTH);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		AbstractFormatter labelFormatter = new AbstractFormatter() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String datePattern = "dd/MM/yyyy";
			private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

			@Override
			public Object stringToValue(String text) throws ParseException {
				return dateFormatter.parseObject(text);
			}

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null) {
					Calendar cal = (Calendar) value;
					return dateFormatter.format(cal.getTime());
				}

				return "";
			}

		};
		datePicker = new JDatePickerImpl(datePanel, labelFormatter);

		datePicker.setSize(203, 32);
		datePicker.setLocation(43, 62);

		panel_2.add(datePicker);
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(43, 105, 46, 14);
		panel_2.add(lblHeure);

		JComboBox heureCombo = new JComboBox();
		heureCombo.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		heureCombo.setBounds(21, 120, 68, 20);
		panel_2.add(heureCombo);

		JLabel lblH = new JLabel("h");
		lblH.setBounds(110, 123, 15, 14);
		panel_2.add(lblH);

		JComboBox minuteCombo = new JComboBox();
		minuteCombo.setModel(new DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));
		minuteCombo.setBounds(135, 120, 46, 20);
		panel_2.add(minuteCombo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 788, 257);
		contentPane.add(scrollPane);

		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Heure", "Nom du client", "Race", "Animal" });
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(542, 473, 181, 33);
		contentPane.add(panel_3);

		JButton btnSupprimer = new JButton("Supprimer");
		panel_3.add(btnSupprimer);

		JButton btnValider = new JButton("Valider");
		panel_3.add(btnValider);
		this.setVisible(true);
	}

	public void init(List<Client> clients, List<Personnel> vetos) {
		System.out.println(clients);
		System.out.println(vetos);
		this.clients = clients;

		this.clientCombo.removeAllItems();
		for (Client client : clients) {
			clientCombo.addItem(client.getNomClient() + " " + client.getPrenomClient());
		}

		this.vetos = vetos;
		this.vetoCombo.removeAllItems();

		for (Personnel veto : vetos) {
			this.vetoCombo.addItem(veto.getNom());
		}
		refreshAnimalCombo(this.clients.get(1));
		vetoCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					try {
						System.out.println(vetoCombo.getSelectedIndex());
						System.out.println(vetos);
						System.out.println(vetos.get(vetoCombo.getSelectedIndex()));
						actionListener.getRdvJour(vetos.get(vetoCombo.getSelectedIndex()),
								dateFormatter.parse(datePicker.getJFormattedTextField().getText()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void setAgenda(Personnel personnel) {
		// TODO Auto-generated method stub
		this.tableModel.setRowCount(0);
		for (Agenda rdv : personnel.getRdv()) {
			String[] infoRdv = { rdv.getDateRdv().getHours() + ":" + rdv.getDateRdv().getMinutes(),
					rdv.getAnimal().getClient().getNomClient() + " "
							+ rdv.getAnimal().getClient().getPrenomClient(),
					rdv.getAnimal().getRace(), rdv.getAnimal().getNomAnimal() };
			this.tableModel.addRow(infoRdv);
		}
		this.table.setModel(this.tableModel);
		this.tableModel.fireTableDataChanged();
	}

	public void setActionListener(RdvActionListener personnelController) {
		// TODO Auto-generated method stub
		this.actionListener = personnelController;
	}

	public void refreshAnimalCombo(Client client) {
		this.animalCombo.removeAllItems();
		for (Animal animal : client.getAnimaux()) {
			this.animalCombo.addItem(animal.getNomAnimal());
		}
	}
	public void addClient(Client client){
		this.clientCombo.addItem(client.getNomClient() + " " +client.getPrenomClient());
		this.clientCombo.setSelectedIndex(this.clients.size());
		this.clients.add(client);
	}
}
