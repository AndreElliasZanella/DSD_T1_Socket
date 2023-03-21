package Controller;

import java.net.Socket;

import Model.Message;

public interface MessageHandler {
	public void processar(Message mensagem, Socket connexao);
}
