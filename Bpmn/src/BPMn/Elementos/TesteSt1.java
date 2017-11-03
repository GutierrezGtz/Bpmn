package BPMn.Elementos;

import org.junit.Assert;
import org.junit.Test;



public class TesteSt1 {

	
	@Test
	public void QuandoAtributosPassam() {
		boolean expected = true;
        boolean actual = new StartEvent(true).proximoElemento();
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void QuandoAtributosNaoPassam() {
		boolean expected = false;
        boolean actual = new StartEvent(false).proximoElemento();
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void RecebendoFluxo() {
		boolean expected = true;
        boolean actual = new TarefaHumana(null).proximoElemento();
        Assert.assertEquals(expected, actual);
	}
	
	
	
}
