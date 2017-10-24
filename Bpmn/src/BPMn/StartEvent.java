package BPMn;

public class StartEvent extends Tarefas  {
	
	String Name;
	
	
	
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
	
	

}
