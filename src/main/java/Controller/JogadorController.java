package Controller;

import java.net.Socket;

import Model.Jogador;
import Model.Message;

public class JogadorController implements MessageHandler {
	private Jogador jogador;	
	
	public JogadorController(Jogador jogador) {
		super();
		this.jogador = jogador;
	}
	
	
	@Override
	public void processar(Message mensagem, Socket connexao) {
		

	}

}
