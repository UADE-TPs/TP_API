package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Controlador.AdmUsr;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifDatosUsr extends JFrame {

	private JPanel contentPane;
	private JTextField textNomb;
	private JTextField textApe;
	private JTextField textEmail;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public ModifDatosUsr() {
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 472, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 46, 99, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 82, 99, 14);
		contentPane.add(lblApellido);
		
		JLabel lblNewLabel = new JLabel("Fecha de Nacimiento");
		lblNewLabel.setBounds(10, 118, 149, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDireccinEmail = new JLabel("Direcci\u00F3n email");
		lblDireccinEmail.setBounds(10, 154, 123, 14);
		contentPane.add(lblDireccinEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 190, 99, 14);
		contentPane.add(lblContrasea);
		
		textNomb = new JTextField();
		textNomb.setText(AdmUsr.getInstancia().loggedUsr().getNombre());
		textNomb.setBounds(198, 46, 212, 20);
		contentPane.add(textNomb);
		textNomb.setColumns(10);
		
		textApe = new JTextField();
		textApe.setText(AdmUsr.getInstancia().loggedUsr().getApellido());
		textApe.setBounds(198, 82, 212, 20);
		contentPane.add(textApe);
		textApe.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDate(AdmUsr.getInstancia().loggedUsr().getFechaNacimiento());
		dateChooser.setBounds(198, 118, 123, 20);
		contentPane.add(dateChooser);
		
		textEmail = new JTextField();
		textEmail.setText(AdmUsr.getInstancia().loggedUsr().getMail());
		textEmail.setBounds(198, 154, 212, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setText(AdmUsr.getInstancia().loggedUsr().getPassword());
		passwordField.setBounds(198, 190, 99, 20);
		contentPane.add(passwordField);
		
		JLabel lblModificTusDatos = new JLabel("Modific\u00E1 tus datos y dale guardar!");
		lblModificTusDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModificTusDatos.setBounds(10, 11, 236, 21);
		contentPane.add(lblModificTusDatos);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
				if(AdmUsr.getInstancia().modificarDatosUsr(textNomb.getText(), textApe.getText(), sqldate, textEmail.getText(), new String(passwordField.getPassword())) == 1)
				{
					JOptionPane.showMessageDialog(null,  "Se modificaron los datos correctamente");
					dispose(); 
				}
				else {
					JOptionPane.showMessageDialog(null,  "Hubo un error al modificar tus datos");
					dispose(); 
				}
			}
		});
		btnGuardar.setBounds(321, 239, 89, 23);
		contentPane.add(btnGuardar);
	}
}
