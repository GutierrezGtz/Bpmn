package BPMn;

public class StartEvent extends Elemento implements aponta {
	
	private String Name;
	private Elemento startEvent;
	
	
	StartEvent(String Name){
		
		this.Name = Name;
	}
	
	boolean atributosPassaram(){
		
		if(atributosAtendidos() == true) {
			return true;
		} else {
			return false;
		}
	}

	private boolean atributosAtendidos() {
//		compara os atributos passados com Dados de entrada
//		se atender os resquisitos retorna true parao metodo atributosPassaram()
		
		return true;
	}

	public Elemento apontaPara(Elemento Elemento1) {
		return this.startEvent = Elemento1;
	}
	

	@Override
	public Elemento changeType(Elemento trocaElemento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
