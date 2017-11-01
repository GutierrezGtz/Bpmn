package BPMn.Elementos;

public class DesvioCondicionalExclusivo extends Elemento  {
	

	private Elemento fluxo;
	private Elemento elemento;
	private DesvioCondicionalExclusivo DCE;
	private EventoSimplesDeFim endEvent;

	//------------------------------>>>METODOS<<<------------------------------------------------------------

	@Override
	boolean proximoElemento(){	
		if(fluxo.proximoElemento() == true) {
			DCE.condicao();
		}
		return true;
	}
	
	
	public Elemento condicao() {
		
		if(atributosPassaram() == false) {
			fluxo.setElemento(endEvent);
		}else if(atributosPassaram() == true && atingiuRequisitos() == true ) {// atingiuRequisitos()  PRECISA IMPLEMENTAÇÃO
			fluxo.setElemento(elemento);
		}else {
			fluxo.setElemento(elemento);
		}
		return elemento;
	}
}

