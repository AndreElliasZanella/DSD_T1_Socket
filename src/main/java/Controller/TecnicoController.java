package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Database.TecnicoDatabase;
import Model.Tecnico;
import Model.Message;
import util.SenderMessage;

public class TecnicoController extends MessageHandler {
	
	private Tecnico tecnico;
	private PrintWriter out;
	
	public TecnicoController(Message mensagem, Socket connexao, Tecnico tecnico) throws IOException {
		super(mensagem, connexao);
		this.tecnico = tecnico;
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
		if(TecnicoDatabase.tecnicos.size() > 0) {
			mensagem += TecnicoDatabase.tecnicos.size() + "\n";
			for( Tecnico tecnico : TecnicoDatabase.tecnicos) {
				mensagem += tecnico.toString() + "\n";
			}
		} else {
			mensagem = MessageHandler.SEM_PESSOAS_CADASTRADAS;
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
			Tecnico encontrado = getTecnico(this.tecnico.getCpf());
			if(encontrado != null) {
				retorno = encontrado.toString();
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
	}
	
	public static Tecnico getTecnico(String cpf) {
		Tecnico encontrado = null;
		for(Tecnico tecnico : TecnicoDatabase.tecnicos) {
			if(tecnico.getCpf().equals(cpf)) {
				encontrado = tecnico;
				break;
			}
		}
		return encontrado;
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
			TecnicoDatabase.tecnicos.add(tecnico);
			retorno = MessageHandler.PESSOA_ATUALIZADA;
		}
		out.println(SenderMessage.converteMessage(retorno));		
	}	
	
}
