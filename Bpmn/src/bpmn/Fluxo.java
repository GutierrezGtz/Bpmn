package bpmn;

import java.util.ArrayList;
import java.util.HashMap;

public class Fluxo {
    
	private String nome;
	
	BPMNElemento elemento = new BPMNElemento();
	
	private ArrayList<String> elementos_SE;
	private ArrayList<String> elementos_HT; 
	private ArrayList<String> elementos_EG;
	private ArrayList<String> elementos_EE;
	
	private ArrayList<Object> lista_ = new ArrayList<>();
	private ArrayList<String> keyConnector;
	private ArrayList<String> valueConnector;

	private ArrayList<String> linhas;
	
	public Fluxo() {
		
	}
	
    public Fluxo(String nome, ArrayList<String> elementos_SE, ArrayList<String> elementos_HT, ArrayList<String> elementos_EG, ArrayList<String> elementos_EE, ArrayList<Object> lista_, ArrayList<String> arrayList2, ArrayList<String> arrayList) {
        this.nome = nome; 
        this.setElementos_SE(elementos_SE);
        this.setElementos_HT(elementos_HT);
        this.setElementos_EG(elementos_EG);
        this.setElementos_EE(elementos_EE);
        this.setLista_(lista_);
        this.setKeyConnector(arrayList2);
        this.setValueConnector(arrayList);
    }


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public ArrayList<String> getElementos_HT() {
		return elementos_HT;
	}

	public void setElementos_HT(ArrayList<String> elementos_HT) {
		this.elementos_HT = elementos_HT;
	}

	public ArrayList<String> getElementos_EG() {
		return elementos_EG;
	}

	public void setElementos_EG(ArrayList<String> elementos_EG) {
		this.elementos_EG = elementos_EG;
	}

	public ArrayList<String> getElementos_EE() {
		return elementos_EE;
	}

	public void setElementos_EE(ArrayList<String> elementos_EE) {
		this.elementos_EE = elementos_EE;
	}


	public ArrayList<String> getElementos_SE() {
		return elementos_SE;
	}


	public void setElementos_SE(ArrayList<String> elementos_SE) {
		this.elementos_SE = elementos_SE;
	}


	public ArrayList<Object> getLista_() {
		return lista_;
	}


	public void setLista_(ArrayList<Object> lista_) {
		this.lista_ = lista_;
	}

	public ArrayList<String> getKeyConnector() {
		return keyConnector;
	}


	public void setKeyConnector(ArrayList<String> arrayList2) {
		this.keyConnector = arrayList2;
	}


	public ArrayList<String> getValueConnector() {
		return valueConnector;
	}


	public void setValueConnector(ArrayList<String> valueConnector) {
		this.valueConnector = valueConnector;
	}


	public boolean getVerificadorDeNome(String rVer) {
		if(elemento.listaFluxos.contains(rVer)) {
			this.setNome(rVer);
			return true;
		}else {
			return false;
		}
			
		
	}
	
	public void trataLeitura(String linha) {
		linhas.add(linha);
		this.nome = linhas.get(0);
		//this.elementos_SE = linhas.get(1);
		
	}



}
