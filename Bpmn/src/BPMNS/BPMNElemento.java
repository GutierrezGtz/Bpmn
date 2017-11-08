package BPMNS;

import java.util.ArrayList;
import java.util.HashMap;



public class BPMNElemento {

	ArrayList<Object> lista = new ArrayList<>();
	HashMap<String, String> connector = new HashMap<>();
	
	public void adicionaElemento(HumanTask humanTask) {
		lista.add(humanTask.getName());
		
	}
	
	public void adicionaElemento(StartEvent startEvent) {
		lista.add(startEvent.getName());
	}

	public void adicionaElemento(EndEvent endEvent) {
		lista.add(endEvent.getName());
	}

	public Object countElements() {

		return lista.size();
	}
	
	public void connect(String string, String string2) {
		connector.put(string, string2);
		
	}
	
	public Object getNextElement(String string) throws Exception {
		if(string == null ) {
		connector.containsKey( string );
		return connector.get(string);
		}else {
			
			throw new NullPointerException("Elemento Inexistente");

		}
	}

	

	
}