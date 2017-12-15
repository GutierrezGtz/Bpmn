package tdd;

import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

import bpmn.BPMNElemento;
import bpmn.EndEvent;
import bpmn.ExclusiveGateway;
import bpmn.HumanTask;
import bpmn.Negocio;
import bpmn.StartEvent;

public class NegocioTest {
	
	Scanner s = new Scanner(System.in);
	
	@Test
	public void adicionaElemento_happy_SE_HT_EG_EE(){
		Negocio negocio = new Negocio();
		negocio.adicionaElemento(new StartEvent("inicio"));
		negocio.adicionaElemento(new HumanTask("Responder questao"));
		negocio.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
		negocio.adicionaElemento(new EndEvent("fim"));
		Assert.assertEquals(4,negocio.countElements());
	}
	
	@Test
	public void connect_happy_SE_HT_EE() throws Exception {
		Negocio negocio = new Negocio();
		negocio.adicionaElemento(new StartEvent("inicio"));
		negocio.adicionaElemento(new HumanTask("Responder questao"));
		negocio.adicionaElemento(new EndEvent("fim"));
		negocio.connect("inicio", new String[] {"Responder questao"});
	//	negocio.connect("Responder questao",new String[] {"fim"});
//		Assert.assertEquals("Responder questao", negocio.getNextElement("inicio"));
//		Assert.assertEquals("fim", negocio.getNextElement("Responder questao"));
	}
	
	
	
	
	
	
	
}
	
	
	
	
	

