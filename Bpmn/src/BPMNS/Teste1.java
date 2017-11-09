package BPMNS;

public class Teste1 {
	
	public static void main(String[] args) throws Exception {
		
		HumanTask humanTask = new HumanTask("aaa");
		EndEvent endEvent = new EndEvent("bbb"); 
		StartEvent startEvent = new StartEvent("ccc"); 
		BPMNElemento b = new BPMNElemento();
		
		b.adicionaElemento(endEvent);
		b.adicionaElemento(humanTask);
		b.adicionaElemento(startEvent);
		b.connect("aaa", "bbb");
		
		System.out.println(b.countElements());
		//System.out.println(b.getNextElement("aaa"));
		
		
		
		
		
	}
	
	
}
