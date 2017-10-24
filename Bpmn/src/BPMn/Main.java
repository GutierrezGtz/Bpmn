package BPMn;

import javax.swing.JFrame;

public class Main {

		public static void main(String[] args){
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	 
	            @Override
	            public void run(){
	            	
	            	MenuBpm.criaGUI();	
	                
	            }
	        });
	 
	    }
		

}
//Botao botoes = new Botao();
//botoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//botoes.setSize(350,70);
//botoes.setVisible(true);