package BPMn;

public class Aponta extends Elemento {

	private Elemento elemento;
	private Elemento aponta;
	
	Elemento apontando(){
		if(proximoElemento() == true) {
			aponta = elemento.getElemento();
		}
		return aponta;
	}

}

