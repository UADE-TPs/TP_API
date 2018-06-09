package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.sql.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Controlador.AdmUsr;
import Controlador.SistemaEmail;


public class AltaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtDoc;
	private JTextField txtEmail;
	private JTextField txtEmailConf;
	private JPasswordField passField;
	private JPasswordField passFieldConf;


	public AltaUsuario() {

		try {
		
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoPorFavor = new JLabel("Bienvenido! Por favor complet\u00E1 el siguiente formulario");
		lblBienvenidoPorFavor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBienvenidoPorFavor.setBounds(10, 11, 354, 21);
		contentPane.add(lblBienvenidoPorFavor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 46, 107, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 82, 98, 14);
		contentPane.add(lblApellido);
		
		JLabel 	lblDocumento = new JLabel("Nro Documento");
		lblDocumento.setBounds(10, 124, 135, 14);
		contentPane.add(lblDocumento);
		
		JLabel lblEmail = new JLabel("Direcci\u00F3n email");
		lblEmail.setBounds(10, 203, 88, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(10, 276, 77, 14);
		contentPane.add(lblPass);
		
		JLabel lblPassConf = new JLabel("Confirmar Contrase\u00F1a");
		lblPassConf.setBounds(10, 311, 158, 14);
		contentPane.add(lblPassConf);
		
		JLabel lblEmailConf = new JLabel("Confrimar email");
		lblEmailConf.setBounds(10, 240, 146, 14);
		contentPane.add(lblEmailConf);
		
		txtNom = new JTextField();
		txtNom.setBounds(198, 43, 228, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(198, 79, 228, 20);
		contentPane.add(txtApe);
		txtApe.setColumns(10);
		
		txtDoc = new JTextField();
		txtDoc.setBounds(198, 121, 120, 20);
		contentPane.add(txtDoc);
		txtDoc.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(198, 200, 228, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtEmailConf = new JTextField();
		txtEmailConf.setBounds(198, 237, 228, 20);
		contentPane.add(txtEmailConf);
		txtEmailConf.setColumns(10);
		
		passField = new JPasswordField();
		passField.setBounds(198, 273, 228, 20);
		contentPane.add(passField);
		
		passFieldConf = new JPasswordField();
		passFieldConf.setBounds(198, 308, 226, 20);
		contentPane.add(passFieldConf);
				
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 162, 158, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(198, 162, 120, 20);
		contentPane.add(dateChooser);
		

		JButton btnAceptar = new JButton("Aceptar");
		//btnAceptar.addMouseListener(new MouseAdapter() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
				if(VerificarTxt(txtNom.getText(), lblNombre.getText())) {
					if(VerificarTxt(txtApe.getText(), lblApellido.getText())) {
						if(VerificarTxt(txtDoc.getText(), lblDocumento.getText())) {
							if(VerificarFecha(dateChooser)) {
									//Formato sql date
									java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
									if(VerificarEmail(txtEmail.getText(), txtEmailConf.getText())) {
										if(VerificarPass(passField.getPassword(), passFieldConf.getPassword())) {
											//System.out.println("pass ok -- ALTA");
											if (AdmUsr.getInstancia().generarUsr(Integer.parseInt(txtDoc.getText()), txtNom.getText(), txtApe.getText(), sqldate, txtEmail.getText(), new String(passField.getPassword()))==1) {
												JOptionPane.showMessageDialog(null,  "Usuario dado de alta correctamente");
												//SistemaEmail.getInstancia().enviarMail(txtEmail.getText(),"Bienvenido/a", "Hola " + txtNom.getText() + "!\n\nBienvenido/a al sistema de listas de regalos. \n\n\nSldos!" );
												dispose(); 
											}
											else {
												JOptionPane.showMessageDialog(null,  "El usuario ingresado ya existe. No fue dado de alta");
											}
											
										 }
										else {
											passField.setText(null);
											passFieldConf.setText(null);
										}
									 }
									else {
										txtEmail.setText(null);
										txtEmailConf.setText(null);
									} 
								 } 
							 } 
						 } 			
					 } //fin verificación de campos
				
				 } 	//fin mouseClicked		 
		}); //fin addMouseListener
		
		btnAceptar.setBounds(310, 355, 89, 23);
		contentPane.add(btnAceptar);		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean VerificarTxt (String d, String lbl) {
		if(d.isEmpty()) {
			JOptionPane.showMessageDialog(null,  "Falta completar el campo " + lbl);
			return false;
		}
		return true;
	}
	
	private boolean VerificarPass (char[]  p1, char[] p2) {
		if(p1.length==0 || p2.length==0 || p1.length!=p2.length || !Arrays.equals(p1,p2) ) {
			JOptionPane.showMessageDialog(null,  "Las contraseñas ingresadas no coinciden o faltan completar");
			return false;
		}
		return true;
	}
	
	private boolean VerificarEmail (String m1, String m2) {
		if(m1.isEmpty() || m2.isEmpty() || !m1.equals(m2)) {
			JOptionPane.showMessageDialog(null,  "Los emails ingresados no coinciden o faltan completar");
			return false;
		}
		return true;
	}
	
	private boolean VerificarFecha (JDateChooser f) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String fecha = sdf.format(f.getDate());
			//System.out.println("fecha" + fecha);
			return true;
		} catch(NullPointerException ex) {
		     JOptionPane.showMessageDialog(null, "Falta seleccionar una fecha válida");
		     return false;		
		}
	}
}

