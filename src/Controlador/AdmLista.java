package Controlador;

import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import Modelo.Lista;
import Persistencia.MapperLista;
import Persistencia.MapperUsuario;
import Modelo.Usuario;
import Modelo.ItemLista;
import Modelo.Pago;


public class AdmLista {
	
	private Vector<Lista> listasAdm;
	private Vector<Lista> listasPar;
	private Vector<String> nombListasAdm;
	private Vector<String> nombListasPar;
	private static AdmLista instancia;

	
	private AdmLista(){
		listasAdm = MapperLista.getInstancia().selectListasAdm(AdmUsr.getInstancia().loggedUsr().getDni());
		listasPar = MapperLista.getInstancia().selectListasPar(AdmUsr.getInstancia().loggedUsr().getDni());
		nombListasAdm = armarVectorNombres (listasAdm);
		nombListasPar = armarVectorNombres (listasPar);
	}
	
	public static AdmLista getInstancia()
	{
		if (instancia==null)
			instancia = new AdmLista();
		return instancia;
	}
//Alta de la lista 

	public int generarLista (String nomLis, Usuario usr, float mont, Date fchini, Date fchfin, Date fchaga, String nomaga, String mail) 
	{
		//Creamos la lista en la BD
		Lista l = new Lista(nomLis, usr, mont, fchini, fchfin, fchaga, nomaga, mail);
		listasAdm.addElement(l);
		return l.getCodigo();
	}
	
	public int generarItemLista (int cl, Usuario p) 
	{
		//Creamos la Itemlista en la BD
		ItemLista il = new ItemLista(cl,p);
		System.out.println("creo item");
		insertarItemEnList(il);
		return 1;
	}
		

	public int darDeBajaLista (Lista l)
	{
		if (MapperLista.getInstancia().bajaLista(l.getCodigo()) == 1) {
			eliminarListaNombreLista(l.getNombreLista());
			listasAdm.remove(listasAdm.indexOf(l));	
			return 1;
		}
		return 0;
	}
	
	private void insertarItemEnList (ItemLista il) {
		System.out.println("busco lista");
		Lista l = buscarLista(il.getcodLista());
		System.out.println("agrego item");
		l.insertarItem(il);
	}
	
	public Lista buscarLista(int c)
	{
		Lista l = buscarCod(c);
		if ( l == null) {
			l = MapperLista.getInstancia().buscarLista(c);;
			listasAdm.add(l);
		}
		return l;
	}
	
	public Lista buscarCod (int c) {
		if (!listasAdm.isEmpty()) {
			for(Lista l : listasAdm) {
	            if (l.getCodigo() == c) {
	            	return l;
	            };
	        }
		}
		return null;
	}
	
	public Lista buscarListaXNombre (String n) {
		if (!listasAdm.isEmpty()) {
			for(Lista l : listasAdm) {
	            if (l.getNombreLista().equals(n)) {
	            	return l;
	            };
	        }
		}
		return null;
	}
	
	public int modificarLista (Lista l)
	{	
		return MapperLista.getInstancia().modificarDatosLista(l);
	}
	
	public Vector<String> devolverNombreListasAdm () {	
		return nombListasAdm;
	}
	
	public Vector<String> devolverNombreListasPar () {
		return nombListasPar;
	}
	
	private Vector<String> armarVectorNombres (Vector<Lista> lista) {
		Vector<String> listNom = new Vector<String> ();
		for(Lista l : lista) {
			listNom.addElement( l.getNombreLista());
			 System.out.println("nombre " + l.getNombreLista());
            }		
		return listNom;
	}
	
	private void eliminarListaNombreLista (String n) {
		System.out.println("eliminarListaNombreLista");
		String del = null;
		for(String l : nombListasAdm) {
			if (l.equals(n)) {
				System.out.println("encontro ");
				del = l;
			}
        }
		if (del != null && nombListasAdm.remove(del)) {
			System.out.println("removio ok ");
		}
	}

}
