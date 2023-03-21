package Controller;

import java.net.Socket;

import Model.Message;
import Model.TimeFutebol;

public class TimeFutebolController implements MessageHandler {
	
	private TimeFutebol time;

	public TimeFutebolController(TimeFutebol time) {
		this.time = time;
	}

	@Override
	public void processar(Message mensagem, Socket connexao) {
		// TODO Auto-generated method stub

	}

}
