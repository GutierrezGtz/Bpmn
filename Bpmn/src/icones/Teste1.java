package icones;

public class Teste1 {

	
	public static void main(String[] args) {
		
		HumanTask humanTask = new HumanTask(); 
		EventoInicial eI = new EventoInicial();
		DesvioCondicionalExclusivo DCE = new DesvioCondicionalExclusivo();
		
		
		Elemento proximoElemento = eI.ProximoElemento(humanTask);
		System.out.println(proximoElemento);
		
		Elemento proximoElemento2 = humanTask.ProximoElemento(DCE);
		System.out.println(proximoElemento2);
		
		
		Elemento testandoElemento = DCE.TestandoElemento(humanTask);
		System.out.println(testandoElemento);
		
	
	}
	
}
