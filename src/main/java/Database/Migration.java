package Database;

import Model.Jogador;
import Model.Tecnico;
import Model.TimeFutebol;

public class Migration {	
	
	public Migration() {
		addJogador();
		addTecnico();
		addTime();
	}

	private void addJogador() {
		Jogador j1 = new Jogador();
		j1.setNome("Goleiro");
		j1.setContato("0956424");
		j1.setCpf("09188922952");
		j1.setEndereco("Rua Oscar Barcelos");
		j1.setIdade(22);
		j1.setNumeroDaCamisa(1);
		j1.setPosicao(1);
		
		Jogador j2 = new Jogador();
		j2.setNome("Jogador 1");
		j2.setContato("0956424");
		j2.setCpf("123456789");
		j2.setEndereco("Rua Oscar Barcelos");
		j2.setIdade(22);
		j2.setNumeroDaCamisa(2);
		j2.setPosicao(2);
		
		JogadorDatabase.jogadores.add(j1);
		JogadorDatabase.jogadores.add(j2);		
	}
	
	private void addTecnico() {
		Tecnico t1 = new Tecnico();
		t1.setNome("Jogador 1");
		t1.setContato("0956424");
		t1.setCpf("123456789");
		t1.setEndereco("Rua Oscar Barcelos");
		t1.setIdade(22);
		t1.setAnosDeExperiencia(2);
		t1.setLicensa(123);
		
		TecnicoDatabase.tecnicos.add(t1);
	}
	
	private void addTime() {
		TimeFutebol time = new TimeFutebol();
		time.setNome("Santos");
		time.setCategoria(1);
		time.setEstadio("Pacaembú");
		
		TimeFutebolDatabase.times.add(time);
	}
}
