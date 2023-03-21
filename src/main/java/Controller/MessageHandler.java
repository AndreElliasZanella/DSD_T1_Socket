package Controller;

import java.net.Socket;

import Model.Message;

public abstract class MessageHandler {
	protected Message mensagem;
	protected Socket connexao;
	
	public static String SEM_PESSOAS_CADASTRADAS = "Sem pessoas cadastradas";
	public static String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";
	public static String PESSOA_REMOVIDA_SUCESSO = "Pessoa removida com sucesso";
	
	public MessageHandler(Message mensagem, Socket connexao) {
		super();
		this.mensagem = mensagem;
		this.connexao = connexao;
	}

	public void processar() {
		switch (mensagem.getTipoMetodo()) {
		case LIST:
			list();
			break;
		case GET:
			get();
			break;
		case DELETE:
			delete();
			break;
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;

		default:
			break;
		}
	}
	
	public abstract void insert();
	public abstract void list();
	public abstract void delete();
	public abstract void get();
	public abstract void update();
}
