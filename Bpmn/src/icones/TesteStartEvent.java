package icones;

import org.junit.Assert;
import org.junit.Test;

public class TesteStartEvent {

	private EventoFinal eventoFinal;
	private HumanTask humanTask = new HumanTask();

	
	@Test
	public void RetornoElemento() {
		Elemento expected = humanTask;
        Elemento actual = new EventoInicial().proximoElemento(true, humanTask);
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void RetornoElemento2() {
		Elemento expected = eventoFinal;
        Elemento actual = new EventoInicial().proximoElemento(false, humanTask);
        Assert.assertEquals(expected, actual);
	}
	
	
	
	
	
}
