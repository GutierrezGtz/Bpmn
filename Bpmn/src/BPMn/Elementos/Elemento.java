package BPMn.Elementos;

public class Elemento{

	private String nome;
	private Elemento elemento;
	private boolean requisitos;
	
//------------------------------>>>GET/SETTERS<<<------------------------------------------------------------
	
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
    
    public boolean isRequisitos() {
    	return requisitos;
	}

	public void setRequisitos(boolean requisitos) {
		this.requisitos = requisitos;
	}
    
  //------------------------------>>>METODOS<<<------------------------------------------------------------

    boolean atributosPassaram(){

    		if(requisitos == true) {
				return true;
			}else {
				return false;
			}					
	}
    
	boolean proximoElemento() {
		
		if(atributosPassaram() == true) {
			setElemento(elemento);
			return true;
		}else{
			return false;
		}
	}

	
	
   
	/*public Elemento changeType(Elemento trocaElemento) {
		return trocaElemento;
	}*/
    
}

