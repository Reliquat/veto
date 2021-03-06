package fr.eni.clinique.ihm.screen.animal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.ihm.controller.AnimalController;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GestionAnimalScreen {

	private JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_couleur;
	private JTextField textField_tatouage;
	private JLabel label_code_value;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_sexe;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_espece;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_race;
	private Animal animal;
	private AnimalController animalController;
	private String[] races;
	private String[] especes;

	/**
	 * Create the application.
	 */
	public GestionAnimalScreen(AnimalController animalController, Animal animal, List<String> races) {
		
		this.animalController = animalController;
		this.races = races.toArray(new String[races.size()]);
		List<String> especesList = animalController.getEspecesFromRace(animal.getRace());
		this.especes = especesList.toArray(new String[especesList.size()]);
		
		initialize(animal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize(Animal animal) {

		this.animal = animal;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 316);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Ajouter/modifier un animal");
		
		JPanel panel_buttons = new JPanel();
		panel_buttons.setBounds(10, 11, 414, 35);
		panel_buttons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(panel_buttons);
		
		JButton button_valider = new JButton("Valider");
		button_valider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				readAnimal();
		        if (animal.getCodeAnimal() == -1) {
		        	animalController.createAnimalSubmit(animal);
		        } else {
		        	animalController.updateAnimalSubmit(animal);
		        }
			}
		});
		panel_buttons.add(button_valider);
		
		JButton button_annuler = new JButton("Annuler");
		button_annuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				animalController.exitScreen();
			}
		});
		panel_buttons.add(button_annuler);
		
		JPanel panel_client_name = new JPanel();
		panel_client_name.setLayout(null);
		panel_client_name.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_client_name.setBounds(10, 57, 414, 65);
		frame.getContentPane().add(panel_client_name);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 30, 394, 24);
		panel_client_name.add(panel_2);
		
		JLabel label_client_value = new JLabel(animal.getClient().getNomClient());
		label_client_value.setBounds(10, 0, 39, 24);
		panel_2.add(label_client_value);
		
		JPanel panel_animal_form = new JPanel();
		panel_animal_form.setBounds(0, 133, 434, 154);
		frame.getContentPane().add(panel_animal_form);
		panel_animal_form.setLayout(null);
		
		JLabel label_couleur = new JLabel("Couleur");
		label_couleur.setBounds(10, 61, 72, 14);
		panel_animal_form.add(label_couleur);
		
		JLabel label_nom = new JLabel("Nom");
		label_nom.setBounds(10, 36, 72, 14);
		panel_animal_form.add(label_nom);
		
		JLabel label_code = new JLabel("Code");
		label_code.setBounds(10, 11, 72, 14);
		panel_animal_form.add(label_code);
		
		JLabel label_espece = new JLabel("Esp\u00E8ce");
		label_espece.setBounds(243, 86, 32, 14);
		panel_animal_form.add(label_espece);
		
		JLabel label_tatouage = new JLabel("Tatouage");
		label_tatouage.setBounds(10, 111, 72, 14);
		panel_animal_form.add(label_tatouage);
		
		if (animal.getCodeAnimal() != -1) {
			label_code_value = new JLabel(String.valueOf(animal.getCodeAnimal()));
		} else {
			label_code_value = new JLabel();
		}
		
		label_code_value.setBounds(92, 11, 46, 14);
		panel_animal_form.add(label_code_value);
		
		textField_nom = new JTextField();
		textField_nom.setText(animal.getNomAnimal());
		textField_nom.setColumns(10);
		textField_nom.setBounds(92, 33, 332, 20);
		panel_animal_form.add(textField_nom);
		
		String[] genres = {"M", "F", "H"};
		comboBox_sexe = new JComboBox(genres);
		comboBox_sexe.setBounds(278, 8, 146, 20);
		comboBox_sexe.setSelectedItem(animal.getSexe());
		panel_animal_form.add(comboBox_sexe);
		
		textField_couleur = new JTextField();
		textField_couleur.setText(animal.getCouleur());
		textField_couleur.setColumns(10);
		textField_couleur.setBounds(92, 58, 332, 20);
		panel_animal_form.add(textField_couleur);
		
		comboBox_espece = new JComboBox(especes);
		comboBox_espece.setBounds(278, 83, 146, 20);
		System.out.println(animal.getEspece());
		comboBox_espece.setSelectedItem(animal.getEspece());
		panel_animal_form.add(comboBox_espece);
		
		JLabel label_race = new JLabel("Race");
		label_race.setBounds(10, 86, 72, 14);
		panel_animal_form.add(label_race);

		comboBox_race = new JComboBox(races);
		comboBox_race.setBounds(92, 83, 141, 20);
		comboBox_race.setSelectedItem(animal.getRace());
		comboBox_race.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	List<String> especesList = animalController.getEspecesFromRace(comboBox_race.getSelectedItem().toString().trim());
		    	especes = especesList.toArray(new String[especesList.size()]);
		    	comboBox_espece.removeAllItems();
		    	for (String item : especes) {
		    		comboBox_espece.addItem(item);
		        }
		    }
		});
		panel_animal_form.add(comboBox_race);
		
		JLabel label_sexe = new JLabel("Sexe");
		label_sexe.setBounds(242, 11, 33, 14);
		panel_animal_form.add(label_sexe);
		
		textField_tatouage = new JTextField(animal.getTatouage());
		textField_tatouage.setColumns(10);
		textField_tatouage.setBounds(92, 108, 332, 20);
		panel_animal_form.add(textField_tatouage);
		
		this.frame.setVisible(true);
	}
	
	private void readAnimal() {
		
    	animal.setNomAnimal(textField_nom.getText().trim());
    	animal.setSexe(comboBox_sexe.getSelectedItem().toString().trim());
    	animal.setCouleur(textField_couleur.getText().trim());
    	animal.setRace(comboBox_race.getSelectedItem().toString().trim());
    	animal.setEspece(comboBox_espece.getSelectedItem().toString().trim());
    	animal.setTatouage(textField_tatouage.getText().trim());
	}
	
	public void hide() {
		this.frame.setVisible(false);
	}
}
