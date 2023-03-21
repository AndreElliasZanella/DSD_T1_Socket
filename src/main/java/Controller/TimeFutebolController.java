package Controller;

import java.net.Socket;

import Model.Message;
import Model.TimeFutebol;

public class TimeFutebolController extends MessageHandler {
	private TimeFutebol time;
	
	public TimeFutebolController(Message mensagem, Socket connexao, TimeFutebol time) {
		super(mensagem, connexao);
		this.time = time;
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

}
