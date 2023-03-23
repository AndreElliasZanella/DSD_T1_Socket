package Controller;

import java.net.Socket;

import Model.Message;

public abstract class MessageHandler {
	protected Message mensagem;
	protected Socket connexao;
	
	public static String SEM_PESSOAS_CADASTRADAS = "Sem pessoas cadastradas";
	public static String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";
	public static String PESSOA_REMOVIDA_SUCESSO = "Pessoa removida com sucesso";
	public static String TIME_NAO_ENCONTRADO = "Time não encontrado";
	public static String TIME_REMOVIDO_SUCESSO = "Time removido com sucesso";
	public static String SEM_TIMES_CADASTRADAS = "Sem times cadastradas";
	public static String PESSOA_ATUALIZADA = "Pessoa atualizada com sucesso";
	public static String TIME_ATUALIZADO = "Time atualizado com sucesso";
	
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
		case ADD_JOGADOR_AO_TIME:
			addJogadorAoTime();
			break;
		case ADD_TECNICO_AO_TIME:
			addTecnicoAoTime();
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
	
	public void addJogadorAoTime() {}
	public void addTecnicoAoTime() {}
}
