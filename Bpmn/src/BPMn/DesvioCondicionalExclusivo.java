package BPMn;

public class DesvioCondicionalExclusivo extends Elemento implements aponta {
	
	
	private Elemento desvioCondicional;
	
	DesvioCondicionalExclusivo(Elemento desvioCondicional, String nome){
		this.desvioCondicional = desvioCondicional;
		this.nome = nome;
	}
	
	public Elemento fluxoEsta(Elemento novoElemento) {
		return desvioCondicional = novoElemento;
	}

	public Elemento condicao() {//falta a possibiladade de ter duas op�oes na qual � false e uma leva a uma nova filtragem
		
		if(atingiuRequisitos() == false) {
			return elemento;
		}else if(atingiuRequisitos() == true) {
			return elemento;
		}else {
			return elemento;//criar metodo que o novo elemento sera o elemento clicado
		}
	}
}

