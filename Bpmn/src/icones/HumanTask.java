package icones;

public class HumanTask extends Elemento{


	private Elemento elemento;
	private EventoFinal eventoFinal;
	
	public boolean validaçãoHumana(boolean tarefaHumana) {
		if(tarefaHumana == true) {
			return true;
		}else {
			return false;
		}
	}


	public Elemento proximoElemento(Elemento proximoElemento) {
		if(validaçãoHumana(true)) {
			elemento = proximoElemento;
			return elemento;
			
		}else {
			return eventoFinal;
		}
	}
}	

