package fr.eni.clinique.ihm.screen;

import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ScreenGestionEmployee extends JFrame implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5488149424823602513L;
	
	JPanel mainPanel;
	JPanel buttonBar;
	JPanel employeePanel;
	JButton add;
	JButton delete;
	JButton clearPW;
	JTable tableEmployee;
	String title = "Gestion du personnel";
	int employeeSelected;
	
	public ScreenGestionEmployee(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        setTitle(title);
        setup();
	}
	
	public void setup(){
		setContentPane(createMainPanel());
		
		buttonBar = createButtonBar();
		
		employeePanel = createEmployeePanel();
		
		
		
		
	}
	
	private JPanel createEmployeePanel() {
		JPanel panel = new JPanel();
		panel.setOpaque(true);
        panel.setLayout(new GridBagLayout());
        
        add = new JButton();
        add.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/plus.png")));
        
		return null;
	}

	private JPanel createMainPanel(){
		this.mainPanel = new JPanel();
		this.mainPanel.setOpaque(true);
		this.mainPanel.setLayout(new GridBagLayout());
		return this.mainPanel;
	}
	
	// TODO faire la méthode
	private JPanel createButtonBar(){
		return null;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
