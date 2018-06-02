package Modelo;

public class ItemLista {
	
	private Usuario particiante;
	private float pago;
	public ItemLista(Usuario participante, int pago) {
		this.particiante=participante;
		this.pago=pago;
	}

//Getters
	public Usuario getParticipante() {
	return this.particiante;
}
public float getPago() {
	return this.pago;
}

}
