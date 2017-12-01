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
		String nomeFluxo = ler.nextLine();
		

		while(true) {
			System.out.println("\nBPM(Matheus)\n");
			System.out.println(nomeFluxo);			
			System.out.println("Escolha uma das seguintes opções:\n\n"
	                +" 1 - Adicionar Elementos\n"
	                +" 2 - Conectar Elementos\n"
	                +" 3 - START FLUXO\n"
	                +" 4 - Sair\n"
					);
			int menu = ler.nextInt();
			switch (menu) { 
			case 1://------------------>>>ADD ELEMENTOS<<<---------------------
					System.out.println("\n Escolha uma das seguintes opções:\n\n"
			                +" 1 - StartEvent\n"
			                +" 2 - HumanTask\n"
			                +" 3 - ExclusiveGateway\n"
			                +" 4 - EndEvent\n");
					int elemento = ler.nextInt(); 
				
				switch (elemento) {
				     case 1://----- SE ------
				    	 System.out.println("Digite o nome do Elemento: ");
				    	 nomeElemento  = ler.nextLine();
				    	 b.adicionaElemento(new StartEvent(nomeElemento));
				    	 elementosSE.add(nomeElemento);
				         break;
				         
				     case 2://----- HT ------
				    	 System.out.println("Digite o nome do Elemento: ");
				    	 nomeElemento  = ler.nextLine();
				    	 b.adicionaElemento(new HumanTask(nomeElemento));
				    	 System.out.println("FORMULARIO ");
				    	 	System.out.println("Digite o numero de campos: ");
				    	 	int rec = ler.nextInt();
				    	 	op = new String[rec];
				    	 	for(int i = 0; i < rec; i++) {
				    	 		System.out.println("Digite o nome dos campos: ");
					    	 	String rec2 = ler.nextLine();
				    	 		op[i] = rec2;//aqui
				    	 	b.campoFormulario(nomeElemento, op);
				    	 	}
				    	 elementosHT.add(nomeElemento);
				         break;
				         
				     case 3://----- EG ------
				    	 System.out.println("Digite o nome do Elemento: ");
				    	 nomeElemento  = ler.nextLine();
				    	 b.adicionaElemento(new ExclusiveGateway(nomeElemento));
				    	 elementosEG.add(nomeElemento);
				         break;
				         
				     case 4://----- EE ------
				    	 System.out.println("Digite o nome do Elemento: ");
				    	 nomeElemento  = ler.nextLine();
				    	 b.adicionaElemento(new EndEvent(nomeElemento));
				    	 elementosEE.add(nomeElemento);
				         break;
				         
				     default:
				          System.out.println("Este não é um Elemento válido!");
					}
		         break;
		         
		     case 2://--------------->>>CONECTAR ELEMENTOS<<<------------------**(fazer menu para conectar elementos)
//		    	String[] listaSE = elementosSE.toArray(new String[elementosSE.size()]); 
//		    	String[] listaHT = elementosHT.toArray(new String[elementosHT.size()]); 
//		    	String[] listaEG = elementosEG.toArray(new String[elementosEG.size()]); 
//		    	String[] listaEE = elementosEE.toArray(new String[elementosEE.size()]); 
//		    	String[][] listaAll = new String[][] {listaSE, listaHT, listaEG, listaEE};
//		    	 
//    	 		System.out.println("Digite o numero do tipo de Elemento Key: ");//colocar menu
//		 		int key = ler.nextInt() ; 
//		 		if(key == 1 ) {
//		 			for(int i = 0; i < listaSE.length; i++) {
//		 				System.out.println((i+1)+" -> "+listaSE[i]);
//		 			}
//		 		}else if(key == 2) {
//		 			for(int i = 0; i < listaHT.length; i++) {
//		 				System.out.println((i+1)+" -> "+listaHT[i]);
//		 			}
//		 		}else if(key == 3) {
//		 			for(int i = 0; i < listaEG.length; i++) {
//		 				System.out.println((i+1)+" -> "+listaEG[i]);
//		 			}
//		 		}else if(key == 4) {
//		 			for(int i = 0; i < listaEE.length; i++) {
//		 				System.out.println((i+1)+" -> "+listaEE[i]);
//		 			}
//		 		} 		
//		 		System.out.println("Digite o numero do nome da Key: ");
//		 		int key2 = ler.nextInt();
//		 		
//		 		//---
//		 		
//		 		System.out.println("Digite o Numero de Elementos Ligados: ");
//		 		int numerosElementosLigados = ler.nextInt();
//		 		String[] strings = new String[numerosElementosLigados];
//		 		for(int i = 0; i < numerosElementosLigados; i++) {
//		 			System.out.println("Digite o numero do tipo de Elemento: ");
//		 			int newElemento = ler.nextInt();
//		 			for(int j = 0; j < listaAll[newElemento].length; j++ ) {
//						System.out.println(j +"-> "+ listaAll[newElemento][j]);
//						
//		 			}	
//	 			System.out.println("Digite o numero do nome do Elemento ");
//	 			int newElemento2 = ler.nextInt();	
//	 			strings[i] = listaAll[newElemento][newElemento2];
//	 			
//		 		}
//		 		b.connect(listaAll[key][key2], strings);	

		    	 
		    	 System.out.println("Digite o nome do Elemento Key: " );
		    	 String key = ler.nextLine();
		    	 System.out.println("Digite a quantidade de elementos conectados: " );
		    	 int numeroElementos = ler.nextInt();
		    	 String[] strings = new String[numeroElementos];
		    	 for(int i = 0; i < numeroElementos; i++) {
		    		 System.out.println("Digite o nome do Elemento: ");
		    		 strings[i] =  ler.next();
		    	 }
		    	 b.connect(key, strings);
		    	 
		    	 
		         break;
		         
		     case 3://--------------------->>>START FLUXO<<<--------------------------
		    	 	System.out.println("-------------Inicio Do Fluxo!-----------------");	
		    	 	System.out.println("Defina Elemento de Inicio: ");
		    	 	String inicioElement = ler.nextLine();
		    	 	String elementoPos = b.getNextElement(inicioElement);
	    	 		for(int i = 0; i < elementosHT.size(); i++) {
		    	 		if(elementosHT.contains(elementoPos)) {
		    	 			System.out.println("Preencha os campos: ");
		    	 			for(int j = 0; j < op.length; j++ ) {
		    	 				System.out.println(op[j] +":");
		    	 				String respFormulario = ler.next();
		    	 				b.preencheFormulario(elementoPos , respFormulario);
		    	 			}
		    	 		} 
		    	 		elementoPos = b.getNextElement(elementoPos);
	    	 		}
	    	 		System.out.println(elementoPos);
	    	 		
		         break;
		         
		     case 4://------->>>SAIR<<<--------
		    	 //precisa de saidas para voltar no menu!
		    	 
		    	 
		    	 	System.exit(0);
		         break;
		    
		     default:
		          	System.out.println(" Opção inexistente! Tente novamente.\n\n");
			}
			System.out.println(
					"SE: "+elementosSE
					+"  HT: "+elementosHT
					+"  EG: "+elementosEG
					+"  EE: "+elementosEE);

		}
	}
}
