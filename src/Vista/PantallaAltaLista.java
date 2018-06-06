package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;



import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import Controlador.AdmUsr;
import Controlador.SistemaEmail;

public class PantallaAltaLista extends JFrame {

	private JPanel contentPane;
	private JTextField txtAgasajado;
	private JTextField textMonto;
	private JTextField txtMail;
	private JTextField txtLista;
	public PantallaAgregaParticipanteLista Pmail;


	/**
	 * Create the frame.
	 */
	public PantallaAltaLista() {
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLista = new JLabel("Nombre de la lista");
		lblLista.setBounds(9, 11, 155, 25);
		contentPane.add(lblLista);
		
		txtLista = new JTextField();
		txtLista.setBounds(168, 11, 244, 25);
		contentPane.add(txtLista);
		txtLista.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre del agasajado");
		lblNombre.setBounds(9, 54, 155, 25);
		contentPane.add(lblNombre);
		
		txtAgasajado = new JTextField();
		txtAgasajado.setBounds(168, 50, 244, 25);
		contentPane.add(txtAgasajado);
		txtAgasajado.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha de agasajo");
		lblFecha.setBounds(9, 79, 120, 22);
		contentPane.add(lblFecha);
		
		JDateChooser fchAgsajo = new JDateChooser();
		fchAgsajo.setBounds(168, 76, 241, 25);
		contentPane.add(fchAgsajo);
		
		JLabel lblMailDelAgasajado = new JLabel("Mail del agasajado");
		lblMailDelAgasajado.setBounds(9, 101, 125, 25);
		contentPane.add(lblMailDelAgasajado);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(168, 101, 244, 25);
		contentPane.add(txtMail);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 137, 425, 5);
		contentPane.add(separator);
	
		
		JLabel lblMonto = new JLabel("Monto por participante");
		lblMonto.setBounds(9, 153, 142, 25);
		contentPane.add(lblMonto);
		
		textMonto = new JTextField();
		textMonto.setBounds(168, 153, 241, 25);
		textMonto.setColumns(10);
		contentPane.add(textMonto);

		
		JLabel lblFechaDeInicio = new JLabel("Fecha inicio Lista");
		lblFechaDeInicio.setBounds(9, 178, 120, 25);
		contentPane.add(lblFechaDeInicio);
		
		JDateChooser fchInicio = new JDateChooser();
		fchInicio.setBounds(168, 178, 244, 25);
		contentPane.add(fchInicio);
		
		JLabel lblFechaFinalizacin = new JLabel("Fecha fin Lista");
		lblFechaFinalizacin.setBounds(9, 203, 125, 25);
		contentPane.add(lblFechaFinalizacin);
		
		JDateChooser fchFin = new JDateChooser();
		fchFin.setBounds(168, 203, 244, 25);
		contentPane.add(fchFin);
		
		JButton btnAgregarParticipante = new JButton("Agregar participante a la Lista");
		btnAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR DATOS INGRESADOS
				if(VerificarTxt(txtLista.getText(), lblLista.getText())) { //nombre de lista
					if(VerificarTxt(txtAgasajado.getText(), lblNombre.getText())) { //nombre agasajado
						if(VerificarTxt(txtMail.getText(), lblMailDelAgasajado.getText())) { //mail agasajado
							if(VerificarMonto(textMonto.getText(),lblMonto.getText())) { //monto
								if(VerificarFecha(fchAgsajo)) {
									//verificar las tres fechas en orden12
									//Formato sql date
									java.sql.Date fchAgsajosql = new java.sql.Date(fchAgsajo.getDate().getTime());
									} 
							 } //fin monto
						   } //fin mail agasajado
						} //fin nombre agasajado 
					} // fin nombre lista 			
				} //fin verificación de campos
				
				 } 	//fin mouseClicked	btnAgregarParticipante	 
			
	);
		btnAgregarParticipante.setBounds(9, 290, 424, 25);
		contentPane.setLayout(null);
		
		// Bajo a BD los datos de la lista
		contentPane.add(btnAgregarParticipante);
		
		/*JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(9, 50, 1, 2);
		contentPane.add(separator_1);
		*/
	}
// mtodos para validar campos
private boolean VerificarTxt (String d, String lbl) {
	if(d.isEmpty()) {
		JOptionPane.showMessageDialog(null,  "Falta completar el campo " + lbl);
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
private boolean VerificarMonto (String m1, String m2) {
	if(m1.isEmpty() || m2.isEmpty() || !m1.equals(m2)) {
		JOptionPane.showMessageDialog(null,  "Los emails ingresados no coinciden o faltan completar");
		return false;
	}
	return true;
}
	
}
