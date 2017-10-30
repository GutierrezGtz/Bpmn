package BPMn;

public class StartEvent extends Elemento{
	
	private Elemento startEvent;
	private Elemento fluxo;
	
	
	boolean proximoElemento(){
		if(atributosPassaram() == true) {
			fluxo.setElemento(startEvent);
			return true;
		}else{
			return fluxo.terminou();
		}
	}
}
