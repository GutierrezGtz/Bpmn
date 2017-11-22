package BPMNS;

import java.util.Scanner;

public class Teste1 {
	
	private static boolean resposta;

	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		
		StartEvent startEvent = new StartEvent("Inicio"); 
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
		
		
		b.connect("aaa", new String[] {"bbb"});
		b.connect("bbb", new String[] {"ccc"});
		b.connect("ccc", new String[] {"bbb","ddd"});
		b.connect("bbbb", new String[] {"ddd"});
		System.out.println(b.getNextElement("aaa"));
		System.out.println(b.getNextElement("bbb"));
		
		
//		  System.out.println("Digite a Resposta: ");
//		  resposta = s.nextBoolean();
//		  System.out.println(b.getNextElement("ccc"));    

		
		
		
	}
	
	
}
