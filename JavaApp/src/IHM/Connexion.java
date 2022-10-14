package IHM;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Connexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Connexion dialog = new Connexion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Connexion() {
		setResizable(false);
		setType(Type.POPUP);
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lbConnexion = new JLabel("Connexion");
			lbConnexion.setHorizontalAlignment(SwingConstants.CENTER);
			lbConnexion.setFont(new Font("Tahoma", Font.PLAIN, 30));
			contentPanel.add(lbConnexion, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100000000, 40));
			{
				JPanel panel_ID = new JPanel();
				panel.add(panel_ID);
				panel_ID.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblId = new JLabel("Identifiant");
					panel_ID.add(lblId, BorderLayout.NORTH);
				}
				{
					textField = new JTextField();
					panel_ID.add(textField, BorderLayout.CENTER);
					textField.setColumns(10);
				}
			}
			{
				JPanel panel_MDP = new JPanel();
				panel.add(panel_MDP);
				panel_MDP.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblMDP = new JLabel("Mot de passe");
					panel_MDP.add(lblMDP, BorderLayout.NORTH);
				}
				{
					textField_1 = new JTextField();
					panel_MDP.add(textField_1, BorderLayout.CENTER);
					textField_1.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setHorizontalAlignment(SwingConstants.LEFT);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Valider");
				okButton.setVerticalAlignment(SwingConstants.TOP);
				okButton.setHorizontalAlignment(SwingConstants.RIGHT);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
