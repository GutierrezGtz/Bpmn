package BPMn.Elementos;

public class DesvioCondicionalExclusivo extends Elemento  {
	

	private Elemento fluxo;
	private Elemento elemento;
	private DesvioCondicionalExclusivo DCE;
	

	//------------------------------>>>METODOS<<<------------------------------------------------------------

	@Override
	boolean proximoElemento(){
		if(fluxo.proximoElemento() == true) {
			DCE.condicao();
		}
		return true;
	}	
	
	public Elemento condicao() {//falta a possibiladade de ter duas opçoes na qual é false e uma leva a uma nova filtragem
		
		if(atingiuRequisitos() == false) {
			fluxo.setElemento(elemento);
		}else if(atingiuRequisitos() == true && atributosPassaram() == true) {
			fluxo.setElemento(elemento);
		}else {
			fluxo.setElemento(elemento);
		}
		return elemento;
	}
}

