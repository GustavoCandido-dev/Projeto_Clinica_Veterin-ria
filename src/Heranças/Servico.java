package Heranças;

import Interface.Clinica;

public abstract class Servico implements Clinica {
    protected String nome;
    protected String pacote;
    protected String porte;
    protected double valor;

    public Servico(String nome, String porte) {
        this.nome = nome;
        this.porte = porte;
    }

    @Override
    public void cadastrar() {

    }

    @Override
    public void notificar() {

    }
}
