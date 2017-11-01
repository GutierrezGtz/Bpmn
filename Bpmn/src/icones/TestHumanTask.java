package icones;

import org.junit.Assert;
import org.junit.Test;



public class TestHumanTask {

	
	@Test
	public void tarefaHumanaValidada() {
		boolean expected = true;
		boolean actual = new HumanTask(true).valida��oHumana();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void tarefaHumanaNaoValidada() {
		boolean expected = false;
		boolean actual = new HumanTask(false).valida��oHumana();
		Assert.assertEquals(expected, actual);
	}
	
}
