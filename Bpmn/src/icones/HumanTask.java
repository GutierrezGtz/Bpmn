package icones;

public class HumanTask {

	
	private boolean tarefaHumana;

	HumanTask(boolean tarefaHumana) {
		this.tarefaHumana = tarefaHumana;
	}
	

	public boolean validaçãoHumana() {
		if(tarefaHumana == true) {
			return true;
		}else {
			return false;
		}
	}


	public boolean proximoElemento() {
		
		return false;
	}
}
	

