package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import Database.TimeFutebolDatabase;
import Model.TimeFutebol;
import Model.Message;
import util.SenderMessage;

public class TimeFutebolController extends MessageHandler {
	private TimeFutebol time;
	private PrintWriter out;
	private Gson gson;
	
	public TimeFutebolController(Message mensagem, Socket connexao, TimeFutebol time) throws IOException {
		super(mensagem, connexao);
		this.time = time;
		gson = new Gson();
		out = new PrintWriter(connexao.getOutputStream(), true);
	}

	@Override
	public void insert() {
		TimeFutebolDatabase.times.add(time);
		String mensagem = "Time inserido!";
		out.println(SenderMessage.converteMessage(mensagem));
		
	}

	@Override
	public void list() {
		String mensagem = "Times\n";
		mensagem += TimeFutebolDatabase.times.size() + "\n";
		for (TimeFutebol time : TimeFutebolDatabase.times) {
			mensagem += time.toString() + "\n";
		}
		out.println(SenderMessage.converteMessage(mensagem));
	}

	@Override
	public void delete() {
		String retorno = MessageHandler.TIME_NAO_ENCONTRADO;
		if(TimeFutebolDatabase.times.isEmpty()) {
			retorno = MessageHandler.SEM_TIMES_CADASTRADAS;
		} else {
			TimeFutebol encontrado = null;
			for(TimeFutebol time : TimeFutebolDatabase.times) {
				if(time.getNome().equals(this.time.getNome())) {
					encontrado = time;
					break;
				}
			}
			if(encontrado != null) {
				TimeFutebolDatabase.times.remove(encontrado);
				retorno = MessageHandler.TIME_REMOVIDO_SUCESSO;
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
	}

	@Override
	public void get() {
		String retorno = MessageHandler.TIME_NAO_ENCONTRADO;
		if(TimeFutebolDatabase.times.isEmpty()) {
			retorno = MessageHandler.SEM_TIMES_CADASTRADAS;
		} else {
			TimeFutebol encontrado = null;
			for(TimeFutebol time : TimeFutebolDatabase.times) {
				if(time.getNome().equals(this.time.getNome())) {
					encontrado = time;
					break;
				}
			}
			if(encontrado != null) {
				retorno = gson.toJson(encontrado);
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
		
	}

	@Override
	public void update() {
		String retorno = MessageHandler.TIME_NAO_ENCONTRADO;
		TimeFutebol encontrado = null;
		for(int i = 0; i <= TimeFutebolDatabase.times.size(); i++) {
			if(time.getNome().equals(TimeFutebolDatabase.times.get(i).getNome())) {
				encontrado = time;
				TimeFutebolDatabase.times.remove(i);
				break;
			}
		}
		if(encontrado != null) {
			TimeFutebolDatabase.times.remove(encontrado);
			insert();
			retorno = MessageHandler.TIME_ATUALIZADO;
		}
		out.println(SenderMessage.converteMessage(retorno));
	}

}
