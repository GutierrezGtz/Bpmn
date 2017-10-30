package BPMn;

public class TarefaHumana extends Elemento {
	
	private Elemento tarefaHumana;
	private String campoTexto;
	
	public Elemento fluxoEsta(Elemento novoElemento) {
		return tarefaHumana = novoElemento;
	}
	

	public Elemento changeType(Elemento trocaElemento) {
		return null;
	}
	
	
	public void retiraVariaveis() {
		
		
		
	}
	
	
	
	
}
