package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import Controlador.AdmLista;
import Controlador.AdmUsr;
import Modelo.Lista;
import Persistencia.PoolConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarLista extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomb;
	private JTextField textFieldMail;


	public ModificarLista(String nombLista) {
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Lista lista = AdmLista.getInstancia().buscarListaXNombre(nombLista);
		
		JLabel lblNewLabel = new JLabel("Fecha Fin");
		lblNewLabel.setBounds(22, 47, 135, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Agasajo");
		lblNewLabel_1.setBounds(22, 88, 135, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Agasajado");
		lblNewLabel_2.setBounds(21, 126, 136, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email Agasajado");
		lblNewLabel_3.setBounds(22, 171, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dcFchFin = new JDateChooser();
		dcFchFin.setDate(lista.getFechaFin());
		dcFchFin.setBounds(196, 41, 148, 20);
		contentPane.add(dcFchFin);
		
		JDateChooser dcFchAga = new JDateChooser();
		dcFchAga.setDate(lista.getFechaAgasajo());
		dcFchAga.setBounds(196, 82, 148, 20);
		contentPane.add(dcFchAga);
		
		textFieldNomb = new JTextField();
		textFieldNomb.setText(lista.getNombreAgasajado());
		textFieldNomb.setBounds(196, 123, 148, 20);
		contentPane.add(textFieldNomb);
		textFieldNomb.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setText(lista.getMailAgasajado());
		textFieldMail.setBounds(196, 165, 148, 20);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JButton btnAgregarParticipante = new JButton("Agregar Participante");
		btnAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					PantallaAgregaParticipanteLista nuevoPartic = new PantallaAgregaParticipanteLista(lista.getCodigo());
					nuevoPartic.setLocationRelativeTo(null);
					nuevoPartic.setVisible(true);
			}
		});
		btnAgregarParticipante.setBounds(22, 227, 167, 23);
		contentPane.add(btnAgregarParticipante);
		
		JButton btnGuardar = new JButton("Guardar Cambios");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//guardar cambios
				java.sql.Date sqldate = new java.sql.Date(dcFchFin.getDate().getTime());
				java.sql.Date sqldate2 = new java.sql.Date(dcFchAga.getDate().getTime());
				lista.setFechaFin(sqldate);
				lista.setFechaAgasajo(sqldate2);
				lista.setNombreAgasajado(textFieldMail.getText());
				lista.setMailAgasajado(textFieldNomb.getText());
				if(AdmLista.getInstancia().modificarLista(lista) ==1 ) {
					JOptionPane.showMessageDialog(null,  "Lista modificada correctamente");
				}
				else {
					JOptionPane.showMessageDialog(null,  "Hubo un error al modificar los datos de la lista");
				}
				dispose();
			}
		});
		btnGuardar.setBounds(255, 227, 135, 23);
		contentPane.add(btnGuardar);
		
		JButton btnBajaLista = new JButton("Dar de baja la lista");
		btnBajaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas dar de baja la lista?", "Baja", JOptionPane.YES_NO_OPTION) == 0) {
					if (AdmLista.getInstancia().darDeBajaLista(lista) ==1 ) {
						JOptionPane.showMessageDialog(null,  "Lista dada de baja correctamente");
						}
					else {
					JOptionPane.showMessageDialog(null,  "Hubo un error al intentar dar de baja la lista");
					}
				}
				dispose();
			}
		});
		btnBajaLista.setBounds(22, 287, 167, 23);
		contentPane.add(btnBajaLista);
	}
}
