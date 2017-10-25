package BPMn;

public class DesvioCondicionalExclusivo extends Elemento implements aponta {
	
	private Elemento desvioCondicional;
	
	DesvioCondicionalExclusivo(Elemento desvioCondicional){
		this.desvioCondicional = desvioCondicional;
	}
	
	
	public Elemento condicao(boolean tarefaUsuario, boolean atingiuRequisitos) {
		
		if(tarefaUsuario == true) {
			Elemento apontaPara(Elemento Elemento1) {
				return this.desvioCondicional = Elemento1;
			}
		}else if(tarefaUsuario == false) {
			if(atingiuRequisitos == true) {
				
			}else {
				
			}
		}
	}

	


	@Override
	public Elemento changeType(Elemento trocaElemento) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
