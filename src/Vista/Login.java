package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.AdmUsr;
import Persistencia.PoolConnection;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private AdmUsr admUsr;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {	
		
		admUsr = AdmUsr.getInstancia();
		
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(33, 85, 89, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(148, 82, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(33, 115, 89, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 112, 212, 20);
		contentPane.add(passwordField);
		
		JLabel lblIngresTuUsuario = new JLabel("Ingres\u00E1 tu usuario y contrase\u00F1a");
		lblIngresTuUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngresTuUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresTuUsuario.setBounds(10, 11, 414, 40);
		contentPane.add(lblIngresTuUsuario);
		
		JButton btnIngresar = new JButton("Iniciar Sesi\u00F3n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Verificar usr y contraseña 
				MenuPrincipal menuPpal = new MenuPrincipal();
				menuPpal.setLocationRelativeTo(null);
				menuPpal.setVisible(true);
				
			}
		});
		btnIngresar.setBounds(173, 162, 133, 23);
		contentPane.add(btnIngresar);
		
		JButton btnOlvidContrasea = new JButton("Olvid\u00E9 mi contrase\u00F1a");
		btnOlvidContrasea.addActionListener(new ActionListener() {
			//Ir a la pantalla de recupero de contraseña
			public void actionPerformed(ActionEvent e) {
				 System.out.println("Falta programar");
			}
		});
		btnOlvidContrasea.setBounds(241, 227, 167, 23);
		contentPane.add(btnOlvidContrasea);
		
		JButton btnRegistrarme = new JButton("Soy nuevo!");
		btnRegistrarme.addActionListener(new ActionListener() {
			//Ir a la pantalla de alta de usuario
			public void actionPerformed(ActionEvent e) {
				AltaUsuario altausr = new AltaUsuario();
				altausr.setLocationRelativeTo(null);
				altausr.setVisible(true);
			}
		});
		btnRegistrarme.setBounds(33, 227, 121, 23);
		contentPane.add(btnRegistrarme);
	}
}
