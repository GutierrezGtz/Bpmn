package BPMn.Elementos;



public class StartEvent extends Elemento{
	
	

//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	private boolean requisitos;
	private StartEvent startEvent;
	private Elemento fluxo;
	

	StartEvent(boolean requisitos) {
		this.requisitos = requisitos;
	}

	@Override
	public boolean proximoElemento() {
		if(requisitos == true) {
			fluxo.setElemento(startEvent);
			return true;
		}else {
			return false;
		}
	}
}
 