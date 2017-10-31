package BPMn.Elementos;

public class StartEvent extends Elemento{
	
	private Elemento startEvent;
	private Elemento fluxo;
	private EventoSimplesDeFim endEvent;

//------------------------------>>>METODOS<<<------------------------------------------------------------
	@Override
	boolean proximoElemento(){
		if(atributosPassaram() == true) {
			fluxo.setElemento(startEvent);
			return true;
		}else{
			fluxo.setElemento(endEvent);
			return false;//posso definir o fim aqui ou no EventoSimplesDeFim
		}
	}
	
	
	
	
}
 