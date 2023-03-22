package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import Database.JogadorDatabase;
import Model.Jogador;
import Model.Message;

public class JogadorController extends MessageHandler {
	private Jogador jogador;
	private PrintWriter out;
	private Gson gson;
	
	public JogadorController(Message mensagem, Socket connexao, Jogador jogador) throws IOException {
		super(mensagem, connexao);
		this.jogador = jogador;
		gson = new Gson();
		out = new PrintWriter(connexao.getOutputStream(), true);
	}
	

	@Override
	public void insert() {
		JogadorDatabase.jogadores.add(jogador);
                String mensagem = "Jogador inserido!";
                out.write(mensagem);
	}



	@Override
	public void list() {
		String mensagem = "Jogadores \n";
		mensagem += JogadorDatabase.jogadores.size();
		for( Jogador jogador : JogadorDatabase.jogadores) {
			mensagem += jogador.toString() + "\n";
		}
		out.write(mensagem);
	}


	@Override
	public void delete() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		if(JogadorDatabase.jogadores.isEmpty()) {
			retorno = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		} else {
			Jogador encontrado = null;
			for(Jogador jogador : JogadorDatabase.jogadores) {
				if(jogador.getCpf().equals(jogador.getCpf())) {
					encontrado = jogador;
					break;
				}
			}
			if(encontrado != null) {
				JogadorDatabase.jogadores.remove(encontrado);
				retorno = MessageHandler.PESSOA_REMOVIDA_SUCESSO;
			}
		}
		out.write(retorno);
		
	}



	@Override
	public void get() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		if(JogadorDatabase.jogadores.isEmpty()) {
			retorno = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		} else {
			Jogador encontrado = null;
			for(Jogador jogador : JogadorDatabase.jogadores) {
				if(jogador.getCpf().equals(jogador.getCpf())) {
					encontrado = jogador;
					break;
				}
			}
			if(encontrado != null) {
				retorno = gson.toJson(encontrado);
			}
		}
		out.write(retorno);
	}



	@Override
	public void update() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		Jogador encontrado = null;
		for(int i = 0; i <= JogadorDatabase.jogadores.size(); i++) {
			if(jogador.getCpf().equals(jogador.getCpf())) {
				encontrado = jogador;
				JogadorDatabase.jogadores.remove(i);
				break;
			}
		}
		if(encontrado != null) {
			JogadorDatabase.jogadores.remove(encontrado);
			retorno = MessageHandler.PESSOA_REMOVIDA_SUCESSO;
		}
		out.write(retorno);
		
	}

}
