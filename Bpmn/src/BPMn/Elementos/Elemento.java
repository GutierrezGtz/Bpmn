package BPMn.Elementos;

public class Elemento{

	private String nome;
	private Elemento elemento;
	
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
    
  //------------------------------>>>METODOS<<<------------------------------------------------------------
    
    boolean atingiuRequisitos() {
    	return true;// se requisitos forem atingidos
    }
	
    boolean atributosPassaram(){
			
			if(atingiuRequisitos() == true) {
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

