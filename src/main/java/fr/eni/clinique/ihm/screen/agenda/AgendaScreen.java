 package fr.eni.clinique.ihm.screen.agenda;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.clinique.ihm.controller.PersonnelController;
import fr.eni.clinique.ihm.model.PersonnelModel;

public class AgendaScreen implements Observer {
	
	private static AgendaScreen actualInstance;
	public JFrame frmAgenda;
	private JPanel contentPane;
	private JTable rdvTable;
	private AbstractFormatter tableModel;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JComboBox listeVeto;
	private PersonnelDAOJdbcImpl personnelDao;
	private PersonnelModel personnelModel;
	private PersonnelController personnelControl;

	/**
	 * Launch the application.
	 */
	public AgendaScreen() {
		actualInstance = this;
		initialize();
	}
	
	public static AgendaScreen getInstance(){
		return actualInstance;
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		frmAgenda = new JFrame();
		frmAgenda.setTitle("Agenda");
		frmAgenda.setResizable(false);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.setBounds(100, 100, 673, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAgenda.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		personnelModel = new PersonnelModel();
		personnelControl = new PersonnelController(personnelModel);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "De", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(10, 11, 637, 80);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("V\u00E9t\u00E9rinaire");
		panel.add(lblNewLabel);
		
		
		
		String[] test = {"oui","non","wesh"};
		listeVeto = new JComboBox();
		listeVeto.add(string);
		listeVeto.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				rechercheRdv();
			}
		});
		
		panel.add(listeVeto);
		
		JLabel lblDate = new JLabel("Date");
		panel.add(lblDate);
		
		
		this.tableModel = new AbstractFormatter() {
			
			private String datePattern = "yyyy-MM-dd";
		    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		    public Object stringToValue(String text) throws ParseException {
		        return dateFormatter.parseObject(text);
		    }

		    public String valueToString(Object value) throws ParseException {
		        if (value != null) {
		            Calendar cal = (Calendar) value;
		            return dateFormatter.format(cal.getTime());
		        }

		        return "";
		    }
		};
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, this.tableModel);
        datePicker.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rechercheRdv();
			}
		});
        
        panel.add(datePicker);
		
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
		
		JButton btnDossierMedical = new JButton("Dossier m\u00E9dical");
		btnDossierMedical.setBounds(516, 399, 131, 38);
		btnDossierMedical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Dossier medical");
				DossierMedicalScreen dossierScreen = new DossierMedicalScreen();
				dossierScreen.frmDossierMedical.setVisible(true);
			}
		});
		contentPane.add(btnDossierMedical);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void rechercheRdv(){
		
		System.out.println(listeVeto.getSelectedItem().toString()+" "+datePicker.getJFormattedTextField().getText());
		
	}
}
