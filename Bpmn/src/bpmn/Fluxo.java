package bpmn;

import java.io.Serializable;

public class Fluxo implements Serializable {
	String nome;
	
	
	public Fluxo(String nomeFluxo) {
		nome = nomeFluxo;
	}

	public void DefinirNome(String nomeFluxo){
        nome = nomeFluxo;
    }
	 
    public String ObterNome(){
        return nome;
    }
}
