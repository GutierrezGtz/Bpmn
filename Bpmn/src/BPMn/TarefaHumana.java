package BPMn;

public class TarefaHumana extends Elemento implements aponta {
	
	private Elemento tarefaHumana;
	private String campoTexto;
		
	TarefaHumana(String campoTexto, String nome){
		this.campoTexto = campoTexto;
		this.nome = nome;
		this.elemento = tarefaHumana;
	}
	
	public Elemento fluxoEsta(Elemento novoElemento) {
		return tarefaHumana = novoElemento;
	}
	

	public Elemento changeType(Elemento trocaElemento) {
		return null;
	}
	
	
	public void retiraVariaveis() {
		
		
		
	}
	
	
	
	
}
