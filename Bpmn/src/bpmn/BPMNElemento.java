package bpmn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class BPMNElemento {
	Persistencia p = new Persistencia();
	
	ArrayList<Object> lista = new ArrayList<>();
	HashMap<String, String[]> connector = new HashMap<>();
	HashMap<String, String[]> valores = new HashMap<>();
	ArrayList<String> elementosSE = new ArrayList<String>();
	ArrayList<String> elementosHT = new ArrayList<String>();
	ArrayList<String> elementosEG = new ArrayList<String>();
	ArrayList<String> elementosEE = new ArrayList<String>();
	
	String nomeElemento;
	
	ArrayList<Object> listaFluxos = p.linhas2;
	String[] listaDeOpcoes;
	private boolean resposta = true;
	private EndEvent endEvent;
	private String respPergunta;
	String nomeFluxo;
	
//------------------------------>>>METODOS ADICIONA<<<-----------------------------	

	public void adicionaElemento(HumanTask humanTask) {
		lista.add(humanTask.getName());
		
	}
	
	public void adicionaElemento(StartEvent startEvent) {
		lista.add(startEvent.getName());
	}

	public void adicionaElemento(EndEvent endEvent) {
		lista.add(endEvent.getName());
		this.endEvent = endEvent;
	}
	
	public void adicionaElemento(ExclusiveGateway exclusiveGateway) {
		lista.add(exclusiveGateway.getName());
		
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
		
		if(resposta == false) {
			connector.containsKey(string);
			if(connector.get(string)[1].equals(endEvent.getName())) {
				return respPergunta;
			}else {
				return connector.get(string)[1];
			}
		}else {
			connector.containsKey(string);
			if(connector.get(string)[0].equals(endEvent.getName())) {
				return respPergunta;
			}else {
				return connector.get(string)[0];
			}
		}
	}

//------------------------------>>> FORMULARIO <<<<--------------------------------
	
	public void campoFormulario(String key, String[] opcoes) {
		listaDeOpcoes = opcoes;
		valores.put(key, opcoes);
	}

	public boolean preencheFormulario(String key, String respPergunta) {
		this.respPergunta = respPergunta;
		if(respPergunta == valores.get(key)[0]){
			return resposta = true;	
		}
		return resposta = false;
	}
	
//------------------------------>>> NOME FLUXO <<<----------------------------------
	
	public String nomeDoFluxo(String nomeFluxo) {
		this.nomeFluxo = nomeFluxo;
		return nomeFluxo;	
	}

	
	
//------------------------------>>> LE/SALVA FLUXO <<<----------------------------------- 	
	
	public void ler(Fluxo flux) throws IOException {
		p.ler(flux);
	}
	
	
	public void save(Fluxo flux) throws IOException {
		p.save(flux);
	}

	public void lerInicial(Fluxo flux) throws IOException {
		p.ler2(flux);
	}
	

	
	
}