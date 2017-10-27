package BPMn;



public class Elemento{

	private String nome;
	private Elemento elemento;
	
	Elemento(String nome, Elemento elemento){
		this.elemento = elemento;
		this.nome = nome;
	}
	
	//------------------------------>>>METODOS<<<------------------------------------------------------------
	
	public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public String getNome() {
        if (nome == null) {

        	nome = "";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
    
}

