package tdd;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
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


	Scanner s = new Scanner(System.in);
	private BPMNElemento elemento;
	
	@Before
	public void inicia(){
		this.elemento = new BPMNElemento();
	}
	
	@Test
	public void adicionaElemento_happy_SE_HT_EG_EE(){
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	Assert.assertEquals(4,elemento.countElements());
	}

	
	@Test
	public void connect_happy_SE_HT_EE() throws Exception {
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio",new String[] {"Responder questao"});
	elemento.connect("Responder questao",new String[] {"fim"});
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	
	}
	
	@Test
	public void connect_happy_SE_HT_EG_EEtest() throws Exception{
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
		elemento.adicionaElemento(new StartEvent("inicio"));
	//	thrown.expectMessage("Elemento Inexistente");
		thrown.expect(IllegalArgumentException.class);//modos diferentes de fazer a mesma exception
		elemento.connect("inicio",new String[] {"x"});	
	}
	
	
	@Test
	public void connect_bad_x_SE() throws Exception {
		elemento.adicionaElemento(new StartEvent("inicio"));
		thrown.expectMessage("Elemento Inexistente");
		elemento.connect("x",new String[] {"inicio"});
	}
	
	@Test
	public void connect_happy_SE_HT_EG_2elements_true_EE() throws Exception{
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
	elemento.nomeDoFluxo("Fluxo Teste");
	
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
	Assert.assertEquals("HT2", elemento.getNextElement("Disponivel?"));
	Assert.assertEquals("HT2", elemento.getNextElement("HT2"));
	
	}
	
	@Test
	public void newFluxVOuF_False() throws Exception{
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
		Assert.assertEquals("Disponivel?, Não", elemento.getNextElement("Disponivel?"));
	}
	
	
	
	@Test
	public void newFluxVOuF_3_ElementosNoFormulario() throws Exception{
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
	elemento.campoFormulario("V ou F", "HT", new String[] {"Sim", "Não", "talvez"});//ta certo essa linha.
	}
	
	@Test
	public void newFluxVOuF_fim_no_true() throws Exception{
		elemento.nomeDoFluxo("Fluxo Venda Refrigerante");
		
		elemento.adicionaElemento(new StartEvent("Inicio"));
		elemento.adicionaElemento(new HumanTask("HT"));
		elemento.adicionaElemento(new HumanTask("HT2"));
		elemento.adicionaElemento(new ExclusiveGateway("Disponivel?"));
		elemento.adicionaElemento(new EndEvent("fim"));
		
		elemento.connect("Inicio",new String[] {"HT"});
		elemento.connect("HT",new String[] {"Disponivel?"});
		elemento.connect("Disponivel?",new String[] {"fim", "HT2"});
		elemento.connect("HT2",new String[] {"fim"});
		
		elemento.campoFormulario("V ou F", "HT", new String[] {"Sim", "Não"});
		elemento.campoFormulario("V ou F", "HT2", new String[] {"Sim"});
		
		elemento.getNextElement("Inicio");
		elemento.getNextElement("HT");
		elemento.preencheFormulario("HT" , "Sim");
		elemento.getNextElement("Disponivel?");
		Assert.assertEquals("Disponivel?, Sim", elemento.getNextElement("Disponivel?"));
	}
	
	
	
	
	@Test
  	public void newflux() throws Exception{
	
	elemento.adicionaElemento(new StartEvent("Inicio"));
	elemento.adicionaElemento(new HumanTask("Solicitar Refrigerante"));
	elemento.adicionaElemento(new HumanTask("Verificar Disponibilidade"));
	elemento.adicionaElemento(new HumanTask("Verificar Dinheiro Disponivel"));
	elemento.adicionaElemento(new HumanTask("Realizar Pagamento"));
	elemento.adicionaElemento(new HumanTask("Entrega Refrigerante"));
	elemento.adicionaElemento(new ExclusiveGateway("Disponivel?"));
	elemento.adicionaElemento(new ExclusiveGateway("Ha?"));
	elemento.adicionaElemento(new EndEvent("fim"));
		
	elemento.connect("Inicio",new String[] {"Solicitar Refrigerante"});
	elemento.connect("Solicitar Refrigerante",new String[] {"Verificar Disponibilidade"});
	elemento.connect("Verificar Disponibilidade",new String[] {"Disponivel?"});
	elemento.connect("Disponivel?",new String[] {"Verificar Dinheiro Disponivel", "fim"});
	elemento.connect("Verificar Dinheiro Disponivel",new String[] {"Ha?"});
	elemento.connect("Ha?",new String[] {"Realizar Pagamento", "fim"});
	elemento.connect("Realizar Pagamento",new String[] {"Entrega Refrigerante"});
	elemento.connect("Entrega Refrigerante",new String[] {"fim"});
  	
  	elemento.campoFormulario("V ou F", "Verificar Disponibilidade", new String[] {"Sim", "Não"});
  	elemento.campoFormulario("V ou F", "Verificar Dinheiro Disponivel", new String[] {"há dinheiro", "não há dinheiro"});
 	
 	elemento.getNextElement("Inicio");
 	elemento.getNextElement("Solicitar Refrigerante");
 	elemento.getNextElement("Verificar Disponibilidade");
 	elemento.preencheFormulario("Verificar Disponibilidade" , "Sim");
 	elemento.getNextElement("Disponivel?");
 	elemento.getNextElement("Verificar Dinheiro Disponivel");
 	elemento.preencheFormulario("Verificar Dinheiro Disponivel" , "não há dinheiro");
  	Assert.assertEquals("Ha?, não há dinheiro", elemento.getNextElement("Ha?"));
	
	}
	

}