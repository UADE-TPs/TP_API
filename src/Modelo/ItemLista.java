package Modelo;

public class ItemLista {
	
	private Usuario particiante;
	private Pago pago;
	
	public ItemLista(Usuario participante) {
		this.particiante=participante;
		this.pago=null;
	}

	public Usuario getParticiante() {
		return particiante;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}



}
