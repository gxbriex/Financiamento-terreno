package modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    public double calcularValorJuros() {
        // Implementação específica para calcular os juros para uma casa
        // Pode ser algo diferente, dependendo das regras específicas para casas
        return 0.0; // Substitua com a lógica correta
    }

    @Override
    public double getValorFinanciado() {
        // Cálculo do valor total financiado para uma casa
        return 0.0; // Substitua com a lógica correta
    }

    @Override
    public String obterAtributosEspecificos() {
        return "Área Construída: " + areaConstruida + " metros quadrados, Tamanho do Terreno: " + tamanhoTerreno + " metros quadrados";
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.println("Tipo de Imóvel: Casa");
        System.out.println(obterAtributosEspecificos());
    }
}
