package BPMNS;

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
		while(true) {
			System.out.println("\nBPM(Matheus)\n");
			System.out.println("Escolha uma das seguintes opções:\n\n"
	                +" 1 - Adicionar Elementos\n"
	                +" 2 - Conectar Elementos\n"
	                +" 3 - Criar Formulario\n"
	                +" 4 - START FLUXO\n"
	                +" 5 - Sair\n"
					);
			int menu = ler.nextInt();
			switch (menu) { 
			case 1://------------------>>>Adicionar Elementos<<<---------------------
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
				    	 		System.out.println("Digite o nome dos campos: ");
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
		         
		     case 2://--------------->>>Conectar Elementos<<<------------------**(fazer menu para conectar elementos)
			    	
		    	 
		    	String[] listaSE = elementosSE.toArray(new String[elementosSE.size()]); 
		    	String[] listaHT = elementosHT.toArray(new String[elementosHT.size()]); 
		    	String[] listaEG = elementosEG.toArray(new String[elementosEG.size()]); 
		    	String[] listaEE = elementosEE.toArray(new String[elementosEE.size()]); 
		    	Object[][] listaAll = new String[][] {listaSE, listaHT, listaEG, listaEE};
		    	 
    	 		System.out.println("Digite o numero do tipo de Elemento Key: ");
		 		int key = ler.nextInt(); 
		 		for(int n = 0; n < listaAll[key].length; n++ ) {
						System.out.println(n +"-> "+ listaAll[key][n]);
				}
		 		System.out.println("Digite o numero do nome da Key: ");
		 		int key2 = ler.nextInt();
		 		//---
		 		
		 		System.out.println("Digite o Numero de Elementos Ligados: ");
		 		int numerosElementosLigados = ler.nextInt();
		 		String[] strings = new String[numerosElementosLigados];
		 		
		 		for(int i = 0; i < numerosElementosLigados; i++) {
		 			System.out.println(listaAll[key]);
		 			System.out.println("Digite o numero do tipo de Elemento: ");
		 			int newElemento = ler.nextInt();
		 			for(int j = 0; j < listaAll[newElemento].length; j++ ) {
						System.out.println(j +"-> "+ listaAll[newElemento][j]);
						
		 			}	
		 			System.out.println("Digite o numero do nome do Elemento ");
		 			int newElemento2 = ler.nextInt();
		 			
		 			
		 			
	
	 					 			String str = ler.next();
	 					 			strings[i] = str;
	 					 			b.connect(listaAll[key][key2], strings);
	 					 		}
	 							

			 		}
			 		
			 		
			 		System.out.println("Digite o Numero de Elementos Ligados: ");
			 		int numerosElementosLigados = ler.nextInt(); 
			 		String[] strings = new String[numerosElementosLigados];
			 		for(int i = 0; i < numerosElementosLigados; i++) {
			 			System.out.println("Digite o nome do Elemento: ");
			 			String str = ler.next();
			 			strings[i] = str;
			 			b.connect(key, strings);
			 		}
		    	 
		         break;
		     case 3:
		    	 //nessecita implementar?
		         break;
		         
		     case 4://--------------------->>>START FLUXO<<<--------------------------
		    	 	System.out.println("-------------Inicio Do Fluxo!-----------------");	
		    	 	System.out.println("Defina Elemento de Inicio: ");
		    	 	String inicioElement = ler.next();
		    	 	String elementoPos = b.getNextElement(inicioElement);
	    	 		for(int i = 0; i < elementosHT.size(); i++) {
		    	 		if(elementosHT.contains(elementoPos)) {
		    	 			System.out.println("Preencha os campos: ");
		    	 			for(int j = 0; j < op.length; j++ ) {
		    	 				System.out.println(op[j] +":");
		    	 				String respFormulario = ler.next();
		    	 				b.preencheFormulario(elementoPos , respFormulario);
		    	 			}
		    	 			elementoPos = b.getNextElement(elementoPos);
		    	 		} 
		    	 		elementoPos = b.getNextElement(elementoPos);
	    	 		}
	    	 		
		    	 	System.out.println("--->");
	    	 		System.out.println("resposta");
		         break;
		         
		     case 5://------->>>Sair<<<--------
		    	 	System.exit(0);
		         break;
		     default:
		          	System.out.println(" Opção inexistente! Tente novamente.\n\n");
			}
			System.out.println(
					 "1-SE: "+elementosSE
					+" 2-HT: "+elementosHT
					+" 3-EG: "+elementosEG
					+" 4-EE: "+elementosEE);
		}
//------------------------------------------------------------------------
	}
}
