package icones;

public class EventoInicial {
	
	


	//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	private boolean requisitos;

	EventoInicial(boolean requisitos) {
		this.requisitos = requisitos;
	}
	
	public boolean proximoElemento() {
		if(requisitos == true) {
			return true;
		}else {
			return false;
		}
	}
}
