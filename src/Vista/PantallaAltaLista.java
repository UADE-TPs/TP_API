package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JTextField txtPartic;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField txtMail;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;
	public PantallaAgregaParticipanteLista Pmail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAltaLista frame = new PantallaAltaLista();
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
	public PantallaAltaLista() {
		setTitle ("Nueva Lista de Evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnAgregarParticipante = new JButton("Agregar participante a la Lista");
		
//		JButton btnAceptar = new JButton("Aceptar");
		btnAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pmail =  new PantallaAgregaParticipanteLista();
				Pmail.setVisible(true);
			}
		});

		
		btnAgregarParticipante.setBounds(9, 290, 424, 25);
		contentPane.setLayout(null);
		
		
//		JLabel label_1 = new JLabel("");
//		label_1.setBounds(9, 10, 424, 25);
//		contentPane.add(label_1);
		
		txtPartic = new JTextField();
		txtPartic.setBounds(168, 28, 244, 25);
		txtPartic.setText("");
		contentPane.add(txtPartic);
		txtPartic.setColumns(10);

		JLabel lblEstadoDeLa = new JLabel("Estado de la lista");
		lblEstadoDeLa.setBounds(7, 228, 125, 25);
		
		JLabel lblMailDelAgasajado = new JLabel("Mail del agasajado");
		lblMailDelAgasajado.setBounds(9, 74, 125, 25);
		
		JLabel lblNombre = new JLabel("Nombre del agasajado");
		lblNombre.setBounds(9, 28, 155, 25);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha de agasajo");
		lblFecha.setBounds(9, 54, 120, 22);
		contentPane.add(lblFecha);
		
		JLabel lblMonto = new JLabel("Monto por participante");
		lblMonto.setBounds(7, 153, 142, 25);
		contentPane.add(lblMonto);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha inicio Lista");
		lblFechaDeInicio.setBounds(7, 178, 120, 25);
		contentPane.add(lblFechaDeInicio);
		
		JLabel lblFechaFinalizacin = new JLabel("Fecha fin Lista");
		lblFechaFinalizacin.setBounds(7, 203, 125, 25);
		contentPane.add(lblFechaFinalizacin);
		contentPane.add(lblEstadoDeLa);
		contentPane.add(lblMailDelAgasajado);
		contentPane.add(btnAgregarParticipante);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 153, 241, 25);
		textField_1.setText("$");
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 178, 241, 25);
		textField_2.setText("dd/mm/aaaa");
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("dd/mm/aaaa");
		textField_3.setColumns(10);
		textField_3.setBounds(166, 205, 244, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(167, 230, 244, 25);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setText("mail");
		textField_5.setColumns(10);
		textField_5.setBounds(168, 103, 244, 25);
		contentPane.add(textField_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 137, 425, 5);
		contentPane.add(separator);
		
		textField_6 = new JTextField();
		textField_6.setText("dd/mm/aaaa");
		textField_6.setColumns(10);
		textField_6.setBounds(168, 56, 244, 25);
		contentPane.add(textField_6);
		
		txtMail = new JTextField();
		txtMail.setText("mail");
		txtMail.setColumns(10);
		txtMail.setBounds(168, 81, 244, 25);
		contentPane.add(txtMail);
		
		
		JLabel label = new JLabel("Administrador de lista");
		label.setBounds(9, 101, 125, 25);
		contentPane.add(label);
		
	}
}
