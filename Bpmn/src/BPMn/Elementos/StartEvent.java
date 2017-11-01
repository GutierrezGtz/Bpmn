package BPMn.Elementos;

public class StartEvent extends Elemento{
	
	

//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	private boolean requisitos;

	StartEvent(boolean requisitos) {
		this.requisitos = requisitos;
	}
	
	@Override
	public boolean proximoElemento() {
		if(requisitos == true) {
			return true;
		}else {
			return false;
		}
	}
}
 