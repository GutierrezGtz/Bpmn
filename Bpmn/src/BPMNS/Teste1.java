package BPMNS;

import java.util.Scanner;

public class Teste1 {
	
	private static boolean resposta;
	private static String string;
	private static String nomeElemento;
	public static void main(String[] args) throws Exception {
		
		Scanner ler = new Scanner(System.in);
		BPMNElemento b = new BPMNElemento();
		
		
		System.out.println("Digite o Elemento: ");
		String elemento = ler.next(); 
		switch (elemento) {
         case "StartEvent":
        	 System.out.println("Digite o nome do Elemento: ");
        	 nomeElemento  = ler.next();
        	 b.adicionaElemento(new StartEvent(nomeElemento));
             break;
         case "HumanTask":
        	 System.out.println("Digite o nome do Elemento: ");
        	 nomeElemento  = ler.next();
        	 b.adicionaElemento(new HumanTask(nomeElemento));
             break;
         case "ExclusiveGateway":
        	 System.out.println("Digite o nome do Elemento: ");
        	 nomeElemento  = ler.next();
        	 b.adicionaElemento(new ExclusiveGateway(nomeElemento));
             break;
         case "EndEvent":
        	 System.out.println("Digite o nome do Elemento: ");
        	 nomeElemento  = ler.next();
        	 b.adicionaElemento(new EndEvent(nomeElemento));
             break;
         default:
              System.out.println("Este não é um Elemento válido!");
      }
 

//		string = ler.next();  
//		b.adicionaElemento(new StartEvent(string));
//		System.out.print(string);
		
		
//		//StartEvent startEvent = new StartEvent(string); 
//		HumanTask humanTask = new HumanTask("Solicita Refrigerante");
//		HumanTask humanTask2 = new HumanTask("Verifica Disponibilidade");
//		ExclusiveGateway EG = new ExclusiveGateway("Disponivel?");
//		HumanTask humanTask3 = new HumanTask("Verificar Dinheiro Disponivel");
//		ExclusiveGateway EG2 = new ExclusiveGateway("Dinheiro Disponivel?");
//		HumanTask humanTask4 = new HumanTask("Realizar Pagamento");
//		HumanTask humanTask5 = new HumanTask("Entrega Refrigerante");
//		EndEvent endEvent = new EndEvent("fim"); 
//		
//
//		b.adicionaElemento(endEvent);
//		b.adicionaElemento(humanTask);
//
//		b.adicionaElemento(humanTask2);
//		b.adicionaElemento(EG);
//		
//		
//		b.connect("aaa", new String[] {"bbb"});
//		b.connect("bbb", new String[] {"ccc"});
//		b.connect("ccc", new String[] {"bbb","ddd"});
//		b.connect("bbbb", new String[] {"ddd"});
//		System.out.println(b.getNextElement("aaa"));
//		System.out.println(b.getNextElement("bbb"));
//		
		
//		  System.out.println("Digite a Resposta: ");
//		  resposta = s.nextBoolean();
//		  System.out.println(b.getNextElement("ccc"));    

		
		
		
	}
	
	
}
