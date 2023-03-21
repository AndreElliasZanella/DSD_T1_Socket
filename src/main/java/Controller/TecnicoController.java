package Controller;

import java.net.Socket;

import Model.Message;
import Model.Tecnico;

public class TecnicoController extends MessageHandler {
	
	private Tecnico tecnico;

	public TecnicoController(Message mensagem, Socket connexao, Tecnico tecnico) {
		super(mensagem, connexao);
		this.tecnico = tecnico;
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
