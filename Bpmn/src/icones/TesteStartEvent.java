package icones;

import org.junit.Assert;
import org.junit.Test;

public class TesteStartEvent {

	
	@Test
	public void QuandoAtributosPassam() {
		boolean expected = true;
        boolean actual = new EventoInicial(true).proximoElemento();
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void QuandoAtributosNaoPassam() {
		boolean expected = false;
        boolean actual = new EventoInicial(false).proximoElemento();
        Assert.assertEquals(expected, actual);
	}
	
	
	
	
}
