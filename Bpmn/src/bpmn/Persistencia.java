package bpmn;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Persistencia {
	
	public void save(String nome, HashMap<String, String[]> connector, HashMap<String, String[]> valores, ArrayList<Object> lista, ArrayList<String> elementosSE,  ArrayList<String> elementosHT,  ArrayList<String> elementosEG,  ArrayList<String> elementosEE ) throws IOException {
		
		String caminho = "C:\\Users\\matheus.villegas\\Downloads\\eclipse\\listaDeFluxos.txt";
		FileWriter arq = new FileWriter(caminho);
	    PrintWriter gravarArq = new PrintWriter(arq);


	    
//    	b.connector;
//    	b.lista;
//    	b.valores;			    	
//    	b.elementosEE;
//     	b.elementosEG;
//    	b.elementosHT;
//    	b.elementosSE;
	    
//	    listaFluxos.add(nome);
//	    
	    
		gravarArq.printf(
				"%8d"
				+ " %7d"
				+ " %6d"
				+ " %5d"
				+ " %4d"
				+ " %3d"
				+ " %2d"
				+ " %d", nome, lista, connector, valores, elementosSE, elementosHT, elementosEG, elementosEE );
	    
		
		arq.close();
		System.out.print("\n Fluxo foi gravado com sucesso em \"listaDeFluxos.txt\".\n");
	    
	}

}
