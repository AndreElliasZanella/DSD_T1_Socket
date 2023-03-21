package Controller;

import java.net.Socket;

import Model.Message;
import Model.Tecnico;

public class TecnicoController implements MessageHandler {
	
	private Tecnico tecnico;	

	public TecnicoController(Tecnico tecnico) {
		super();
		this.tecnico = tecnico;
	}



	@Override
	public void processar(Message mensagem, Socket connexao) {
		// TODO Auto-generated method stub

	}

}
