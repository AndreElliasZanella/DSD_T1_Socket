package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import Database.TecnicoDatabase;
import Model.Tecnico;
import Model.Message;
import util.SenderMessage;

public class TecnicoController extends MessageHandler {
	
	private Tecnico tecnico;
	private PrintWriter out;
	private Gson gson;
	
	public TecnicoController(Message mensagem, Socket connexao, Tecnico tecnico) throws IOException {
		super(mensagem, connexao);
		this.tecnico = tecnico;
		gson = new Gson();
		out = new PrintWriter(connexao.getOutputStream(), true);
	}

	@Override
	public void insert() {
		TecnicoDatabase.tecnicos.add(tecnico);
        String mensagem = "Técnico inserido!";
        out.println(SenderMessage.converteMessage(mensagem));
		
	}

	@Override
	public void list() {
		String mensagem = "Técnicos\n";
		mensagem += TecnicoDatabase.tecnicos.size() + "\n";
		for( Tecnico tecnico : TecnicoDatabase.tecnicos) {
			mensagem += tecnico.toString() + "\n";
		}
		out.println(SenderMessage.converteMessage(mensagem));
		
	}

	@Override
	public void delete() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		if(TecnicoDatabase.tecnicos.isEmpty()) {
			retorno = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		} else {
			Tecnico encontrado = null;
			for(Tecnico tecnico : TecnicoDatabase.tecnicos) {
				if(tecnico.getCpf().equals(this.tecnico.getCpf())) {
					encontrado = tecnico;
					break;
				}
			}
			if(encontrado != null) {
				TecnicoDatabase.tecnicos.remove(encontrado);
				retorno = MessageHandler.PESSOA_REMOVIDA_SUCESSO;
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
		
	}

	@Override
	public void get() {
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		if(TecnicoDatabase.tecnicos.isEmpty()) {
			retorno = MessageHandler.SEM_PESSOAS_CADASTRADAS;
		} else {
			Tecnico encontrado = null;
			for(Tecnico tecnico : TecnicoDatabase.tecnicos) {
				if(tecnico.getCpf().equals(this.tecnico.getCpf())) {
					encontrado = tecnico;
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
		String retorno = MessageHandler.PESSOA_NAO_ENCONTRADA;
		Tecnico encontrado = null;
		for(int i = 0; i <= TecnicoDatabase.tecnicos.size(); i++) {
			if(tecnico.getCpf().equals(this.tecnico.getCpf())) {
				encontrado = tecnico;
				TecnicoDatabase.tecnicos.remove(i);
				break;
			}
		}
		if(encontrado != null) {
			TecnicoDatabase.tecnicos.remove(encontrado);
			insert();
			retorno = MessageHandler.PESSOA_ATUALIZADA;
		}
		out.println(SenderMessage.converteMessage(retorno));		
	}	
	
}
