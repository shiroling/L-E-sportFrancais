package IHM;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil {

	private JFrame frame;
	private JTextField textRecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(20);
		borderLayout.setHgap(20);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Header = new JPanel();
		Header.setBackground(SystemColor.menu);
		frame.getContentPane().add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel Recherche = new JPanel();
		Recherche.setBackground(SystemColor.menu);
		Header.add(Recherche, BorderLayout.WEST);
		
		JLabel lbllogoRecherche = new JLabel("");
		lbllogoRecherche.setIcon(new ImageIcon(Accueil.class.getResource("/img/LoupeIconR.png")));
		Recherche.add(lbllogoRecherche);
		
		textRecherche = new JTextField();
		textRecherche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Recherche.add(textRecherche);
		textRecherche.setColumns(30);
		
		JLabel lblBurger = new JLabel("");
		lblBurger.setIcon(new ImageIcon(Accueil.class.getResource("/img/BurgerIconeR.png")));
		Header.add(lblBurger, BorderLayout.EAST);
		
		JPanel body = new JPanel();
		body.setBackground(Color.WHITE);
		frame.getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(new GridLayout(1, 0, 30, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		body.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tournois a suivre", "Tournois historique", "Equipes", "Jeux", "Matchs a venire", "Matchs passés"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_2.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Calibri", Font.BOLD, 17));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"a", "b", "c", "e"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		scrollPane.setRowHeaderView(panel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		body.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Equipes", "Jeux", "Matchs a venire", "Matchs passés", "Poules"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		scrollPane_1.setRowHeaderView(panel_5);
	}

}
