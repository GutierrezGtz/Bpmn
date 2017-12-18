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
	
	private ArrayList<Object> lista = new ArrayList<>();
	private HashMap<String, String[]> connector = new HashMap<>();
	private HashMap<String, String[]> valores = new HashMap<>();
	
    public Fluxo(String nome, ArrayList<String> elementos_SE, ArrayList<String> elementos_HT, ArrayList<String> elementos_EG, ArrayList<String> elementos_EE ) {
        this.nome = nome; 
        this.setElementos_SE(elementos_SE);
        this.setElementos_HT(elementos_HT);
        this.setElementos_EG(elementos_EG);
        this.setElementos_EE(elementos_EE);
        this.setLista(elemento.lista);
        this.setConnector(elemento.connector);
        this.setValores(elemento.valores);
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

	public ArrayList<Object> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Object> lista) {
		this.lista = lista;
	}

	public HashMap<String, String[]> getConnector() {
		return connector;
	}

	public void setConnector(HashMap<String, String[]> connector) {
		this.connector = connector;
	}

	public HashMap<String, String[]> getValores() {
		return valores;
	}

	public void setValores(HashMap<String, String[]> valores) {
		this.valores = valores;
	}


	public ArrayList<String> getElementos_SE() {
		return elementos_SE;
	}


	public void setElementos_SE(ArrayList<String> elementos_SE) {
		this.elementos_SE = elementos_SE;
	}

}
