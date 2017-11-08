package BPMNS;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ElementoTest {

	
	
	@Test
	public void adicionaElemento_happy_SE_HT_EE(){
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new EndEvent("fim"));
	Assert.assertEquals(3,elemento.countElements());
	}

	

	@Test
	public void connect_happy_SE_HT_EE() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio","Responder questao");
	elemento.connect("Responder questao","fim");
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("fim", elemento.getNextElement("Responder questao"));
	}
	
	
	
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void connect_bad_SE_x() throws Exception {
		BPMNElemento elemento = new BPMNElemento();
		elemento.adicionaElemento(new StartEvent("inicio"));
		elemento.adicionaElemento(new HumanTask("Responder questao"));
		elemento.adicionaElemento(new EndEvent("fim"));
		elemento.connect("inicio","x");
		thrown.expectMessage("Elemento Inexistente");
		Assert.assertEquals("x", elemento.getNextElement("inicio"));
		
	}
	
	
}
	
	

