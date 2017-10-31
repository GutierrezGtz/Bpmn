package BPMn;

import BPMn.Elementos.Elemento;

public class Aponta extends Elemento {

	private Elemento elemento;
	private Elemento aponta;
	
	Elemento apontando(){
		if(proximoElemento() == true) {
			aponta = elemento.setElemento(elemento);
		}
		return aponta;
	}

}

