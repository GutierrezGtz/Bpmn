package BPMn;

public class EventoSimplesDeFim extends Elemento implements aponta {

	private Elemento eventoFim;
	
	
	public Elemento apontaPara(Elemento Elemento1) {
		return this.eventoFim = Elemento1;
	}


	@Override
	public Elemento changeType(Elemento trocaElemento) {
		// TODO Auto-generated method stub
		return null;
	}

}
