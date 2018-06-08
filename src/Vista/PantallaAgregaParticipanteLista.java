package Vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;
import Persistencia.MapperItemLista;
import Persistencia.MapperLista;
import Persistencia.MapperUsuario;
import Persistencia.PoolConnection;
import Modelo.ItemLista;
import Modelo.Pago;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controlador.AdmLista;
import Controlador.AdmUsr;
import Modelo.Usuario;
import javax.swing.JOptionPane;

public class PantallaAgregaParticipanteLista extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;
	private Vector<Usuario> usuarios;

	/**
	 * Create the frame.
	 */
	public PantallaAgregaParticipanteLista(int codNuevaLista) {
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMailUsuario = new JLabel("Mail Usuario");
		lblMailUsuario.setBounds(23, 93, 74, 14);
		contentPane.add(lblMailUsuario);
		
		txtMail = new JTextField();
		txtMail.setBounds(131, 90, 248, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(174, 147, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
					Usuario participante = AdmUsr.getInstancia().buscarUsrXmail(txtMail.getText());
					if (participante != null) {
						if ((AdmLista.getInstancia().generarItemLista(codNuevaLista,participante)==1)) {
						JOptionPane.showMessageDialog(null,  "Usuario agregado a la lista");
						}
						else {
							JOptionPane.showMessageDialog(null,  "Error al agregar al participante");
						}
					}
					else {
						JOptionPane.showMessageDialog(null,  "Email no registrado");
					}	
					txtMail.setText(null);
			}
		});
		contentPane.add(btnAceptar);
	}

}

