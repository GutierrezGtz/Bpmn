package BPMn;

public class TarefaHumana extends Elemento implements aponta {
	
	
	private String campoTexto;
	private Elemento tH;
	
	TarefaHumana(String campoTexto, Elemento tH, String nome){
		this.campoTexto = campoTexto;
		this.tH = tH;
		this.nome = nome;
	}
	
	public Elemento apontaPara(Elemento Elemento1) {
		return this.tH = Elemento1;
	}

	@Override
	public Elemento changeType(Elemento trocaElemento) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
