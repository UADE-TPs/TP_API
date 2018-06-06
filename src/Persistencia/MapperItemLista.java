package Persistencia;

import Modelo.ItemLista;

public class MapperItemLista {
	
	private static MapperItemLista instancia;

	private MapperItemLista()
	{
		
	}
	
	public static MapperItemLista getInstancia()
	{
		if (instancia == null)
			instancia = new MapperItemLista();
		return instancia;
	}
	
	public void insert (int CodLista, ItemLista i) {
		
		
	}
	
}
