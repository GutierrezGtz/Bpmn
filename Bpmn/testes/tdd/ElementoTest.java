package tdd;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import bpmn.BPMNElemento;
import bpmn.EndEvent;
import bpmn.ExclusiveGateway;
import bpmn.Fluxo;
import bpmn.HumanTask;
import bpmn.StartEvent;


public class ElementoTest {

	private boolean resposta;
	Scanner s = new Scanner(System.in);
	
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
	elemento.connect("inicio",new String[] {"Responder questao"});
	elemento.connect("Responder questao",new String[] {"fim"});
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	
	}
	
	@Test
	public void connect_happy_SE_HT_EG_EEtest() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio",new String[] {"Responder questao"});
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" });
	elemento.connect("Desvio Exclusivo",new String[] {"fim"});
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	}
	
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	
	@Test 
	public void connect_bad_SE_x() throws Exception {
		BPMNElemento elemento = new BPMNElemento();
		elemento.adicionaElemento(new StartEvent("inicio"));
	//	thrown.expectMessage("Elemento Inexistente");
		thrown.expect(IllegalArgumentException.class);//modos diferentes de fazer a mesma exception
		elemento.connect("inicio",new String[] {"x"});	
	}
	
	
	@Test
	public void connect_bad_x_SE() throws Exception {
		BPMNElemento elemento = new BPMNElemento();
		elemento.adicionaElemento(new StartEvent("inicio"));
		thrown.expectMessage("Elemento Inexistente");
		elemento.connect("x",new String[] {"inicio"});
	}
	
	
	@Test
	public void connect_happy_SE_HT_EG_2elements_true_EE() throws Exception{
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
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	Assert.assertEquals("Responder questao2", elemento.getNextElement("Desvio Exclusivo"));
	}
	
	
	@Test
	public void connect_happy_SE_HT_EG_3elements_true_EE() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new HumanTask("Responder questao2"));
	elemento.adicionaElemento(new HumanTask("Responder questao3"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio",new String[] {"Responder questao"});
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" });
	elemento.connect("Desvio Exclusivo",new String[] {"fim", "Responder questao2", "Responder questao3" });
	elemento.connect("Responder questao2",new String[] {"fim"});
	elemento.connect("Responder questao3",new String[] {"fim"});
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	}
	
	
	@Test
	public void connect_happy_SE_HT_EG_2elements_false_EE() throws Exception{
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
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	}
	
	
	@Test
	public void connect_happy_SE_HT_EG_EE() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new HumanTask("Responder questao2"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio",new String[] {"Responder questao"});
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" });
	elemento.connect("Desvio Exclusivo",new String[] {"fim", "Responder questao2" });
	elemento.connect("Responder questao2",new String[] {"fim"});
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	
	}

	
	@Test
	public void newFluxVOuF_V() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.nomeDoFluxo("Fluxo Venda Refrigerante");
	
	elemento.adicionaElemento(new StartEvent("Inicio"));
	elemento.adicionaElemento(new HumanTask("HT"));
	elemento.adicionaElemento(new HumanTask("HT2"));
	elemento.adicionaElemento(new ExclusiveGateway("Disponivel?"));
	elemento.adicionaElemento(new EndEvent("fim"));
	
	elemento.connect("Inicio",new String[] {"HT"});
	elemento.connect("HT",new String[] {"Disponivel?"});
	elemento.connect("Disponivel?",new String[] {"HT2", "fim"});
	elemento.connect("HT2",new String[] {"fim"});
	
	elemento.campoFormulario("V ou F", "HT", new String[] {"Sim", "Não"});
	
	elemento.getNextElement("Inicio");
	elemento.getNextElement("HT");
	elemento.preencheFormulario("HT" , "Sim");
	elemento.getNextElement("Disponivel?");
	Assert.assertEquals("Disponivel?, Sim", elemento.getNextElement("Disponivel?"));
	
	}
	
	@Test
	public void newFluxVOuF_False() throws Exception{
		BPMNElemento elemento = new BPMNElemento();
		elemento.nomeDoFluxo("Fluxo Venda Refrigerante");
		
		elemento.adicionaElemento(new StartEvent("Inicio"));
		elemento.adicionaElemento(new HumanTask("HT"));
		elemento.adicionaElemento(new HumanTask("HT2"));
		elemento.adicionaElemento(new ExclusiveGateway("Disponivel?"));
		elemento.adicionaElemento(new EndEvent("fim"));
		
		elemento.connect("Inicio",new String[] {"HT"});
		elemento.connect("HT",new String[] {"Disponivel?"});
		elemento.connect("Disponivel?",new String[] {"HT2", "fim"});
		elemento.connect("HT2",new String[] {"fim"});
		
		elemento.campoFormulario("V ou F", "HT", new String[] {"Sim", "Não"});
		elemento.campoFormulario("V ou F", "HT2", new String[] {"Sim"});
		
		elemento.getNextElement("Inicio");
		elemento.getNextElement("HT");
		elemento.preencheFormulario("HT" , "Não");
		elemento.getNextElement("Disponivel?");
		elemento.getNextElement("HT2");
		elemento.preencheFormulario("HT2" , "Sim");
		Assert.assertEquals(" ", elemento.getNextElement("HT2"));
	}
	
	
	
	@Test
	public void newFluxVOuF_3_ElementosNoFormulario() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.nomeDoFluxo("Fluxo Venda Refrigerante");
	
	elemento.adicionaElemento(new StartEvent("Inicio"));
	elemento.adicionaElemento(new HumanTask("HT"));
	elemento.adicionaElemento(new HumanTask("HT2"));
	elemento.adicionaElemento(new ExclusiveGateway("Disponivel?"));
	elemento.adicionaElemento(new EndEvent("fim"));
	
	elemento.connect("Inicio",new String[] {"HT"});
	elemento.connect("HT",new String[] {"Disponivel?"});
	elemento.connect("Disponivel?",new String[] {"HT2", "fim"});
	elemento.connect("HT2",new String[] {"fim"});
	thrown.expectMessage("Numero de Elementos no Formulario Maior que 2");
	elemento.campoFormulario("V ou F", "HT", new String[] {"Sim", "Não", "talvez"});
	}
	
	
	
}