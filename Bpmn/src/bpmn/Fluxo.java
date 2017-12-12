package bpmn;

import java.util.ArrayList;

public class Fluxo {
    private String nome = "";
    private ArrayList<String> listaFluxos = new ArrayList<>();
	private String verificadorDeNome;
	
	Fluxo f;
    public Fluxo() {
    }

    public Fluxo(String nome) {
        this.setNome(nome);

    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getListaFluxos() {
		return listaFluxos;
	}

	public void setListaFluxos(ArrayList<String> linhas) {
		this.listaFluxos = linhas;
	}

	public String getVerificadorDeNome() {
		return verificadorDeNome;
	}

	public void setVerificadorDeNome(String verificadorDeNome) {
		this.verificadorDeNome = verificadorDeNome;
	}

	public void recebendoDados(ArrayList<String> linhas) {
		f.nome = linhas.get(0);
		
	}

}
