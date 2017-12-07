package bpmn;

import java.util.Scanner;

public class Main {
	
	
	
	
	
	private static String[] op;
	
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		BPMNElemento b = new BPMNElemento();

		//---------------------------------------------------------------------
//		System.out.println("Nome Do Fluxo?");
//		String nome = ler.next();
//		b.nomeDoFluxo(nome);
		

		while(true) {
			System.out.println("\nBPM(Matheus)\n");
			//System.out.println(nome);			
			System.out.println("Escolha uma das seguintes opcoes:\n\n"
				                +" 1 - CADASTRO\n"
				                +" 2 - START FLUXO\n"
				                +" 3 - Mostrar Fluxo\n"
				                +" 4 - Sair\n"
								);
			int menu = ler.nextInt();
			
			switch (menu) { 
			
			
			
			case 1://----------------->>>CADASTRO<<<-----------------------------------
				boolean continuar = true;
				while(continuar) {
				System.out.println(" 1 - Adicionar Elementos\n"
							+ " 2 - Conectar Elementos\n"
							+ " 3 - Salvar Fluxo\n"
							+ " 4 - Voltar Para Menu\n"
							);
					int menuCadastro = ler.nextInt();
					
					switch(menuCadastro) {
						case 1://--------------->>>Adicionar Elementos<<<---------------------
							System.out.println("\n Escolha uma das seguintes opcoes:\n\n"
					                +" 1 - StartEvent\n"
					                +" 2 - HumanTask\n"
					                +" 3 - ExclusiveGateway\n"
					                +" 4 - EndEvent\n");
							int elemento = ler.nextInt(); 
						
							switch (elemento) {
							     case 1://----- SE ------
							    	 System.out.println("Digite o nome do Elemento: ");
							    	 b.nomeElemento  = ler.next();
							    	 b.adicionaElemento(new StartEvent(b.nomeElemento));
							    	 b.elementosSE.add(b.nomeElemento);
							         break;
							         
							     case 2://----- HT ------
							    	 System.out.println("Digite o nome do Elemento: ");
							    	 b.nomeElemento  = ler.next();
							    	 b.adicionaElemento(new HumanTask(b.nomeElemento));
							    	 System.out.println("FORMULARIO ");
							    	 	System.out.println("Digite o numero de campos: ");
							    	 	int rec = ler.nextInt();
							    	 	op = new String[rec];
							    	 	for(int i = 0; i < rec; i++) {
							    	 		System.out.println("Digite o nome do campo: ");
								    	 	String rec2 = ler.next();
							    	 		op[i] = rec2;//aqui nome do campo + o tipo do campo(case 1 int case 2 texto case 3 lista)
							    	 	b.campoFormulario(b.nomeElemento, op);
							    	 	}
							    	 b.elementosHT.add(b.nomeElemento);
							         break;
							         
							     case 3://----- EG ------
							    	 System.out.println("Digite o nome do Elemento: ");
							    	 b.nomeElemento  = ler.next();
							    	 b.adicionaElemento(new ExclusiveGateway(b.nomeElemento));
							    	 b.elementosEG.add(b.nomeElemento);
							         break;
							         
							     case 4://----- EE ------
							    	 System.out.println("Digite o nome do Elemento: ");
							    	 b.nomeElemento  = ler.next();
							    	 b.adicionaElemento(new EndEvent(b.nomeElemento));
							    	 b.elementosEE.add(b.nomeElemento);
							         break;
							         
							     default:
							          System.out.println("Este nao e um Elemento válido!");
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
					         
					         
					    case 3://------------------>>>Salva Fluxo<<<----------------------
					    	boolean t = true;
					    	while(t) {
					    		System.out.println("Digite o Nome Do Fluxo: ");
					    		b.nomeFluxo = ler.next();
						    	if(!b.listaFluxos.contains(b.nomeFluxo)) {
						    		b.listaFluxos.add(b.nomeFluxo);
						    		Fluxo flux = new Fluxo(b.nomeFluxo);
						    		flux.DefinirNome(b.nomeFluxo);
						    		b.save(flux);
						    		t = false;
						    		
						    		
						    	}else {
						    		System.out.println("Ja existe um fluxo com este Nome!");
						    	}
					    	}
					    	
					    	
					    	
					    	
//					    	b.connector;
//					    	b.lista;
//					    	b.valores;			    	
//					    	b.elementosEE;
//					     	b.elementosEG;
//					    	b.elementosHT;
//					    	b.elementosSE;
					    	

					         break;
					         
					    case 4://---------------->>>Volta Menu Principal<<<---------------
					    	 continuar = false;
					         break;
					         
					    default:
				          	 System.out.println("\n"
				          			+ "\n Opcao inexistente! Tente novamente.\n\n");
							}
					System.out.println(
							"SE: "+b.elementosSE
							+"  HT: "+b.elementosHT
							+"  EG: "+b.elementosEG
							+"  EE: "+b.elementosEE);
				}
					break;
				
		    case 2://--------------------->>>START FLUXO<<<--------------------------
		    	 	System.out.println("-------------Inicio Do Fluxo!-----------------");	
		    	 	System.out.println("Defina Elemento de Inicio: ");
		    	 	String inicioElement = ler.next();
		    	 	String elementoPos = b.getNextElement(inicioElement);
	    	 		for(int i = 0; i < b.elementosHT.size(); i++) {//verificar##
		    	 		if(b.elementosHT.contains(elementoPos)) {
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
		         
		    case 3://-----------------------LISTAR FLUXOS-----------------------------------
		    	 
		    	System.out.println("Seu Fluxo: ");
		    	for(int i = 0; i <b.elementosSE.size(); i++ ) {
		    		System.out.print(b.elementosSE.get(i));
		    		System.out.println("---->" + b.connector.get(b.elementosSE.get(i))[0]);
		    		for(int j = 1; j < b.connector.get(b.elementosSE.get(i)).length; j++ ) {
			    			if(b.connector.get(b.elementosSE.get(i)).length > 1) {
			    				String[] pos = b.connector.get(b.elementosSE.get(i));
			    				System.out.println(" ---->" + (pos)[j]);
			    				for(int k = 0; k <  b.connector.get(pos[j]).length; k++) {		
			    				}
			    			}	
		    		}
		    		
		    	}
		         break;
		     
			case 4://------->>>SAIR<<<--------
		    	 	System.exit(0);
		         break;
		         
		     default:
		          	System.out.println("\n"
		          			+ "\n Opcao inexistente! Tente novamente.\n\n");
			}
			System.out.println(
					"SE: "+b.elementosSE
					+"  HT: "+b.elementosHT
					+"  EG: "+b.elementosEG
					+"  EE: "+b.elementosEE);
		}
	}
}
