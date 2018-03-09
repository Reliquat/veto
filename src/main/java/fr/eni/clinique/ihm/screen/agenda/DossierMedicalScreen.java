package fr.eni.clinique.ihm.screen.agenda;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.ihm.controller.AnimalController;
import fr.eni.clinique.ihm.controller.ClientController;
import fr.eni.clinique.ihm.listener.AgendaActionListener;

public class DossierMedicalScreen {

	public JFrame frmDossierMedical;
	private JTextField codeAnimalTxt;
	private JTextField nomAnimalTxt;
	private JTextField couleurAnimalTxt;
	private JTextField sexeAnimalTxt;
	private JTextField especeAnimalTxt;
	private JTextField tatouageAnimalTxt;
	private JTextField nomClientTxt;
	private JTextField prenomClientTxt;
	private JTextArea antecedentsAnimalTxt;
	private AgendaActionListener agendaActionListener;
	private AnimalController animalController;
	private Animal animal;
	private int codeAnimal;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DossierMedicalScreen window = new DossierMedicalScreen();
					window.frmDossierMedical.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DossierMedicalScreen(int code) {
		
		animalController = new AnimalController();
		this.codeAnimal = code;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		animal = animalController.getAnimalById(codeAnimal);
		
		frmDossierMedical = new JFrame();
		frmDossierMedical.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDossierMedical.setTitle("Dossier m\u00E9dical");
		frmDossierMedical.setBounds(100, 100, 673, 487);
		frmDossierMedical.getContentPane().setLayout(null);
		
		JPanel panelHotBar = new JPanel();
		panelHotBar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHotBar.setBounds(10, 11, 637, 67);
		frmDossierMedical.getContentPane().add(panelHotBar);
		panelHotBar.setLayout(null);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(538, 11, 89, 45);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDossierMedical.dispose();
			}
		});
		panelHotBar.add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(439, 11, 89, 45);
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				animal.setAntecedents(antecedentsAnimalTxt.getText());
				animalController.updateAnimal(animal);
			}
		});
		panelHotBar.add(btnValider);
		
		JPanel panelClient = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelClient.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelClient.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Client :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClient.setToolTipText("");
		panelClient.setBounds(10, 89, 276, 67);
		frmDossierMedical.getContentPane().add(panelClient);
		
		nomClientTxt = new JTextField();
		nomClientTxt.setEditable(false);
		nomClientTxt.setColumns(10);
		nomClientTxt.setText(animal.getClient().getNomClient());
		panelClient.add(nomClientTxt);
		
		prenomClientTxt = new JTextField();
		prenomClientTxt.setEditable(false);
		prenomClientTxt.setColumns(10);
		prenomClientTxt.setText(animal.getClient().getPrenomClient());
		panelClient.add(prenomClientTxt);
		
		JLabel lblNewLabel = new JLabel("Ant\u00E9c\u00E9dents/consultations");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(296, 89, 177, 14);
		frmDossierMedical.getContentPane().add(lblNewLabel);
		
		JLabel lblAnimal = new JLabel("Animal :");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAnimal.setBounds(10, 167, 46, 14);
		frmDossierMedical.getContentPane().add(lblAnimal);
		
		antecedentsAnimalTxt = new JTextArea();
		antecedentsAnimalTxt.setBounds(296, 114, 351, 323);
		antecedentsAnimalTxt.setText(animal.getAntecedents());
		JScrollPane scrollPane = new JScrollPane(antecedentsAnimalTxt);
		scrollPane.setBounds(296, 114, 351, 323);
		frmDossierMedical.getContentPane().add(scrollPane);
		
		codeAnimalTxt = new JTextField();
		codeAnimalTxt.setEditable(false);
		codeAnimalTxt.setBounds(58, 165, 228, 20);
		codeAnimalTxt.setText(String.valueOf(animal.getCodeAnimal()));
		frmDossierMedical.getContentPane().add(codeAnimalTxt);
		codeAnimalTxt.setColumns(10);
		
		nomAnimalTxt = new JTextField();
		nomAnimalTxt.setEditable(false);
		nomAnimalTxt.setColumns(10);
		nomAnimalTxt.setBounds(58, 192, 228, 20);
		nomAnimalTxt.setText(animal.getNomAnimal());
		frmDossierMedical.getContentPane().add(nomAnimalTxt);
		
		couleurAnimalTxt = new JTextField();
		couleurAnimalTxt.setEditable(false);
		couleurAnimalTxt.setColumns(10);
		couleurAnimalTxt.setBounds(58, 223, 108, 20);
		couleurAnimalTxt.setText(animal.getCouleur());
		frmDossierMedical.getContentPane().add(couleurAnimalTxt);
		
		sexeAnimalTxt = new JTextField();
		sexeAnimalTxt.setEditable(false);
		sexeAnimalTxt.setColumns(10);
		sexeAnimalTxt.setBounds(178, 223, 108, 20);
		sexeAnimalTxt.setText(animal.getSexe());
		frmDossierMedical.getContentPane().add(sexeAnimalTxt);
		
		especeAnimalTxt = new JTextField();
		especeAnimalTxt.setEditable(false);
		especeAnimalTxt.setColumns(10);
		especeAnimalTxt.setBounds(58, 254, 228, 20);
		especeAnimalTxt.setText(animal.getEspece());
		frmDossierMedical.getContentPane().add(especeAnimalTxt);
		
		tatouageAnimalTxt = new JTextField();
		tatouageAnimalTxt.setEditable(false);
		tatouageAnimalTxt.setColumns(10);
		tatouageAnimalTxt.setBounds(58, 285, 228, 20);
		tatouageAnimalTxt.setText(animal.getTatouage());
		frmDossierMedical.getContentPane().add(tatouageAnimalTxt);
	}
}
