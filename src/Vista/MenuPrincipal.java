package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controlador.AdmLista;
import Controlador.AdmUsr;
import Modelo.Lista;
import Persistencia.PoolConnection;

import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class MenuPrincipal extends JFrame {

	public MenuPrincipal() {
		
		try {
			
		setTitle("Sistema Lista de Regalos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 410);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);
		
		JMenuItem mntmNuevaLista = new JMenuItem("Nueva Lista");
		mntmNuevaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PantallaAltaLista altaLista = new PantallaAltaLista();
				altaLista.setLocationRelativeTo(null);
				altaLista.setVisible(true);
			}
		});
		mnLista.add(mntmNuevaLista);
		
		JMenu mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		JMenuItem mntmMisDatos = new JMenuItem("Mis Datos");
		mntmMisDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifDatosUsr modifUsr = new ModifDatosUsr();
				modifUsr.setLocationRelativeTo(null);
				modifUsr.setVisible(true);
			}
		});
		mnConfiguracin.add(mntmMisDatos);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas darte de baja?", "Baja", JOptionPane.YES_NO_OPTION) == 0) {
					if (AdmUsr.getInstancia().bajaUsr() == 1 ) {
							PoolConnection.getPoolConnection().closeConnections();
							System.exit(0);
						}
					}
				}
		});
		
		mnConfiguracin.add(mntmBaja);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir?", "Salir", JOptionPane.YES_NO_OPTION) == 0)
				{
					PoolConnection.getPoolConnection().closeConnections();
					System.exit(0);
				}
			}
		});
		mnSistema.add(mntmSalir);
		getContentPane().setLayout(null);
		
		// LISTAS ADMINISTRADAS ***************************************************************

		
		JLabel lblListasAdministradas = new JLabel("Listas administradas");
		lblListasAdministradas.setBounds(10, 22, 244, 14);
		getContentPane().add(lblListasAdministradas);
		
		JList listAdm = new JList(AdmLista.getInstancia().devolverNombreListasAdm());
		listAdm.setBounds(10, 47, 244, 227);
		getContentPane().add(listAdm);
		
		JScrollPane barraDesplazamientoA = new JScrollPane(listAdm); 
		barraDesplazamientoA.setBounds(10, 47, 244, 227); 
		getContentPane().add(barraDesplazamientoA);
		
		listAdm.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		listAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("VAlor " + listAdm.getSelectedValue().toString());
				ModificarLista modifLista = new ModificarLista(listAdm.getSelectedValue().toString());
				modifLista.setLocationRelativeTo(null);
				modifLista.setVisible(true);
			}
		});
		
		//LISTAS PARTICIPADAS ***************************************************************
		
		Vector<String> listasPar = AdmLista.getInstancia().devolverNombreListasPar();
		
		JLabel lblListasEnLas = new JLabel("Listas en las que participo");
		lblListasEnLas.setBounds(303, 22, 244, 14);
		getContentPane().add(lblListasEnLas);
		
		JList listPar = new JList(listasPar);
		listPar.setBounds(303, 47, 244, 227);
		getContentPane().add(listPar);
		
		JScrollPane barraDesplazamientoP = new JScrollPane(listPar); 
		barraDesplazamientoP.setBounds(303, 47, 244, 227); 
		getContentPane().add(barraDesplazamientoP);
		
		listPar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		listPar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Pendiente de programa - Pago de la lista en la que participo");
				 }
		});
		// FIN PRUEBA

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
