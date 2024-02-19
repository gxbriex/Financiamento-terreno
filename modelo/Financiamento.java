package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularValorJuros();

    public abstract double getValorFinanciado();

    public double calcularValorParcela() {
        double valorImovel = getValorImovel();
        double taxaJurosAnual = getTaxaJurosAnual() / 100.0;
        int prazoFinanciamento = getPrazoFinanciamento();

        // Cálculo do valor total financiado
        return (valorImovel * (taxaJurosAnual / 12) * prazoFinanciamento) / (prazoFinanciamento * 12);
    }

    public abstract String obterAtributosEspecificos();

    public void mostrarDadosFinanciamento() {
        System.out.println("Dados do Financiamento:");
        System.out.println("Valor do Imóvel: R$" + valorImovel);
        System.out.println("Prazo do Financiamento: " + prazoFinanciamento + " anos");
        System.out.println("Taxa de Juros Anual: " + taxaJurosAnual + "%");
    }
}
