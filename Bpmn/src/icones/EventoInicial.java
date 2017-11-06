package icones;

public class EventoInicial extends Elemento {
	
	private EventoFinal eventoFinal;
	private Elemento elemento;
	//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	public Elemento proximoElemento(boolean requisitos, Elemento proximoElemento) {
		if(requisitos == true) {
			elemento = proximoElemento;
			return elemento;
		}else {
			return eventoFinal;
		}
	}
}