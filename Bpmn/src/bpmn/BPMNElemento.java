package bpmn;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class BPMNElemento {

	ArrayList<Object> lista = new ArrayList<>();
	
	HashMap<String, String[]> connector = new HashMap<>();
	HashMap<String, String[]> valores = new HashMap<>();
	
	ArrayList<Object> listaFluxos = new ArrayList<>();
	
	String[] listaDeOpçoes;
	private boolean resposta = true;

	private EndEvent endEvent;
	private String respPergunta;

	private String nome;
	
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
	
	public void campoFormulario(String key, String[] opçoes) {
		listaDeOpçoes = opçoes;
		valores.put(key, opçoes);
	}

	public boolean preencheFormulario(String key, String respPergunta) {
		this.respPergunta = respPergunta;
		if(respPergunta == valores.get(key)[0]){
			return resposta = true;	
		}
		return resposta = false;
	}
	
//------------------------------>>> NOME FLUXO <<<----------------------------------
	
	public String nomeDoFluxo(String nome) {
		this.nome = nome;
		return nome;	
	}
	
//------------------------------>>> CADASTRA FLUXO <<<----------------------------------- 	
	
	public void cadastraFluxo() throws IOException {
		FileWriter arq = new FileWriter("C:\\Users\\matheus.villegas\\Downloads\\eclipse\\listaDeFluxos.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
	    listaFluxos.add(nome);
	    
	    
		gravarArq.printf("%4d"
				+ " %3d"
				+ " %2d"
				+ " %d", nome, lista, connector, valores);
	    
		
		arq.close();
		System.out.print("\n Fluxo foi gravado com sucesso em \"listaDeFluxos.txt\".\n");
	    
	}
	
	
}