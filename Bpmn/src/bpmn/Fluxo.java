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
	private HashMap<String, String[]> connector_ = new HashMap<>();
	private HashMap<String, String[]> valores_ = new HashMap<>();
	
    public Fluxo(String nome, ArrayList<String> elementos_SE, ArrayList<String> elementos_HT, ArrayList<String> elementos_EG, ArrayList<String> elementos_EE, ArrayList<Object> lista_, HashMap<String, String[]> connector_, HashMap<String, String[]> valores_ ) {
        this.nome = nome; 
        this.setElementos_SE(elementos_SE);
        this.setElementos_HT(elementos_HT);
        this.setElementos_EG(elementos_EG);
        this.setElementos_EE(elementos_EE);
        this.setLista_(lista_);
        this.setConnector_(connector_);
        this.setValores_(valores_);
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


	public HashMap<String, String[]> getConnector_() {
		return connector_;
	}


	public void setConnector_(HashMap<String, String[]> connector_) {
		this.connector_ = connector_;
	}


	public HashMap<String, String[]> getValores_() {
		return valores_;
	}


	public void setValores_(HashMap<String, String[]> valores_) {
		this.valores_ = valores_;
	}




}
