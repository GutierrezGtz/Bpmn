package bpmn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class Persistencia {

	private String[] linhas;
	Fluxo fluxo;
	
	public void save(Fluxo fluxo) {
        File dir = new File("C:\\Users\\Roberto\\Arquivos");
        String nomeArquivo = fluxo.getNome();
        
        File arq = new File(dir, nomeArquivo + ".txt");
        
        
        try {
            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(fluxo.getNome());
            printWriter.println(fluxo.getElementos_SE());
            printWriter.println(fluxo.getElementos_HT());
            printWriter.println(fluxo.getElementos_EG());
            printWriter.println(fluxo.getElementos_EE());
            printWriter.println(fluxo.getLista_());
            printWriter.println(fluxo.getKeyConnector());
            printWriter.println(fluxo.getValueConnector());
            
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void save2() {
		File dir = new File("C:\\Users\\Roberto\\Arquivos");
		File arq2 = new File (dir, "listaFluxos.txt");
		
		try {
            arq2.createNewFile();

            FileWriter fileWriter = new FileWriter(arq2, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(fluxo.getNome());
           
            
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
		
		
	public void ler(){
		File dir = new File("C:\\Users\\Roberto\\Arquivos");
		File arq = new File(dir, fluxo.getNome() + ".txt");//criar txt que guarda nome dos fluxos comparar caso passe segue se não execpetion
		
	    try {
	        FileReader fileReader = new FileReader(arq);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        String linha = "";
	        int i = 0;
	        while ( ( linha = bufferedReader.readLine() ) != null) {
	        	
	        	fluxo.trataLeitura(linha);
	        	
	        }
	        
	        
	        fileReader.close();
	        bufferedReader.close();
	        
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	}
	
	
//	static ArrayList<String> linhas;
//	
//	ArrayList<Object> linhas2 = new ArrayList<>();
//	
//	static void ler(Fluxo flux) {
//		File dir = new File("C:\\Users\\matheus.villegas\\Downloads\\eclipse");
//		File arq = new File(dir, flux.getVerificadorDeNome() + ".txt");
//

//
//
//	static void save(Fluxo flux) {
//        File dir = new File("C:\\Users\\matheus.villegas\\Downloads\\eclipse");
//        String nomeArquivo = flux.getNome();
//        
//        File arq = new File(dir, nomeArquivo + ".txt");
//       
//        try {
//            arq.createNewFile();
//
//            FileWriter fileWriter = new FileWriter(arq, false);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            printWriter.println(flux.getNome());
////            printWriter.println(flux.getElementos());
//
//            printWriter.flush();
//            printWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        File arq2 = new File(dir, "ListaDeFluxos.txt");
//	       
//        try {
//        	arq2.createNewFile();
//        	
//       		FileWriter fw = new FileWriter(arq2, true);
//			BufferedWriter conexao = new BufferedWriter(fw);
//			
//			conexao.write(flux.getNome());
//			conexao.newLine();
//			
//			conexao.close();
//       		
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//	public void ler2(Fluxo flux) {
//		File dir = new File("C:\\Users\\matheus.villegas\\Downloads\\eclipse");
//		File arq = new File(dir, "ListaDeFluxos.txt");
//		
//		 try {
//		        FileReader fileReader = new FileReader(arq);
//		        BufferedReader bufferedReader = new BufferedReader(fileReader);
//		        
//		        String linha2 = "";
//		        
//		        while ( ( linha2 = bufferedReader.readLine() ) != null) {
//		        	linhas2.add(linha2);
//		        }
//		        
//		        fileReader.close();
//		        bufferedReader.close();
//		        
//			} catch (IOException e) {
//		    	e.printStackTrace();
//		    }
//		}
//		
//		
	
	
	
	
	
	
	
