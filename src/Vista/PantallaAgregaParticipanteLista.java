package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaAgregaParticipanteLista extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAgregaParticipanteLista frame = new PantallaAgregaParticipanteLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaAgregaParticipanteLista() {
		setTitle("Nuevo participante lista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMailUsuario = new JLabel("Mail Usuario");
		lblMailUsuario.setBounds(23, 93, 74, 14);
		contentPane.add(lblMailUsuario);
		
		txtMail = new JTextField();
		txtMail.setText("mail");
		txtMail.setBounds(131, 90, 248, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(174, 147, 89, 23);
		contentPane.add(btnAceptar);
	}
}
