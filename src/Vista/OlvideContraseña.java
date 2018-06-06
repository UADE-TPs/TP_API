package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.AdmUsr;
import Controlador.SistemaEmail;
import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OlvideContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField textDoc;


	public OlvideContraseña() {
		try {
			
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresTuNmero = new JLabel("Ingres\u00E1 tu dni y te enviaremos la contrase\u00F1a a tu email!");
		lblIngresTuNmero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngresTuNmero.setBounds(10, 11, 424, 38);
		contentPane.add(lblIngresTuNmero);
		
		textDoc = new JTextField();
		textDoc.setBounds(118, 67, 205, 20);
		contentPane.add(textDoc);
		textDoc.setColumns(10);
		
		JButton btnRecuperarContrasea = new JButton("Recuperar Contrase\u00F1a");
		btnRecuperarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textDoc.getText().isEmpty()) {
					Usuario u = AdmUsr.getInstancia().buscarUsrxDoc(Integer.parseInt(textDoc.getText()));
					if (u != null) {
						JOptionPane.showMessageDialog(null,  "Te enviamos tu contraseña por email!");
						SistemaEmail.getInstancia().enviarMail(u.getMail(), "Recupero Contraseña", "Su constraseña es "+ u.getPassword());
						dispose(); 
					}
				}else {
					JOptionPane.showMessageDialog(null,  "Ingresá un dni valido ");
				}
					
			}
		});
		btnRecuperarContrasea.setBounds(141, 116, 159, 23);
		contentPane.add(btnRecuperarContrasea);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
