package icones;

public class EventoInicial extends Elemento {
	
	
	//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	public Elemento ProximoElemento(Elemento proximoElemento) {
			elemento = proximoElemento;
			return elemento;
	}
	
	boolean RequisitosAtendidos(boolean atendeuRequisitos){
		if(atendeuRequisitos == true) {
			return true;
		}else {
			return false;
		}
		
	}	
	
	
	
	
}