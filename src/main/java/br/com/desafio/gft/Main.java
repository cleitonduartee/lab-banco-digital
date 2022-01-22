package br.com.desafio.gft;

import br.com.desafio.gft.model.entity.Cliente;
import br.com.desafio.gft.model.entity.Conta;
import br.com.desafio.gft.model.entity.ContaCorrente;
import br.com.desafio.gft.model.entity.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Cliente cleiton = new Cliente();
        cleiton.setNome("Cleiton");

        Conta cc = new ContaCorrente(cleiton);
        Conta poupanca = new ContaPoupanca(cleiton);

        cc.depositar(50);
        cc.transferir(100, poupanca);
        cc.depositar(50);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
