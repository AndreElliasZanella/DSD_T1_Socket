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
    private List<Pessoa> elenco;

    public TimeFutebol(String nome, int categoria, String estadio) {
        this.nome = nome;
        this.categoria = categoria;
        this.estadio = estadio;
        this.elenco = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TimeFutebol{" + "nome=" + nome + ", categoria=" + categoria + ", estadio=" + estadio + ", elenco=" + elenco + '}';
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

    public List<Pessoa> getElenco() {
        return elenco;
    }

    public void addPessoa(Pessoa p) {
        this.elenco.add(p);
    }
    
}
