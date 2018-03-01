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

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.common.util.ObjectUtil;
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

	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JTextField villeTxt;
	private JTextField cpTxt;
	private JTextField adresse1Txt;
	private JTextField adresse2Txt;
	private JTextField prenomTxt;
	private JTextField nomTxt;
	private JTextField codeCliTxt;
	private JLabel lblCodePostal;
	private int codeCli;

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
		//<<
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(actionListener != null) {
                	rechercherClient();
                }
            }
        });
		//>>
		panel.add(btnNewButton);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon(ScreenClient.class.getResource("/Images/plus.png")));
		btnAjouter.setBounds(407, 11, 100, 78);
		//<<
		btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(actionListener != null) {
                	ajouterClient();
                }
            }
        });
		//>>
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
		
		cpTxt = new JTextField();
		cpTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cpTxt.setColumns(10);
		cpTxt.setBounds(147, 417, 150, 25);
		frmClient.getContentPane().add(cpTxt);
		
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
		
		adresse1Txt = new JTextField();
		adresse1Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adresse1Txt.setColumns(10);
		adresse1Txt.setBounds(147, 345, 150, 25);
		frmClient.getContentPane().add(adresse1Txt);
		
		JLabel lblPrenom_1 = new JLabel("Prenom");
		lblPrenom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom_1.setBounds(10, 309, 127, 25);
		frmClient.getContentPane().add(lblPrenom_1);
		
		prenomTxt = new JTextField();
		prenomTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(147, 309, 150, 25);
		frmClient.getContentPane().add(prenomTxt);
		
		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom_1.setBounds(10, 273, 127, 25);
		frmClient.getContentPane().add(lblNom_1);
		
		nomTxt = new JTextField();
		nomTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomTxt.setColumns(10);
		nomTxt.setBounds(147, 273, 150, 25);
		frmClient.getContentPane().add(nomTxt);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(10, 237, 127, 25);
		frmClient.getContentPane().add(lblCode);
		
		codeCliTxt = new JTextField();
		codeCliTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		codeCliTxt.setColumns(10);
		codeCliTxt.setBounds(147, 237, 150, 25);
		frmClient.getContentPane().add(codeCliTxt);
		
		adresse2Txt = new JTextField();
		adresse2Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adresse2Txt.setColumns(10);
		adresse2Txt.setBounds(147, 381, 150, 25);
		frmClient.getContentPane().add(adresse2Txt);
		
		villeTxt = new JTextField();
		villeTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		villeTxt.setColumns(10);
		villeTxt.setBounds(147, 453, 150, 25);
		frmClient.getContentPane().add(villeTxt);
		
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
    
    private void supprimerClient() {

    	actionListener.Supprimer(codeCliTxt);
    }
    
    private void validerClient() {

    	actionListener.Valider(codeCliTxt);
    }
    
    private void annulerClient() {

    	actionListener.Annuler();
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
	
    public void showClient(Client client) {
        

        // Autres caractéristiques de l'article
        codeCli = client.getCodeClient();
        nomTxt.setText(ObjectUtil.nullToBlank(client.getNomClient().trim()));
        prenomTxt.setText(ObjectUtil.nullToBlank(client.getPrenomClient()).trim());
        adresse1Txt.setText(ObjectUtil.nullToBlank(client.getAdresse1()).trim());
        adresse2Txt.setText(ObjectUtil.nullToBlank(client.getAdresse2()).trim());
        cpTxt.setText(ObjectUtil.nullToBlank(client.getCodePostal()).trim());
        villeTxt.setText(ObjectUtil.nullToBlank(client.getVille().trim()));
    }
	
    private Client readClient() {
        
    	Client client = null;
        
        client.setCodeClient(codeCliTxt);
        client.setNomClient(nomTxt);
        client.setMarque(marqueTxt.getText().trim());
        client.setDesignation(designationTxt.getText().trim());
        
        try {
            client.setPrixUnitaire(Float.parseFloat(prixTxt.getText()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format du prix non valide", e);
        }
        
        try {
            client.setQteStock(Integer.parseInt(stockTxt.getText()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format du stock non valide", e);
        }
        
        return client;
    }
}
