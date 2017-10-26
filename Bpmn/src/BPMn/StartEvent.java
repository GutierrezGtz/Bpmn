package BPMn;

public class StartEvent extends Elemento implements aponta {
	
	private Elemento startEvent;

	StartEvent(String nome){
		this.nome = nome;
		this.elemento = startEvent;
	}
	
	public Elemento fluxoEsta(Elemento novoElemento) {
		return startEvent = novoElemento;
	}
	
	boolean atributosPassaram(){
		
		if(atingiuRequisitos() == true) {
			return true;
		} else {
			return false;
		}
	}

	
	
	@Override
	public Elemento changeType(Elemento trocaElemento) {
		return null;
	}
	
	

}
