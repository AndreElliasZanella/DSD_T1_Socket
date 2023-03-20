package Model;

public class Message {
	private Pessoa pessoa;
	private TimeFutebol time;
	private String metodo;
	private String prop;
	
	public Message(Pessoa pessoa, TimeFutebol time, String metodo) {
		super();
		this.pessoa = pessoa;
		this.time = time;
		this.metodo = metodo;
	}
	
	public boolean isExistsTime() {
		if(time != null) {
			return true;
		}
		return false;
	}
	
	public boolean isExistsJogador() {
		if(pessoa != null) {
			Class<?> obj = pessoa.getClass();
			if(obj.equals(Jogador.class)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isExistsTecnico() {
		if(pessoa != null) {
			Class<?> obj = pessoa.getClass();
			if(obj.equals(Tecnico.class)) {
				return true;
			}
		}
		return false;
	}
	
	public TipoMetodo getTipoMetodo(){
		switch (metodo) {
		case "GET": {
			return TipoMetodo.GET;
		}
		case "INSERT": {
			return TipoMetodo.INSERT;
		}
		case "UPDATE": {
			return TipoMetodo.UPDATE;
		}
		case "DELETE": {
			return TipoMetodo.DELETE;
		}
		case "LIST": {
			return TipoMetodo.LIST;
		}
		default:
			return null;
		}
	}
	
	
}
