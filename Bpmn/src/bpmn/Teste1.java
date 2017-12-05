package bpmn;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste1 {
	
	private static String nomeElemento;
	static ArrayList<String> elementosSE = new ArrayList<String>();
	static ArrayList<String> elementosHT = new ArrayList<String>();
	static ArrayList<String> elementosEG = new ArrayList<String>();
	static ArrayList<String> elementosEE = new ArrayList<String>();
	private static String[] op;
	
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		BPMNElemento b = new BPMNElemento();

		//---------------------------------------------------------------------
		System.out.println("Nome Do Fluxo?");
		String nome = ler.next();
		b.nomeDoFluxo(nome);
		

		while(true) {
			System.out.println("\nBPM(Matheus)\n");
			System.out.println(nome);			
			System.out.println("Escolha uma das seguintes opções:\n\n"
	                +" 1 - CADASTRO\n"
	                +" 2 - START FLUXO\n"
	                +" 3 - Mostrar Fluxo\n"
	                +" 4 - Sair\n"
					);
			int menu = ler.nextInt();
			switch (menu) { 
			case 1://----------------->>>CADASTRO<<<-----------------------------------
				//System.out.println("Nome Do Fluxo?");
				//String nome = ler.next();
				//b.nomeDoFluxo(nome);
				System.out.println(" 1 - Adicionar Elementos\n"
							+ " 2 - Conectar Elementos\n"
							);
					int menuCadastro = ler.nextInt();
					
					switch(menuCadastro) {
						case 1://------------------>>>add elementos<<<---------------------
							System.out.println("\n Escolha uma das seguintes opções:\n\n"
					                +" 1 - StartEvent\n"
					                +" 2 - HumanTask\n"
					                +" 3 - ExclusiveGateway\n"
					                +" 4 - EndEvent\n");
							int elemento = ler.nextInt(); 
						
						switch (elemento) {
						     case 1://----- SE ------
						    	 System.out.println("Digite o nome do Elemento: ");
						    	 nomeElemento  = ler.next();
						    	 b.adicionaElemento(new StartEvent(nomeElemento));
						    	 elementosSE.add(nomeElemento);
						         break;
						         
						     case 2://----- HT ------
						    	 System.out.println("Digite o nome do Elemento: ");
						    	 nomeElemento  = ler.next();
						    	 b.adicionaElemento(new HumanTask(nomeElemento));
						    	 System.out.println("FORMULARIO ");
						    	 	System.out.println("Digite o numero de campos: ");
						    	 	int rec = ler.nextInt();
						    	 	op = new String[rec];
						    	 	for(int i = 0; i < rec; i++) {
						    	 		System.out.println("Digite o nome do campo: ");
							    	 	String rec2 = ler.next();
						    	 		op[i] = rec2;//aqui
						    	 	b.campoFormulario(nomeElemento, op);
						    	 	}
						    	 elementosHT.add(nomeElemento);
						         break;
						         
						     case 3://----- EG ------
						    	 System.out.println("Digite o nome do Elemento: ");
						    	 nomeElemento  = ler.next();
						    	 b.adicionaElemento(new ExclusiveGateway(nomeElemento));
						    	 elementosEG.add(nomeElemento);
						         break;
						         
						     case 4://----- EE ------
						    	 System.out.println("Digite o nome do Elemento: ");
						    	 nomeElemento  = ler.next();
						    	 b.adicionaElemento(new EndEvent(nomeElemento));
						    	 elementosEE.add(nomeElemento);
						         break;
						         
						     default:
						          System.out.println("Este não é um Elemento válido!");
							}
				         break;
				         
					     case 2://--------------->>>conectar elementos<<<------------------ 	 
					    	 System.out.println("Digite o nome do Elemento Key: " );
					    	 String key = ler.next();
					    	 System.out.println("Digite a quantidade de elementos conectados: " );
					    	 int numeroElementos = ler.nextInt();
					    	 String[] strings = new String[numeroElementos];
					    	 for(int i = 0; i < numeroElementos; i++) {
					    		 System.out.println("Digite o nome do Elemento: ");
					    		 strings[i] =  ler.next();
					    	 }
					    	 b.connect(key, strings);
					    	 
					    	 
					         break;
							}
			         
					break;
				
		     case 2://--------------------->>>START FLUXO<<<--------------------------
		    	 	System.out.println("-------------Inicio Do Fluxo!-----------------");	
		    	 	System.out.println("Defina Elemento de Inicio: ");
		    	 	String inicioElement = ler.next();
		    	 	String elementoPos = b.getNextElement(inicioElement);
	    	 		for(int i = 0; i < elementosHT.size(); i++) {//verificar##
		    	 		if(elementosHT.contains(elementoPos)) {
		    	 			System.out.println("Preencha os campos: ");
		    	 			for(int j = 0; j < op.length; j++ ) {
		    	 				System.out.println(op[j] +":");
		    	 				
		    	 			}
		    	 			String respFormulario = ler.next();
	    	 				b.preencheFormulario(elementoPos , respFormulario);
		    	 		} 
		    	 		elementoPos = b.getNextElement(elementoPos);
	    	 		}
	    	 		System.out.println(elementoPos);
	    	 		
		         break;
		         
		     case 3:
		    	 
		    	System.out.println("Seu Fluxo: ");
		    	for(int i = 0; i <elementosSE.size(); i++ ) {
		    		System.out.print(elementosSE.get(i));
		    		System.out.println("---->" + b.connector.get(elementosSE.get(i))[0]);
		    		for(int j = 1; j < b.connector.get(elementosSE.get(i)).length; j++ ) {
			    			if(b.connector.get(elementosSE.get(i)).length > 1) {
			    				String[] pos = b.connector.get(elementosSE.get(i));
			    				System.out.println(" ---->" + (pos)[j]);
			    				for(int k = 0; k <  b.connector.get(pos[j]).length; k++) {
			    					
			    					
			    				}
			    			}
			    			
		    		}
		    		
		    	}
		    	 
		         break;
		     
			case 4://------->>>SAIR<<<--------
		    	 //precisa de saidas para voltar no menu!
		    	 
		    	 	System.exit(0);
		         break;
		     default:
		          	System.out.println("\n"
		          			+ "\n Opção inexistente! Tente novamente.\n\n");
			}
			System.out.println(
					"SE: "+elementosSE
					+"  HT: "+elementosHT
					+"  EG: "+elementosEG
					+"  EE: "+elementosEE);

		}
	}
}
