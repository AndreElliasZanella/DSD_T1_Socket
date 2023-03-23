/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andreellias18
 */
public class TimeFutebol {
    
    private String nome;
    private int categoria;
    private String estadio;
    private List<Jogador> elenco;
    private Tecnico tecnico;

    public TimeFutebol() {
    }
    
    public TimeFutebol(String nome, int categoria, String estadio) {
        this.nome = nome;
        this.categoria = categoria;
        this.estadio = estadio;
        this.elenco = new ArrayList<>();
    }

	@Override
	public String toString() {
		String jogadores = "\nJogadores=\n";
		if (elenco.size() > 0) {
			for (Jogador jogador : elenco) {
				jogadores += "* " + jogador.toString() + "\n";
			}
		} else {
			jogadores += "Em escalação";
		}
		return "# Nome do time= " + nome + "; Categoria= " + categoria + "; Estadio= " + estadio // 
				+ "\nTécnico= " + tecnico != null ? tecnico.getNome() : "A contratar" //
				+ jogadores;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public List<Jogador> getElenco() {
        return elenco;
    }
    
    public void addJogador(Jogador jogador) {
    	this.elenco.add(jogador);
    }

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
    
}
