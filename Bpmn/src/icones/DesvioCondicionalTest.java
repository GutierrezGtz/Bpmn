package icones;

import org.junit.Assert;
import org.junit.Test;

public class DesvioCondicionalTest {

	Elemento elemento;
	DesvioCondicionalExclusivo desvioCondicionalExclusivo = new DesvioCondicionalExclusivo();
	
	@Test
	public void fluxoAndando() {
		Elemento expected = desvioCondicionalExclusivo;
		Elemento actual = new DesvioCondicionalExclusivo().ProximoElemento(desvioCondicionalExclusivo);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void Filtro() {
		boolean expected = true;
		boolean actual = new DesvioCondicionalExclusivo().FiltraFluxo();
		Assert.assertEquals(expected, actual);
	
	}
	
	
	
	
}
