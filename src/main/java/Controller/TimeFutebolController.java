package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Database.TimeFutebolDatabase;
import Model.TimeFutebol;
import Model.Jogador;
import Model.Message;
import Model.Pessoa;
import Model.Tecnico;
import util.SenderMessage;

public class TimeFutebolController extends MessageHandler {
	private TimeFutebol time;
	private PrintWriter out;
	public TimeFutebolController(Message mensagem, Socket connexao, TimeFutebol time) throws IOException {
		super(mensagem, connexao);
		this.time = time;
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
		if(TimeFutebolDatabase.times.size() > 0) {
			mensagem += TimeFutebolDatabase.times.size() + "\n";
			for (TimeFutebol time : TimeFutebolDatabase.times) {
				mensagem += time.toString() + "\n";
			}
		} else {
			mensagem = MessageHandler.SEM_TIMES_CADASTRADAS;
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
			TimeFutebol encontrado = getTime(this.time);
			if(encontrado != null) {
				retorno = encontrado.toString();
			}
		}
		out.println(SenderMessage.converteMessage(retorno));
		
	}
	
	public TimeFutebol getTime(TimeFutebol time) {
		TimeFutebol encontrado = null;
		for(TimeFutebol umTime : TimeFutebolDatabase.times) {
			if(umTime.getNome().equals(time.getNome())) {
				encontrado = time;
				break;
			}
		}
		return encontrado;
	}

	@Override
	public void update() {
		String retorno = this.update(this.time);
		out.println(SenderMessage.converteMessage(retorno));
	}
	
	private String update(TimeFutebol time) {
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
			TimeFutebolDatabase.times.add(this.time);
			retorno = MessageHandler.TIME_ATUALIZADO;
		}
		return retorno;
	}

	@Override
	public void addJogadorAoTime() {
		String mensagem = addPessoaAoTime(this.mensagem.getJogador());
		out.println(SenderMessage.converteMessage(mensagem));
	}

	@Override
	public void addTecnicoAoTime() {
		String mensagem = this.addPessoaAoTime(this.mensagem.getTecnico());
		out.println(SenderMessage.converteMessage(mensagem));
	}
	
	private String addPessoaAoTime(Pessoa pessoa) {
		String mensagem = MessageHandler.TIME_NAO_ENCONTRADO;
		if (this.time != null) {
			TimeFutebol t = this.getTime(this.time);
			if (t != null) {
				if (pessoa == null) {
					mensagem = MessageHandler.PESSOA_NAO_ENCONTRADA;
				} else {
					var obj = pessoa.getClass();
					if (obj.equals(Jogador.class)) {
						mensagem = addJogador(pessoa, t, mensagem);
					} else {
						mensagem = addTecnico(pessoa, t, mensagem);
					}
				}
			}
		}
		return mensagem;
	}
	
	private String addTecnico(Pessoa pessoa, TimeFutebol time, String mensagem) {
		Tecnico encontrado = TecnicoController.getTecnico(pessoa.getCpf());
		if(encontrado != null) {
			time.setTecnico(encontrado);
			this.update(time);
			mensagem = MessageHandler.TIME_ATUALIZADO;
		}
		return mensagem;
	}
	
	private String addJogador(Pessoa pessoa, TimeFutebol time, String mensagem) {
		Jogador encontrado = JogadorController.getJogador(pessoa.getCpf());
		if(encontrado != null) {
			time.addJogador(encontrado);
			this.update(time);
			mensagem = MessageHandler.TIME_ATUALIZADO;
		}
		return mensagem;
	}
}
