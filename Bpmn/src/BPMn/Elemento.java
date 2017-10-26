package BPMn;

public class Elemento extends FluxoDados{

	public String nome;
	protected Elemento elemento;
	
	
	public Elemento fluxoEsta(Elemento novoElemento) {
		return elemento = novoElemento;
	}
	
	
	
	public void remove() {
		if(marcado() == true) {
			
		}
	}
	private boolean marcado() {
		return false;
	}
	
	
	
}

