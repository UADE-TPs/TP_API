package Controlador;

import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import Modelo.Lista;
import Persistencia.MapperLista;
import Persistencia.MapperUsuario;
import Modelo.Usuario;



public class AdmLista {
	
	private Vector<Lista> listas;
	private static AdmLista instancia;
	private Lista l;
	
	private AdmLista(){
		listas = MapperLista.getInstancia().selectAll();
		
	}
	
	public static AdmLista getInstancia()
	{
		if (instancia==null)
			instancia = new AdmLista();
		return instancia;
	}
//Alta de la lista 
	public int generarLista (int c, Usuario u, float m, Date f1, Date ff, String n, Date fa, String e) 
	{
		//Verificar que no exista en la BD
		Lista l = MapperLista.getInstancia().buscarLista(u.getDni());
		if (l == null) {
			l = new Lista(c,u,m,f1,ff,n,fa,e);
			listas.addElement(l);
			return 1;
		}
		return 0;
		
	}

	public int  bajaLista ()
	{
		//Cambiar el estad de la lista a inactiva
		return 0;
	}
	public Lista buscarLista(int c)
	{
		return MapperLista.getInstancia().buscarLista(c);
	}
	
	public int modificarLista (int cod, int monto, Date fchIni, Date fechFin, Date fechAga,
			String nomAga, String mailAga)
	{
		l=buscarLista(cod);
		l.setMonto(monto);
		l.setfechaInicio(fchIni);
		l.setFechaFin(fechFin);
		l.setFechaAgasajo(fechAga);
		l.setMailAgasajado(mailAga);
	
		return MapperLista.getInstancia().modificarDatosLista(l);
	}





}




/*
	generarLista(Ususario a, float m, Date fi, Date ff, String n, Date fa, String e): Lista
	obtenerLista(int codLista): Lista
	eliminarLista(Lista l): int
	modificarMontoARecaudar(Lista l, float m): int
	agregarPagoAParticLista(int codLista, Usuario u, Pago p): int
	modificarFchInicio(Lista l, Date f): int
	modificarNombAgasajado(Lista l, String n): int
	modificarFchAgasajo(Lista l, Date f): int
	modificarmailAgasajado(Lista l, String m): int
	
	
	
*/

