package Modelo;

public class ItemLista {
	
	private int codItem;
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

	public void setCodItem(int cod) {
		this.codItem = codItem;
	}

	public int getCodItem() {
		return this.codItem;
	}
	
}
