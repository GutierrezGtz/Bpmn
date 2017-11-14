package BPMNS;

public class Teste1 {
	
	public static void main(String[] args) throws Exception {
		
		
		StartEvent startEvent = new StartEvent("aaa"); 
		HumanTask humanTask = new HumanTask("bbb");
		HumanTask humanTask2 = new HumanTask("bbbb");
		ExclusiveGateway EG = new ExclusiveGateway("ccc");
		EndEvent endEvent = new EndEvent("ddd"); 
		
		BPMNElemento b = new BPMNElemento();
		
		
		
		b.adicionaElemento(endEvent);
		b.adicionaElemento(humanTask);
		b.adicionaElemento(startEvent);
		b.adicionaElemento(humanTask2);
		b.adicionaElemento(EG);
		
		
		b.connect("aaa", new String[] {"bbb"}, true);
		b.connect("bbb", new String[] {"ccc"}, true);
		b.connect("ccc", new String[] {"bbb","ddd"}, false);
		b.connect("bbbb", new String[] {"ddd"}, true);
		System.out.println(b.getNextElement("aaa"));
		System.out.println(b.getNextElement("bbb"));
		System.out.println(b.getNextElement("ccc"));
		System.out.println(b.getNextElement("bbbb"));
		
		
	}
	
	
}
