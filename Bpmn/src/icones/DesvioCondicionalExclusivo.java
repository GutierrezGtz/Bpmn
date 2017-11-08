package icones;

public class DesvioCondicionalExclusivo extends Elemento {

	HumanTask humanTask = new HumanTask();
	EventoInicial eventoInicial = new EventoInicial();
	
	
	public Elemento ProximoElemento(Elemento proximoElemento) {
		if(requisitosAtendidos == true) {//pode ser respodido pelo filtrafluxo
			
		}else if(requisitosAtendidos == false) {
			
		}else {
			
		} 
	}

	public boolean FiltraFluxo() {
	
		return false;
	}
	
	
	

	
	Elemento TestandoElemento(Elemento proximoElemento) {
		if(proximoElemento == humanTask) {
			elemento = humanTask;
		}else if(proximoElemento == eventoInicial) {
			elemento = eventoInicial;
		}
		return elemento;
	}
	
}
