package BPMn;

public class DesvioCondicionalExclusivo extends Tarefas  {
	
	public void condicao(boolean aTarefaHumana, boolean atingiuRequisitos) {
		
		if(aTarefaHumana == true) {
			//return conteudo aceito
		}else if(aTarefaHumana == false) {
			if(atingiuRequisitos == true) {
				//return precisa de modifica��o
			}else {
				//return conteudo rejeitado
			}
		}
	}
}
