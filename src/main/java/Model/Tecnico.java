/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author andreellias18
 */
public class Tecnico extends Pessoa{
    
    private int anosDeExperiencia;
    private int licensa;

    public Tecnico(int anosDeExperiencia, int licensa, String cpf, String nome, String endereco, String contato, int idade) {
        super(cpf, nome, endereco, contato, idade);
        this.anosDeExperiencia = anosDeExperiencia;
        this.licensa = licensa;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "nome=" + super.getNome() + "anosDeExperiencia=" + anosDeExperiencia + ", licensa=" + licensa + '}';
    }

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public int getLicensa() {
        return licensa;
    }

    public void setLicensa(int licensa) {
        this.licensa = licensa;
    }
    
}
