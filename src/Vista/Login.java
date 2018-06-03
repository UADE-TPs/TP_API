package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.AdmUsr;
import Modelo.Usuario;
import Persistencia.PoolConnection;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField docTxtField;
	private JPasswordField passField;
	private AdmUsr admUsr;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Error en Sistema de Regalos - main");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {	
		
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoc = new JLabel("N\u00B0 Documento");
		lblDoc.setBounds(33, 85, 89, 14);
		contentPane.add(lblDoc);
		
		docTxtField = new JTextField();
		docTxtField.setBounds(148, 82, 212, 20);
		contentPane.add(docTxtField);
		docTxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(33, 115, 89, 14);
		contentPane.add(lblPassword);
		
		passField = new JPasswordField();
		passField.setBounds(148, 112, 212, 20);
		contentPane.add(passField);
		
		JLabel lblIngresTuUsuario = new JLabel("Ingres\u00E1 tu usuario y contrase\u00F1a");
		lblIngresTuUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngresTuUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresTuUsuario.setBounds(10, 11, 414, 40);
		contentPane.add(lblIngresTuUsuario);
		
		JButton btnIngresar = new JButton("Iniciar Sesi\u00F3n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Verificar usr y contraseña
				if (AdmUsr.getInstancia().logIn(Integer.parseInt(docTxtField.getText()),new String(passField.getPassword())) == 1) {
					MenuPrincipal menuPpal = new MenuPrincipal();
					menuPpal.setLocationRelativeTo(null);
					menuPpal.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,  "Usuario o contraseña inválidos");
				}
				
			}
		});
		btnIngresar.setBounds(173, 162, 133, 23);
		contentPane.add(btnIngresar);
		
		JButton btnOlvidContrasea = new JButton("Olvid\u00E9 mi contrase\u00F1a");
		btnOlvidContrasea.addActionListener(new ActionListener() {
			//Ir a la pantalla RecuperoContraseña
			public void actionPerformed(ActionEvent e) {
				 System.out.println("Falta programar");
			}
		});
		btnOlvidContrasea.setBounds(241, 227, 167, 23);
		contentPane.add(btnOlvidContrasea);
		
		JButton btnRegistrarme = new JButton("Soy nuevo!");
		btnRegistrarme.addActionListener(new ActionListener() {
			//Ir a la pantalla de AltaUsuario
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

