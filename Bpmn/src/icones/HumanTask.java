package icones;

public class HumanTask extends Elemento{


	private Elemento elemento;
	private EventoFinal eventoFinal;
	
	public boolean valida��oHumana(boolean tarefaHumana) {
		if(tarefaHumana == true) {
			return true;
		}else {
			return false;
		}
	}


	public Elemento proximoElemento(Elemento proximoElemento) {
		if(valida��oHumana(true)) {
			elemento = proximoElemento;
			return elemento;
			
		}else {
			return eventoFinal;
		}
	}
}	

