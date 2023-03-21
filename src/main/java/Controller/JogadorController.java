package Controller;

import java.net.Socket;
import java.util.List;

import Database.JogadorDatabase;
import Model.Jogador;
import Model.Message;

public class JogadorController extends MessageHandler {
	private Jogador jogador;	
	
	public JogadorController(Message mensagem, Socket connexao, Jogador jogador) {
		super(mensagem, connexao);
		this.jogador = jogador;
	}
	

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	public void addJogador(Jogador jogador) {
		JogadorDatabase.jogadores.add(jogador);
	}
	
	public Jogador getJogador(String cpf) {
		Jogador encontrado = null;
		for(Jogador jogador : JogadorDatabase.jogadores) {
			if(jogador.getCpf().equals(cpf)) {
				encontrado = jogador;
				break;
			}
		}
		return encontrado;
	}
	
	public void deleteJogador(String cpf) throws Exception {
		Jogador jogador = this.getJogador(cpf);
		if(jogador != null) {
			JogadorDatabase.jogadores.remove(jogador);
		} else {
			throw new Exception("Jogador não encontrado");
		}
	}
	
	public List<Jogador> listjogador(){
		return JogadorDatabase.jogadores;
	}

}
