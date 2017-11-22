package BPMNS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BPMNElemento {

	ArrayList<Object> lista = new ArrayList<>();
	
	HashMap<String, String> connector = new HashMap<>();
	HashMap<String, String[]> valores = new HashMap<>();
//	HashMap<String, Integer> mapInt = new HashMap<>();
//	HashMap<String, Integer> mapBool= new HashMap<>();
//	HashMap<String, Integer> mapString = new HashMap<>();
//	
//	private Integer varInt;
//
//	private Integer varBool;
//
//	private Integer varString;

	String[] listaDeOpçoes;
	Scanner s = new Scanner(System.in);
	boolean resposta = true;
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
		
		int verificado = 0;
		
		if(!lista.contains(string)) {
			throw new IllegalArgumentException("Elemento Inexistente");
		}

		for(int i = 0; i < strings.length; i++) {
			if(lista.contains(strings[i])) {
				verificado += 1;
			}  
		}
		
		
		if(verificado == 1) {
			connector.put(string, strings[0]);
		}else if(verificado >= 2 && verificado == strings.length) {//quer dizer que os elementos existem fluxo continua
			if(resposta == true) {
				connector.put(string, strings[0]);
			}else if(resposta == false) {
				connector.put(string, strings[1]);
			}
		}else {
			throw new IllegalArgumentException("Elemento Inexistente");
		}
	}
	
	
//------------------------------>>>METODO NEXT's <<<-----------------------------	
	
	public Object getNextElement(String string) {
		connector.containsKey(string);
		return connector.get(string);
	}

	public void campoFormulario(String key, String[] opçoes) {
		listaDeOpçoes = opçoes;
		valores.put(key, opçoes);
	}

	public String preencheFormulario(String key, String respPergunta) {
		for(int i = 0; i < listaDeOpçoes.length; i++ ) {
			if(respPergunta == valores.get(key)[i]){
				resposta = true;
				return "Há Refri";
			}
		}
		resposta = false;
		return "não Há Refri";
		
		
		
	}

	

	

	
	
	
	
	
	
	
//	public String adicionaVariaveis(String[] variaveis) {
//		
//		for(int i=0; i<variaveis.length; i++) {
//			String variavel = variaveis[i];
//			String[] variaveisETipos = variavel.split("/|/\\s");
//			Arrays.toString(variaveisETipos);
//			
//			if(variaveisETipos[1] == "int") {
//				mapInt.put(variaveisETipos[0], varInt);
//				
//				
//			}else if(variaveisETipos[1] == "boolean") {
//				mapBool.put(variaveisETipos[0], varBool );
//				
//			}else if(variaveisETipos[1] == "String") {
//				mapString.put(variaveisETipos[0], varString);
//			}
//			
//			
//			
//			
//		}
//		return null;
//		
//		
//		
//		
//	}

	
}