package icones;

public class Teste1 {

	
	public static void main(String[] args) {
		
		HumanTask humanTask = new HumanTask(); 
		EventoInicial eI = new EventoInicial();
		
		Elemento proximoElemento = eI.proximoElemento(true, humanTask);
		System.out.println(proximoElemento);
	
	}
	
}
