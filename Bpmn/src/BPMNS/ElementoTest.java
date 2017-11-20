package BPMNS;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


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
	elemento.connect("inicio",new String[] {"Responder questao"}, true);
	elemento.connect("Responder questao",new String[] {"fim"}, true);
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("fim", elemento.getNextElement("Responder questao"));
	}
	
	@Test
	public void connect_happy_SE_HT_EG_EEtest() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio",new String[] {"Responder questao"}, true);
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" }, true);
	elemento.connect("Desvio Exclusivo",new String[] {"fim"}, true);
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
		elemento.connect("inicio",new String[] {"x"},true);
		
	}
	
	@Test
	public void connect_bad_x_SE() throws Exception {
		BPMNElemento elemento = new BPMNElemento();
		elemento.adicionaElemento(new StartEvent("inicio"));
		thrown.expectMessage("Elemento Inexistente");
		elemento.connect("x",new String[] {"inicio"}, true);
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
	elemento.connect("inicio",new String[] {"Responder questao"},true);
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" }, true);
	elemento.connect("Desvio Exclusivo",new String[] {"Responder questao2", "Responder questao3" }, true);
	elemento.connect("Responder questao2",new String[] {"fim"}, true);
	elemento.connect("Responder questao3",new String[] {"fim"}, true);
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
	elemento.connect("inicio",new String[] {"Responder questao"},true);
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" }, true);
	elemento.connect("Desvio Exclusivo",new String[] {"fim", "Responder questao2", "Responder questao3" }, true);
	elemento.connect("Responder questao2",new String[] {"fim"}, true);
	elemento.connect("Responder questao3",new String[] {"fim"}, true);
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	Assert.assertEquals("fim", elemento.getNextElement("Desvio Exclusivo"));
	
	
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
	elemento.connect("inicio",new String[] {"Responder questao"},true);
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" }, true);
	elemento.connect("Desvio Exclusivo",new String[] {"Responder questao2", "Responder questao3" }, false);
	elemento.connect("Responder questao2",new String[] {"fim"}, true);
	elemento.connect("Responder questao3",new String[] {"fim"}, true);
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	Assert.assertEquals("Responder questao3", elemento.getNextElement("Desvio Exclusivo"));
	}
	
	@Test
	public void connect_happy_SE_HT_EG_3elements_false_EE() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("inicio"));
	elemento.adicionaElemento(new HumanTask("Responder questao"));
	elemento.adicionaElemento(new HumanTask("Responder questao2"));
	elemento.adicionaElemento(new HumanTask("Responder questao3"));
	elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.connect("inicio",new String[] {"Responder questao"},true);
	elemento.connect("Responder questao",new String[] {"Desvio Exclusivo" }, true);
	elemento.connect("Desvio Exclusivo",new String[] {"fim", "Responder questao2", "Responder questao3" }, false);
	elemento.connect("Responder questao2",new String[] {"fim"}, true);
	elemento.connect("Responder questao3",new String[] {"fim"}, true);
	Assert.assertEquals("Responder questao", elemento.getNextElement("inicio"));
	Assert.assertEquals("Desvio Exclusivo", elemento.getNextElement("Responder questao"));
	Assert.assertEquals("Responder questao2", elemento.getNextElement("Desvio Exclusivo"));
	Assert.assertEquals("fim", elemento.getNextElement("Responder questao2"));
	}

	
	
	
	
	@Test
	public void newflux() throws Exception{
	BPMNElemento elemento = new BPMNElemento();
	elemento.adicionaElemento(new StartEvent("Inicio"));
	elemento.adicionaElemento(new HumanTask("Solicitar Refrigerante"));
	elemento.adicionaElemento(new HumanTask("Verificar Disponibilidade"));
	elemento.adicionaElemento(new ExclusiveGateway("Disponivel?"));
	elemento.adicionaElemento(new HumanTask("Verificar Dinheiro Disponivel"));
	elemento.adicionaElemento(new EndEvent("fim"));
	elemento.adicionaElemento(new ExclusiveGateway("Dinheiro Disponivel?"));
	elemento.adicionaElemento(new HumanTask("Realizar Pagamento"));
	elemento.adicionaElemento(new HumanTask("Entrega Refrigerante"));
	
	elemento.connect("Inicio",new String[] {"Solicitar Refrigerante"},true);
	elemento.connect("Solicitar Refrigerante",new String[] {"Verificar Disponibilidade" }, true);
	elemento.connect("Verificar Disponibilidade",new String[] {"Disponivel?"}, true);
	elemento.connect("Disponivel?",new String[] {"Verificar Dinheiro Disponivel", "fim"}, true);
	elemento.connect("Verificar Dinheiro Disponivel",new String[] {"Dinheiro Disponivel?"}, true);
	elemento.connect("Dinheiro Disponivel?",new String[] {"Realizar Pagamento", "fim"}, resposta);
	elemento.connect("Realizar Pagamento",new String[] {"Entrega Refrigerante"}, true);
	elemento.connect("Entrega Refrigerante",new String[] {"fim"}, true);
	
	elemento.campoFormulario("Solicitar Refrigerante", new String[] {"Guarana", "Coca-Cola", "Fanta"});//nomes do campo
	elemento.campoFormulario("Verificar Disponibilidade", new String[] {"Guarana", "Coca-Cola"});
	
	elemento.preencheFormulario("Guarana");
	elemento.preencheFormulario("");
	
	elemento.getNextElement("inicio");
	elemento.getNextElement("Solicitar Refrigerante");
	elemento.getNextElement("Verificar Disponibilidade");
	
	System.out.println("Digite a Resposta: ");
	resposta = s.nextBoolean();
	

	Assert.assertEquals(true, resposta);
	
	
	}
	
	

//	@Test
//	public void happy_FLUXO_SE_HT_EG_EE() throws Exception{
//		BPMNElemento elemento = new BPMNElemento();
//		elemento.adicionaElemento(new StartEvent("inicio"));
//		elemento.adicionaElemento(new HumanTask("Solicitar Refrigerante"));
//		elemento.adicionaElemento(new HumanTask("Verificar Disponibilidade"));
//		elemento.adicionaElemento(new ExclusiveGateway("Desvio Exclusivo"));
//		elemento.adicionaElemento(new HumanTask("Renova"));
//		elemento.adicionaElemento(new EndEvent("fim"));
//		elemento.connect("inicio",new String[] {"Solicitar Refrigerante"},true);
//		elemento.connect("Solicitar Férias",new String[] {"Verificar Disponibilidade" }, true);
//		elemento.connect("Desvio Exclusivo",new String[] {"renova", "fim"}, false);
//		elemento.getNextElement("inicio");
//		elemento.getNextElement("Solicitar Férias");
//		elemento.getNextElement("Desvio Exclusivo");
//		Assert.assertEquals("fim", elemento.getNextElement("Desvio Exclusivo"));
//		Assert.assertEquals("Atendeu a Solicitação", elemento.correctMSG("pergunta"));
//		
//		
//		
//	}
	
//	@Test
//	public void adicionaVar() throws Exception{
//	BPMNElemento elemento = new BPMNElemento();
//	elemento.adicionaVariaveis(new String[] {"disponivel/boolean","msg/String"});
//	
//	
//	
//	}
	
}	
	

	

