package fr.eni.clinique.ihm.screen.rdv;

import java.awt.EventQueue;
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



import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		addClientBtn.setBounds(170, 53, 63, 23);
		panel.add(addClientBtn);
		
		JButton addAnimalButton = new JButton("Plus");
		addAnimalButton.setBounds(170, 97, 63, 23);
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
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		AbstractFormatter labelFormatter = new AbstractFormatter(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String datePattern = "yyyy-MM-dd";
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
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, labelFormatter);
		
		datePicker.setSize(203, 32);
		datePicker.setLocation(43, 62);
		
		panel_2.add(datePicker);
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(43, 105, 46, 14);
		panel_2.add(lblHeure);
		
		JComboBox heureCombo = new JComboBox();
		heureCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		heureCombo.setBounds(21, 120, 68, 20);
		panel_2.add(heureCombo);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(110, 123, 15, 14);
		panel_2.add(lblH);
		
		JComboBox minuteCombo = new JComboBox();
		minuteCombo.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
		minuteCombo.setBounds(135, 120, 46, 20);
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
