package br.com.desafio.gft.model.entity;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRA = 1;
    private static final int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRA;
        this.numero = SEQUENCIAL;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(possuiSaldoDisponivel(valor)){
            this.saldo -= valor;
        }else{
            throw new IllegalArgumentException("Saldo insuficiente. Saldo em Conta: "+this.saldo);
        }

    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        try{
            this.sacar(valor);
            contaDestino.depositar(valor);
        }catch (IllegalArgumentException e ){
            System.out.println(e.getMessage());
        }

    }

    private boolean possuiSaldoDisponivel(double valor){
        return this.saldo >= valor;
    }
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
