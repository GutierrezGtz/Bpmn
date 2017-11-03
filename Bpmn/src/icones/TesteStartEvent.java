package icones;

import org.junit.Assert;
import org.junit.Test;

public class TesteStartEvent {

	
	private Elemento elemento;
	
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
	
//	@Test
//	public void RetornoElemento() {
//		Elemento expected = elemento;
//        Elemento actual = new EventoInicial(false).retornaElemento();
//        Assert.assertEquals(expected, actual);
//	}
	
	
	
	
}
