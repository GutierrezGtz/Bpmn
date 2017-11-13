package BPMNS;

import java.util.ArrayList;
import java.util.HashMap;


public class BPMNElemento {

	ArrayList<Object> lista = new ArrayList<>();
	
	HashMap<String, String[]> connector = new HashMap<>();
	
	
	
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
	
	

	public Object countElements() {

		return lista.size();
	}
	

	public void connect(String string, String[] strings, boolean resposta )throws Exception {
		int verificado = 0;
		if(!lista.contains(string)) {
			throw new IllegalArgumentException("Elemento Inexistente");
		}

		for(int i = 0; i < strings.length; i++) {
			if(lista.contains(strings[i])) {
				verificado += 1;
			}  
		}
			if(verificado == strings.length) {//quer dizer que os elementos esxistem fluxo continua
				if(resposta == true) {
					strings[1]=null;
					strings[2]=null;
					connector.put(string, strings);
				}else if(resposta == false) {
					strings[0]=null;
					strings[2]=null;
					connector.put(string, strings);
				}else {
					strings[0]=null;
					strings[1]=null;
					connector.put(string, strings);
				}
			}else {
				throw new IllegalArgumentException("Elemento Inexistente");
			}
		
	}
		
	public Object getNextElement(String string) {
		connector.containsKey(string);
		return connector.get(string);
	}

	
}