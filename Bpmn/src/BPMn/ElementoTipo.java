package BPMn;



public class ElementoTipo {
	
	
	public static final String START_EVENT = "startEvent";
    public static final String END_EVENT = "endEvent";
    
    public static final String DESVIO = "desvioExclusivo";
    public static final String TAREFA_HUMANA = "tarefaHumana";
    
    public static final String FLUXO = "fluxoDados";
    
    
    //---------------------------------------------------------------------------
    
    public static boolean isFluxo(Elemento elemento) {
        if (ElementoTipo.FLUXO.equals(elemento.getNome())) {
            return true;
        }
        return false;
    }
    
    
    
	
}
