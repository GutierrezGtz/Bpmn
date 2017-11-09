package BPMNS;

import java.util.ArrayList;
import java.util.HashMap;



public class BPMNElemento {

	ArrayList<Object> lista = new ArrayList<>();
	HashMap<String, String> connector = new HashMap<>();
	HashMap<String, String[]> connector2 = new HashMap<>();
	
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
	
	public void connect(String string, String string2)throws Exception {
		
			if(lista.contains(string2) && lista.contains(string)) {
				connector.put(string, string2);
			}else {
				throw new IllegalArgumentException("Elemento Inexistente");
			}
	}
	public void connectEG(String string, String[] string2)throws Exception {
		
		if(lista.contains(string2) && lista.contains(string)) {
			connector2.put(string, string2);
		}else {
			throw new IllegalArgumentException("Elemento Inexistente");
		}
}	
		
	public Object getNextElement(String string) {
		connector.containsKey(string);
		return connector.get(string);
	}

	

	
}