package bpmn;

import java.util.ArrayList;
import java.util.HashMap;

public class Negocio {

	ArrayList<Object> lista = new ArrayList<>();
	HashMap<String, String[]> connector = new HashMap<>();
	
	public void adicionaElemento(StartEvent startEvent) {
		lista.add(startEvent);
		
	}

	public void adicionaElemento(HumanTask humanTask) {
		lista.add(humanTask);
		
	}

	public void adicionaElemento(ExclusiveGateway exclusiveGateway) {
		lista.add(exclusiveGateway);
		
	}

	public void adicionaElemento(EndEvent endEvent) {
		lista.add(endEvent);
		
	}

	public Object countElements() {
		return lista.size();
	}

public void connect(String string, String[] strings)throws Exception {
		
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

	
	
	
	
	
	
	
}
