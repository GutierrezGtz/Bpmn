package tdd;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import bpmn.BPMNElemento;
import bpmn.EndEvent;
import bpmn.ExclusiveGateway;
import bpmn.Fluxo;
import bpmn.HumanTask;
import bpmn.StartEvent;



public class Persistir_Test {

	@Test
	public void primeira_conexao_save() throws Exception{
	
		BPMNElemento elemento = new BPMNElemento();
		
		
		elemento.adicionaElemento(new StartEvent("inicio"));
		elemento.adicionaElemento(new HumanTask("Responder questao"));
		elemento.adicionaElemento(new HumanTask("Responder questao2"));
		elemento.adicionaElemento(new HumanTask("Responder questao3"));
		elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
		elemento.adicionaElemento(new EndEvent("fim"));
		elemento.connect("inicio",new String[] {"Responder questao"});
		elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" });
		elemento.connect("Desvio Exclusivo",new String[] {"Responder questao2", "Responder questao3" });
		elemento.connect("Responder questao2",new String[] {"fim"});
		elemento.connect("Responder questao3",new String[] {"fim"});
		
		
		Fluxo fluxo = new Fluxo(elemento.nomeDoFluxo("Fluxo Teste"), elemento.retornaSE(), elemento.retornaHT(), elemento.retornaEG(), elemento.retornaEE()) ;
		elemento.save(fluxo);
		Assert.assertEquals(Arrays.asList("fim"), elemento.retornaEE());
		
		
		
	}
	

}
