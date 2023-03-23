package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Database.JogadorDatabase;
import Model.Jogador;
import Model.Message;
import util.SenderMessage;

public class JogadorController extends MessageHandler {
	private Jogador jogador;
	private PrintWriter out;
	
	public JogadorController(Message mensagem, Socket connexao, Jogador jogador) throws IOException {
		super(mensagem, connexao);
		this.jogador = jogador;
		out = new PrintWriter(connexao.getOutputStream(), true);
	}
	

	@Override
	public void insert() {
		JogadorDatabase.jogadores.add(jogador);
		String mensagem = "Jogador inserido!";
		out.println(SenderMessage.converteMessage(mensagem));
	}


	@Override
	public void list() {
		String mensagem = "Jogadores\n";
		if(JogadorDatabase.jogadores.size() > 0) {
			mensagem += JogadorDatabase.jogadores.size() + "\n";
			for( Jogador jogador : JogadorDatabase.jogadores) {
				mensagem += jogador.toString() + "\n";
			}
		} else {
			mensagem = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		}
		out.println(SenderMessage.converteMessage(mensagem));
	}


	@Override
	public void delete() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		if(JogadorDatabase.jogadores.isEmpty()) {
			retorno = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		} else {
			Jogador encontrado = null;
			for(Jogador jogador : JogadorDatabase.jogadores) {
				if(jogador.getCpf().equals(this.jogador.getCpf())) {
					encontrado = jogador;
					break;
				}
			}
			if(encontrado != null) {
				JogadorDatabase.jogadores.remove(encontrado);
				retorno = MessageHandler.PESSOA_REMOVIDA_SUCESSO;
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
	}
	
	public static Jogador getJogador(String cpf) {
		Jogador encontrado = null;
		for(Jogador jogador : JogadorDatabase.jogadores) {
			if(jogador.getCpf().equals(cpf)) {
				encontrado = jogador;
				break;
			}
		}
		return encontrado;
	}



	@Override
	public void get() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		if(JogadorDatabase.jogadores.isEmpty()) {
			retorno = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		} else {
			Jogador encontrado = getJogador(this.jogador.getCpf());
			if(encontrado != null) {
				retorno = encontrado.toString();
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
	}



	@Override
	public void update() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		Jogador encontrado = null;
		for(int i = 0; i <= JogadorDatabase.jogadores.size() - 1; i++) {
			if(jogador.getCpf().equals(JogadorDatabase.jogadores.get(i).getCpf())) {
				encontrado = jogador;
				JogadorDatabase.jogadores.remove(i);
				break;
			}
		}
		if(encontrado != null) {
			JogadorDatabase.jogadores.remove(encontrado);
			JogadorDatabase.jogadores.add(jogador);
			retorno = "Pessoa atualizada com sucesso!";
		}
		out.println(SenderMessage.converteMessage(retorno));
	}

}
