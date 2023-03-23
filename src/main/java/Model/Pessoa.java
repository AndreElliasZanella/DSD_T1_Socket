/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author andreellias18
 */
public abstract class Pessoa {
    
    private String cpf;
    private String nome;
    private String endereco;
    private String contato;
    private int idade;

    public Pessoa(String cpf, String nome, String endereco, String contato, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.idade = idade;
    }

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Cpf= " + cpf + "; Nome= " + nome + "; Endereco= " + endereco + "; Contato= " + contato + "; Idade=" + idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
