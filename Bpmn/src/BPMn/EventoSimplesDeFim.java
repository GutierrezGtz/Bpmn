package BPMn;

public class EventoSimplesDeFim extends Elemento {

	private Elemento eventoFim;
	private Elemento fluxo;
	
	
	
	public Elemento acaoTerminaPorAtributos() {//quando atributos definidos em StartEvent não passam.
		if(fluxo.proximoElemento() == false) {
			fluxo.setElemento(eventoFim);
		}
		return fluxo.getElemento();
	}
	
	public Elemento acaoTerminaPorFluxo() {//quando o fluxo acaba (pode ser definido nas outras classes).
		return eventoFim;
	}
	


}
