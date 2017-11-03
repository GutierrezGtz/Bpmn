package icones;



public class EventoInicial extends Elemento {
	
	
	EventoInicial(Elemento elemento, boolean requisitos) {
		super(elemento, requisitos);
	}
	
	private EventoInicial eventoInicial;
	private EventoFinal eventoFinal;
	
	
	//------------------------------>>>METODOS<<<------------------------------------------------------------
	

	
	public boolean proximoElemento() {
		if(requisitos == true) {
			//elemento.setElementoeventoInicial
			return true;
		}else {
			//elemento.setElemento(eventoFinal);
			return false;
		}
	}

//	public Elemento retornaElemento() {
//		return getElemento();
//		
//	}
}