package bpmn;


import java.util.ArrayList;
import java.util.HashMap;


public class BPMNElemento {
	
	ArrayList<Object> lista = new ArrayList<>();
	HashMap<String, String[]> connector = new HashMap<>();
	HashMap<String, String[]> valores = new HashMap<>();

	ArrayList<String> elementosSE = new ArrayList<String>();
	ArrayList<String> elementosHT = new ArrayList<String>();
	ArrayList<String> elementosEG = new ArrayList<String>();
	ArrayList<String> elementosEE = new ArrayList<String>();

	private EndEvent endEvent;
	private String respPergunta;
	private String CampoTipo;
	private boolean valida;
	private String ultimoValor;
	String nomeFluxo;
	String nomeElemento;
	
//------------------------------>>>METODOS ADICIONA<<<-----------------------------	

	public void adicionaElemento(HumanTask humanTask) {
		lista.add(humanTask.getName());
		elementosHT.add(humanTask.getName());
	}

	public void adicionaElemento(StartEvent startEvent) {
		lista.add(startEvent.getName());
		elementosSE.add(startEvent.getName());
	}

	public void adicionaElemento(EndEvent endEvent) {
		lista.add(endEvent.getName());
		this.endEvent = endEvent;
		elementosEE.add(endEvent.getName());
	}

	public void adicionaElemento(ExclusiveGateway exclusiveGateway) {
		lista.add(exclusiveGateway.getName());	
		elementosEG.add(exclusiveGateway.getName());	
	}
//------------------------------>>>METODOS COUNT/CONNECT<<<-----------------------------	

	public Object countElements() {
		return lista.size();
	}


	public void connect(String string, String[] strings)throws Exception {//resposta vem
		
		if(!lista.contains(string)) {
			throw new IllegalArgumentException("Elemento Inexistente");
		}
		
		for(int i = 0; i < strings.length; i++) {
			if(!lista.contains(strings[i])) {
				throw new IllegalArgumentException("Elemento Inexistente");
			} else {
				connector.put(string, strings);
			} 
		}
	}
//------------------------------>>> METODO NEXT's <<<-----------------------------	

	public String getNextElement(String string) {
		connector.containsKey(string);
		if(valores.get(ultimoValor) != null && connector.get(string).length > 1 ) {//valores são opçoes e a string que entra é do next
			if(valida == true) {
				if(connector.get(string)[0].equals(endEvent.getName())) {
					return string + ", " + respPergunta;
				}
			}else if(valida == false) {
				if(connector.get(string)[1].equals(endEvent.getName())) {
					return string + ", " + respPergunta;	
				}	
			}
		}
		if(connector.get(string)[0].equals(endEvent.getName())) {
			return string;
		}
		return connector.get(string)[0];
		
	}
	

	
	
//------------------------------>>> FORMULARIO <<<<--------------------------------
	
	public void campoFormulario(String tipo, String key, String[] opcoes) {
		ultimoValor = key;
		valores.put(key, opcoes);
		CampoTipo = tipo;
		if(opcoes.length > 2) {
			throw new IllegalArgumentException("Numero de Elementos no Formulario Maior que 2");
		}
	}

	public void preencheFormulario(String key, String respPergunta) {
		this.respPergunta = respPergunta;
		switch(CampoTipo) {
			case "V ou F":  
					if(this.respPergunta == valores.get(key)[0]) {
						valida = true;
					}else if(this.respPergunta == valores.get(key)[1]) {
						valida = false;
					}
		}
	}
//------------------------------>>> NOME FLUXO <<<----------------------------------

	public String nomeDoFluxo(String nomeFluxo) {
		this.nomeFluxo = nomeFluxo;
		return nomeFluxo;	
	}
//----------------------------->>> PERSISTENCIA <<<---------------------------------	
	
	public void save(Fluxo fluxo) {
		Persistencia p = new Persistencia();
		p.save(fluxo);
	}

	public ArrayList<String> retornaEE() {
		
		return elementosEE;
	}

	public ArrayList<String> retornaSE() {
		return elementosSE;
	}

	public ArrayList<String> retornaHT() {
		return elementosHT;
	}

	public ArrayList<String> retornaEG() {
		return elementosEG;
	}
	
	
	
	
	
	
	
}