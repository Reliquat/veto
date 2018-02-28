package fr.eni.clinique.ihm.screen.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.ihm.controller.ClientController;
import fr.eni.clinique.ihm.listener.ClientActionListener;
import fr.eni.clinique.ihm.model.ClientModel;

public class ScreenClient extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6111367380790098404L;
	
	private JFrame frmClient;
	private JPanel panel;
	private JLabel lblVille;
	private JTextField textField_6;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblCodePostal;

	private ClientActionListener actionListener;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ClientModel clientModel = new ClientModel();
					ClientController clientController = new ClientController(clientModel);
					
					ScreenClient window = new ScreenClient(AppConstants.APP_NAME);
					window.frmClient.setVisible(true);
					
					window.setActionListener(clientController);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
    public ScreenClient(String title) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(title);
        initialize();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setResizable(false);
		frmClient.setTitle("Client");
		frmClient.setBounds(10, 11, 1080, 720);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 1080, 100);
		frmClient.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setBounds(10, 11, 100, 78);
		//
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(actionListener != null) {
                	rechercherClient();
                }
            }
        });
		//
		panel.add(btnNewButton);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon(ScreenClient.class.getResource("/Images/plus.png")));
		btnAjouter.setBounds(407, 11, 100, 78);
		//
		btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(actionListener != null) {
                	ajouterClient();
                }
            }
        });
		//
		panel.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(516, 11, 100, 78);
		panel.add(btnSupprimer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(956, 11, 100, 78);
		panel.add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(846, 11, 100, 78);
		panel.add(btnValider);
		
		lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVille.setBounds(10, 453, 127, 25);
		frmClient.getContentPane().add(lblVille);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(147, 417, 150, 25);
		frmClient.getContentPane().add(textField_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(520, 122, 544, 416);
		frmClient.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 524, 340);
		panel_1.add(list);
		
		JButton btnNewButton_1 = new JButton("Editer");
		btnNewButton_1.setBounds(461, 362, 73, 43);
		panel_1.add(btnNewButton_1);
		
		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setBounds(378, 362, 73, 43);
		panel_1.add(btnSupprimer_1);
		
		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.setIcon(new ImageIcon(ScreenClient.class.getResource("/Images/plus.png")));
		btnAjouter_1.setBounds(295, 362, 73, 43);
		panel_1.add(btnAjouter_1);
		
		JLabel lblAdresse_1 = new JLabel("Adresse");
		lblAdresse_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdresse_1.setBounds(10, 345, 127, 25);
		frmClient.getContentPane().add(lblAdresse_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(147, 345, 150, 25);
		frmClient.getContentPane().add(textField_7);
		
		JLabel lblPrenom_1 = new JLabel("Prenom");
		lblPrenom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom_1.setBounds(10, 309, 127, 25);
		frmClient.getContentPane().add(lblPrenom_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(147, 309, 150, 25);
		frmClient.getContentPane().add(textField_8);
		
		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom_1.setBounds(10, 273, 127, 25);
		frmClient.getContentPane().add(lblNom_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(147, 273, 150, 25);
		frmClient.getContentPane().add(textField_9);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(10, 237, 127, 25);
		frmClient.getContentPane().add(lblCode);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(147, 237, 150, 25);
		frmClient.getContentPane().add(textField_10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(147, 381, 150, 25);
		frmClient.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(147, 453, 150, 25);
		frmClient.getContentPane().add(textField_1);
		
		lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodePostal.setBounds(10, 417, 127, 25);
		frmClient.getContentPane().add(lblCodePostal);
	}
	
    private void rechercherClient() {

    	actionListener.Rechercher();
    }
    
    private void ajouterClient() {

    	actionListener.Ajouter();
    }
    
    public void setActionListener(ClientActionListener actionListener) {
        
        if(actionListener != null) {
            
            this.actionListener = actionListener;
        }
    }
    
    public void removeActionListener() {
        this.actionListener = null;
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
