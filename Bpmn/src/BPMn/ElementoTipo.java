package BPMn;

import org.dom4j.Element;
import org.w3c.dom.Element;

public class ElementoTipo {
	
	
	public static final String START_EVENT = "startEvent";
    public static final String END_EVENT = "endEvent";
    
    public static final String DESVIO = "desvioExclusivo";
    public static final String TAREFA_HUMANA = "tarefaHumana";
    
    public static final String FLUXO = "fluxoDados";
    
    
    //---------------------------------------------------------------------------
    
    public static boolean isFluxo(Element element) {
        if (ElementoTipo.FLUXO.equals(element.getName())) {
            return true;
        }
        return false;
    }
    
    
    
	
}
