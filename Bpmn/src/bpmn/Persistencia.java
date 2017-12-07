package bpmn;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


public class Persistencia {
	
	public void save(Object objeto, String caminho) {
		
			 
	           try {
	       		FileWriter arq = new FileWriter(caminho);
	    	    PrintWriter gravarArq = new PrintWriter(arq);
	 
	              // salva o objeto
	    	    gravarArq.write(objeto);
	 
	    	    gravarArq.close();
	           } catch (Exception exc) {
	             exc.printStackTrace();
	           }
	    }
	

	 
		
		
		
		
		
//	  FileOutputStream saveFile = new FileOutputStream(caminho);
//      ObjectOutputStream stream = new ObjectOutputStream(saveFile);
		
//		String caminho = "C:\\Users\\matheus.villegas\\Downloads\\eclipse\\listaDeFluxos.txt";
//		FileWriter arq = new FileWriter(caminho, true);
//	    PrintWriter gravarArq = new PrintWriter(arq);
//	   
//
//	    Fluxo f = new Fluxo();
//	    gravarArq.println(f);
//	    
//	   // gravarArq.write(f.ObterNome().toString());
//	    
//	 
//	    
////	    String nome, HashMap<String, String[]> connector, HashMap<String, String[]> valores, 
////		ArrayList<Object> lista, ArrayList<String> elementosSE,  ArrayList<String> elementosHT,
////		ArrayList<String> elementosEG,  ArrayList<String> elementosEE 
////    	b.connector;
////    	b.lista;
////    	b.valores;			    	
////    	b.elementosEE;
////     	b.elementosEG;
////    	b.elementosHT;
////    	b.elementosSE;   
////	    listaFluxos.add(nome);
//	    
////		gravarArq.printf(
//////				"%8d"
//////				+ " %7d"
//////				+ " %6d"
//////				+ " %5d"
//////				+ " %4d"
//////				+ " %3d"
//////				+ " %2d"
////				 " %d", flux);
////	    
//		gravarArq.flush();  
//		gravarArq.close();  
//		arq.close();
//		System.out.print("\n Fluxo foi gravado com sucesso em \"listaDeFluxos.txt\".\n");
//	    
//	}

}
