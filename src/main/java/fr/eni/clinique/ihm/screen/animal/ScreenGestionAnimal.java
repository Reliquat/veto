package fr.eni.clinique.ihm.screen.animal;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.common.AppConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ScreenGestionAnimal implements Observer {

	@Override
	public void update(Observable o, Object arg) {

		
	}

	private JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_couleur;
	private JTextField textField_tatouage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Animal animal = new Animal();
					
					ScreenGestionAnimal window = new ScreenGestionAnimal(animal);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScreenGestionAnimal(Animal animal) {
		initialize(animal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Animal animal) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Ajouter/modifier un animal");
		
		JPanel panel_buttons = new JPanel();
		panel_buttons.setBounds(10, 11, 414, 35);
		panel_buttons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(panel_buttons);
		
		JButton button_valider = new JButton("Valider");
		panel_buttons.add(button_valider);
		
		JButton button_annuler = new JButton("Annuler");
		panel_buttons.add(button_annuler);
		
		JPanel panel_client_name = new JPanel();
		panel_client_name.setLayout(null);
		panel_client_name.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_client_name.setBounds(10, 57, 414, 65);
		frame.getContentPane().add(panel_client_name);
		
		JLabel label_client = new JLabel("Client :");
		label_client.setBounds(10, 11, 47, 14);
		panel_client_name.add(label_client);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 30, 394, 24);
		panel_client_name.add(panel_2);
		
		JLabel label_client_value = new JLabel(String.valueOf(animal.getCodeAnimal()));
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
		label_espece.setBounds(10, 86, 72, 14);
		panel_animal_form.add(label_espece);
		
		JLabel label_tatouage = new JLabel("Tatouage");
		label_tatouage.setBounds(10, 111, 72, 14);
		panel_animal_form.add(label_tatouage);
		
		JLabel label_code_value = new JLabel("50");
		label_code_value.setBounds(92, 11, 46, 14);
		panel_animal_form.add(label_code_value);
		
		textField_nom = new JTextField();
		textField_nom.setText(animal.getNomAnimal());
		textField_nom.setColumns(10);
		textField_nom.setBounds(92, 33, 332, 20);
		panel_animal_form.add(textField_nom);
		
		String[] genres = {"Male", "Femelle", "Hermaphrodite"};
		JComboBox comboBox_sexe = new JComboBox(genres);
		comboBox_sexe.setBounds(278, 8, 146, 20);
		comboBox_sexe.setSelectedIndex(0);
		panel_animal_form.add(comboBox_sexe);
		
		textField_couleur = new JTextField();
		textField_couleur.setText(animal.getCouleur());
		textField_couleur.setColumns(10);
		textField_couleur.setBounds(92, 58, 332, 20);
		panel_animal_form.add(textField_couleur);
		
		JComboBox comboBox_espece = new JComboBox();
		comboBox_espece.setBounds(92, 83, 141, 20);
		panel_animal_form.add(comboBox_espece);
		
		JLabel label_race = new JLabel("Race");
		label_race.setBounds(243, 86, 32, 14);
		panel_animal_form.add(label_race);
		
		JComboBox comboBox_race = new JComboBox();
		comboBox_race.setBounds(278, 83, 146, 20);
		panel_animal_form.add(comboBox_race);
		
		JLabel label_sexe = new JLabel("Sexe");
		label_sexe.setBounds(242, 11, 33, 14);
		panel_animal_form.add(label_sexe);
		
		textField_tatouage = new JTextField();
		textField_tatouage.setColumns(10);
		textField_tatouage.setBounds(92, 108, 332, 20);
		panel_animal_form.add(textField_tatouage);
	}
}
