package com.acctmq.activemqexample;

import java.io.Serializable;
import java.util.logging.Logger;

public class Veiculo implements Serializable {

    public static final Logger LOG = Logger.getLogger(Veiculo.class.getName());
    private String nomeCliente;
    private String marcaVeiculo;
    private double valorVenda;
    private int  ano;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
