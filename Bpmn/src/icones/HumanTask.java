package icones;

public class HumanTask {

	
	private boolean tarefaHumana;

	HumanTask(boolean tarefaHumana) {
		this.tarefaHumana = tarefaHumana;
	}
	

	public boolean valida��oHumana() {
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
	

