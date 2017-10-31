package BPMn.Elementos;

public class TarefaHumana extends Elemento {
	
	private Elemento humanTask;
	private String campoTexto;
	private Elemento fluxo;

	TarefaHumana(String campoTexto){
		this.campoTexto = campoTexto;

	}
	
	//abc
//------------------------------>>>GET/SETTERS<<<------------------------------------------------------------
	
	public String getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(String campoTexto) {
		this.campoTexto = campoTexto;
	}
	
	
//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	public boolean validaçãoHumana(boolean tarefaHumana) {
		if(tarefaHumana == true) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	boolean proximoElemento(){
		if(fluxo.proximoElemento() == true) {
			fluxo.setElemento(humanTask);// chamar o outro metodo dentro desse depois de retirar a variaveis segue o fluxo
		}
		return true;
	}	
}
