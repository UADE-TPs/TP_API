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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JSeparator;

public class PantallaAltaLista extends JFrame {

	private JPanel contentPane;
	private JTextField txtAgasajado;
	private JTextField textMonto;
	private JTextField txtMail;
	private JTextField txtlista;
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
		lblLista.setBounds(9, 18, 155, 25);
		contentPane.add(lblLista);
		
		txtlista = new JTextField();
		txtlista.setBounds(168, 18, 244, 25);
		contentPane.add(txtlista);
		txtlista.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre del agasajado");
		lblNombre.setBounds(9, 28, 155, 25);
		contentPane.add(lblNombre);
		
		txtAgasajado = new JTextField();
		txtAgasajado.setBounds(168, 28, 244, 25);
		contentPane.add(txtAgasajado);
		txtAgasajado.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha de agasajo");
		lblFecha.setBounds(9, 54, 120, 22);
		contentPane.add(lblFecha);
		
		JDateChooser fchAgsajo = new JDateChooser();
		fchAgsajo.setBounds(168, 54, 241, 25);
		contentPane.add(fchAgsajo);
		
		JLabel lblMailDelAgasajado = new JLabel("Mail del agasajado");
		lblMailDelAgasajado.setBounds(9, 74, 125, 25);
		contentPane.add(lblMailDelAgasajado);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(168, 74, 244, 25);
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
		btnAgregarParticipante.setBounds(9, 290, 424, 25);
		contentPane.setLayout(null);
		btnAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//VERIFICAR DATOS INGRESADOS
				//ALTA LISTA: generarLista
				Pmail =  new PantallaAgregaParticipanteLista();
				Pmail.setVisible(true);
			}
		});
		contentPane.add(btnAgregarParticipante);
	}
}
