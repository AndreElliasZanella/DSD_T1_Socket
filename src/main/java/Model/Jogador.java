/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author andreellias18
 */
public class Jogador extends Pessoa{
    
    private int numeroDaCamisa;
    private int posicao;

    public Jogador() {
    }
    
    public Jogador(int numeroDaCamisa, int posicao, String cpf, String nome, String endereco, String contato, int idade) {
        super(cpf, nome, endereco, contato, idade);
        this.numeroDaCamisa = numeroDaCamisa;
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return super.toString() + "Camisa= "+numeroDaCamisa +"; Posição= " + posicao;
    }

    public int getNumeroDaCamisa() {
        return numeroDaCamisa;
    }

    public void setNumeroDaCamisa(int numeroDaCamisa) {
        this.numeroDaCamisa = numeroDaCamisa;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
}
