package icones;

import org.junit.Assert;
import org.junit.Test;

import BPMn.Elementos.Elemento;



public class TestHumanTask {

	
	Elemento elemento;
	
	@Test
	public void tarefaHumanaValidada() {
		boolean expected = true;
		boolean actual = new HumanTask(true).validaçãoHumana();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void tarefaHumanaNaoValidada() {
		boolean expected = false;
		boolean actual = new HumanTask(false).validaçãoHumana();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void fluxoAndando() {
		Elemento expected = elemento;
		boolean actual = new HumanTask(true).proximoElemento();
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
	
	
}
