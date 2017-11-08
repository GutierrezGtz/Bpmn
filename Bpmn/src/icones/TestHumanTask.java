package icones;

import org.junit.Assert;
import org.junit.Test;


public class TestHumanTask {

	Elemento elemento;
	DesvioCondicionalExclusivo desvioCondicionalExclusivo = new DesvioCondicionalExclusivo();
	
	@Test
	public void fluxoAndando() {
		Elemento expected = desvioCondicionalExclusivo;
		Elemento actual = new HumanTask().ProximoElemento(desvioCondicionalExclusivo);
		Assert.assertEquals(expected, actual);
	}
	

	
}
