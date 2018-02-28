package fr.eni.clinique.ihm.screen;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.common.AppConstants;

public class CustomerMgerScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 113363349727772846L;
	
	private JPanel customerPanel;
	private JPanel buttonHotbarPanel;
	private JButton searchHotbar;
	private JButton addHotbar;
	private JButton deleteHotbar;
	private JButton validateHotbar;
	private JButton cancelHotbar;
	
	private JPanel infoPanel;
	private JTextField codeTxt;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField adresseTxt;
	private JTextField cpTxt;
	private JTextField villeTxt;
	
	private JPanel listPanel;
	private JPanel buttonListPanel;

	
    public CustomerMgerScreen(String title) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        setTitle(title);
        setUp();
    }
    
    private void setUp() {
    	
        setContentPane(createCustomerPanel());
        
        buttonHotbarPanel = new JPanel();
        searchHotbar = new JButton();
        searchHotbar.setText("Rechercher");
        addHotbar = new JButton();
        addHotbar.setText("Ajouter");
        deleteHotbar = new JButton();
        deleteHotbar.setText("Supprimer");
        validateHotbar = new JButton();
        validateHotbar.setText("Valider");
        cancelHotbar = new JButton();
        cancelHotbar.setText("Anuller");
        
        infoPanel = new JPanel();
        codeTxt = createTextField(AppConstants.EMPTY, "Entrez le code du client ici");
        nomTxt = createTextField(AppConstants.EMPTY, "Entrez le nom du client ici");
        prenomTxt = createTextField(AppConstants.EMPTY, "Entrez le prenom du client ici");
        adresseTxt = createTextField(AppConstants.EMPTY, "Entrez l'adresse du client ici");
        cpTxt = createTextField(AppConstants.EMPTY, "Entrez le code postal du client ici");
        villeTxt = createTextField(AppConstants.EMPTY, "Entrez la ville du client ici");
        
        buttonHotbarPanel.add(searchHotbar, createGridBagConstraints(0.2, 1, 1));
        buttonHotbarPanel.add(addHotbar, createGridBagConstraints(0.2, 2, 1));
        buttonHotbarPanel.add(deleteHotbar, createGridBagConstraints(0.2, 3, 1));
        buttonHotbarPanel.add(validateHotbar, createGridBagConstraints(0.2, 4, 1));
        buttonHotbarPanel.add(cancelHotbar, createGridBagConstraints(0.2, 5, 1));
        
        addForm("Code", codeTxt, 1, 1, infoPanel);
        addForm("Nom", codeTxt, 1, 2, infoPanel);
        addForm("Prenom", codeTxt, 1, 3, infoPanel);
        addForm("Adresse", codeTxt, 1, 4, infoPanel);
        addForm("Code postal", codeTxt, 1, 5, infoPanel);
        addForm("Ville", codeTxt, 1, 6, infoPanel);
        
        customerPanel.add(buttonHotbarPanel, createGridBagConstraints(0.2, 1, 1));
        customerPanel.add(infoPanel, createGridBagConstraints(0.2, 1, 2));
    }
    
    private JPanel createCustomerPanel() {
        customerPanel = new JPanel();
        setSize(400, 200);
        setResizable(false);
        customerPanel.setOpaque(true);
        customerPanel.setLayout(new GridBagLayout());
        return customerPanel;
    }
    
    private void addForm(String label, JComponent component, int lineNumber, int rowNumber,JPanel aPanel) {
        aPanel.add(createLabel(label.concat(":")), createGridBagConstraints(0.3, rowNumber, lineNumber));
        aPanel.add(component, createGridBagConstraints(0.7, rowNumber, lineNumber));
    }
    
    private JLabel createLabel(String text) {
        return new JLabel(text);
    }
    
    private JTextField createTextField(String defaultValue, String tooltip) {
        
        JTextField textField = new JTextField(defaultValue);
        textField.setToolTipText(tooltip);
        return textField;
    }
    
    private GridBagConstraints createGridBagConstraints(double weight, int cellX, int cellY) {
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.gridx = cellX;
        gridBagConstraints.gridy = cellY;
        gridBagConstraints.weightx = weight;
        
        return gridBagConstraints;
    }
}
