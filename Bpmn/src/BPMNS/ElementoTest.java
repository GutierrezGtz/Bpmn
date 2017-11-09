package BPMNS;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ElementoTest {

	
	
	@Test
	public void adicionaElemento_happy_SE_HT_EG_EE(){
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	Assert.assertEquals(4,elemento.countElements());
	}

	
	@Test
	public void connect_happy_SE_HT_EE() throws Exception {
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio","Responder questao");
	elemento.connect("Responder questao","fim");
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("fim", elemento.getNextElement("Responder questao"));
	}
	
	@Test
	public void connect_happy_SE_HT_EG_EE() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio","Responder questao");
	elemento.connect("Responder questao","Desvio Exclusivo");
	elemento.connect("Desvio Exclusivo","fim");
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	Assert.assertEquals("fim", elemento.getNextElement("Desvio Exclusivo"));
	}
	
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void connect_bad_SE_x() throws Exception {
		BPMNElemento elemento = new BPMNElemento();
		elemento.adicionaElemento(new StartEvent("inicio"));
		thrown.expectMessage("Elemento Inexistente");
		elemento.connect("inicio","x");
	}
	
	@Test
	public void connect_bad_x_SE() throws Exception {
		BPMNElemento elemento = new BPMNElemento();
		elemento.adicionaElemento(new StartEvent("inicio"));
		thrown.expectMessage("Elemento Inexistente");
		elemento.connect("x","inicio");
	}
	
	
	@Test
	public void connect_happy_EG() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio","Responder questao");
	elemento.connect("Responder questao","Desvio Exclusivo");
	elemento.connectEG("Desvio Exclusivo","fim");
	Assert.assertEquals("fim", elemento.getNextElement("Desvio Exclusivo"));
	
//	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
//	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
//	Assert.assertEquals("fim", elemento.getNextElement("Desvio Exclusivo"));
	}
	
	
	
	
}
	
	

