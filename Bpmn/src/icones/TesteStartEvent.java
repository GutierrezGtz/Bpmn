package icones;

import org.junit.Assert;
import org.junit.Test;

public class TesteStartEvent {

	private EventoFinal eventoFinal = new EventoFinal();
	private HumanTask humanTask = new HumanTask();

	
	@Test
	public void RetornoElemento() {
		Elemento expected = humanTask;
        Elemento actual = new EventoInicial().ProximoElemento(humanTask);
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void RetornoElemento2() {
		Elemento expected = eventoFinal;
        Elemento actual = new EventoInicial().ProximoElemento(eventoFinal);
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void AtendeuRequisitosSim() {
		boolean expected = true;
		boolean actual = new EventoInicial().RequisitosAtendidos(true);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void AtendeuRequisitosNao() {
		boolean expected = false;
		boolean actual = new EventoInicial().RequisitosAtendidos(false);
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
	
	
	
	
}
