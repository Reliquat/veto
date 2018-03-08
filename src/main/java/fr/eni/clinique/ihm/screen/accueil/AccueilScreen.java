package fr.eni.clinique.ihm.screen.accueil;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eni.clinique.ihm.controller.AccueilController;

import javax.swing.JButton;

public class AccueilScreen {

	private JFrame frame;
	private AccueilController accueilController;

	/**
	 * Create the application.
	 */
	public AccueilScreen(AccueilController accueilController) {
		this.accueilController = accueilController;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBorder(null);
		panel_menu.setBounds(10, 11, 564, 23);
		frame.getContentPane().add(panel_menu);
		panel_menu.setLayout(null);
		
		JButton btnFichier = new JButton("Fichier");
		btnFichier.setBounds(0, 0, 96, 23);
		panel_menu.add(btnFichier);
		
		JButton btnGestionRdv = new JButton("Gestion RDV");
		btnGestionRdv.setBounds(95, 0, 125, 23);
		panel_menu.add(btnGestionRdv);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.setBounds(219, 0, 96, 23);
		panel_menu.add(btnAgenda);
		
		JButton btnGestionPersonnel = new JButton("Gestion personnel");
		btnGestionPersonnel.setBounds(314, 0, 139, 23);
		btnGestionPersonnel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accueilController.openAdminScreen();
			}
		});
		panel_menu.add(btnGestionPersonnel);
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(10, 45, 564, 305);
		frame.getContentPane().add(panel_main);
		panel_main.setLayout(null);
		
		JButton btnDeconnexion = new JButton("D\u00E9connexion");
		btnDeconnexion.setBounds(0, 0, 131, 23);
		panel_main.add(btnDeconnexion);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBounds(0, 22, 131, 23);
		panel_main.add(btnFermer);
		
		JButton btnPriseDeRdv = new JButton("Prise de RDV");
		btnPriseDeRdv.setBounds(130, 0, 131, 23);
		panel_main.add(btnPriseDeRdv);
		
		JButton btnGestionClients = new JButton("Gestion clients");
		btnGestionClients.setBounds(130, 22, 131, 23);
		btnGestionClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accueilController.openClientScreen();
			}
		});
		panel_main.add(btnGestionClients);
	}
}
