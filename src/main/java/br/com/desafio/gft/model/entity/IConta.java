package br.com.desafio.gft.model.entity;

public interface IConta {
    public void sacar(double valor);
    public void depositar(double valor);
    public void transferir(double valor, IConta contaDestino);
    void imprimirExtrato();
}
