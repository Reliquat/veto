package fr.eni.clinique.ihm.screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class adminScreen implements Observer{

	private JFrame frmGestionDuPersonnel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminScreen window = new adminScreen();
					window.frmGestionDuPersonnel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuPersonnel = new JFrame();
		frmGestionDuPersonnel.setResizable(false);
		frmGestionDuPersonnel.setTitle("Gestion du personnel");
		frmGestionDuPersonnel.setBounds(100, 100, 450, 300);
		frmGestionDuPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuPersonnel.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 424, 35);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmGestionDuPersonnel.getContentPane().add(panel);
		
		JButton addPersonnel = new JButton("Ajouter");
		addPersonnel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table.getSelectedRow();
			}
		});
		addPersonnel.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/plus.png")));
		addPersonnel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(addPersonnel);
		
		JButton delete = new JButton("Supprimer");
		delete.setSelectedIcon(new ImageIcon(adminScreen.class.getResource("/Images/minus.ico")));
		delete.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/minus.ico")));
		delete.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(delete);
		
		JButton btnNewButton = new JButton("Réinitialiser");
		btnNewButton.setIcon(new ImageIcon(adminScreen.class.getResource("/Images/unlock.png")));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 57, 424, 203);
		frmGestionDuPersonnel.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 424, 203);
		panel_1.add(table);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
