package BPMNS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class BPMNElemento {

	ArrayList<Object> lista = new ArrayList<>();
	
	HashMap<String, String[]> connector = new HashMap<>();
	HashMap<String, String[]> valores = new HashMap<>();

	String[] listaDeOpçoes;
	Scanner s = new Scanner(System.in);
	private boolean resposta = true;
	
//------------------------------>>>METODOS ADICIONA<<<-----------------------------	

	public void adicionaElemento(HumanTask humanTask) {
		lista.add(humanTask.getName());	
	}
	
	public void adicionaElemento(StartEvent startEvent) {
		lista.add(startEvent.getName());
	}

	public void adicionaElemento(EndEvent endEvent) {
		lista.add(endEvent.getName());
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
	
	public Object getNextElement(String string) {
		
		if(resposta == false) {
			connector.containsKey(string);
			return connector.get(string)[1];
		}else {
			connector.containsKey(string);
			return connector.get(string)[0];
		}
	}
	
//------------------------------>>> FORMULARIO <<<<--------------------------------
	
	public void campoFormulario(String key, String[] opçoes) {
		listaDeOpçoes = opçoes;
		valores.put(key, opçoes);
	}

	public boolean preencheFormulario(String key, String respPergunta) {
		if(respPergunta == valores.get(key)[0]){//posso fazer o metodo recebendo um for int i que retorna o valores.get(key)[i]
			return resposta = true;	
		}
		return resposta = false;
	}
//------------------------------>>> NOME FLUXO <<<----------------------------------
	
	public String nomeDoFluxo(String nome) {
		return nome;
		
	}
}