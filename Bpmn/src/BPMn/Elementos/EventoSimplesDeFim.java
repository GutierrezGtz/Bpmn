package BPMn.Elementos;

public class EventoSimplesDeFim extends Elemento {

	private EventoSimplesDeFim eventoFim;
	private Elemento fluxo;
	private StartEvent startEvent;

//------------------------------>>>METODOS<<<------------------------------------------------------------	
	
	@Override
	boolean proximoElemento(){
		if(fluxo.proximoElemento() == true) {
			fluxo.setElemento(eventoFim);
		}
		throw new IllegalArgumentException("FLUXO ACABOU");
	}	
	
	public Elemento acaoTerminaPorAtributos() {//quando atributos definidos em StartEvent não passam.
		if(startEvent.proximoElemento() == false) {
			throw new IllegalArgumentException("FLUXO ACABOU, ATRIBUTOS NÃO PASSARAM");
		}
		return fluxo.getElemento();
	}
	
	public Elemento acaoTerminaPorFluxo() {//quando o fluxo acaba (pode ser definido nas outras classes).
		throw new IllegalArgumentException("FLUXO ACABOU");
	}
	
	


}
