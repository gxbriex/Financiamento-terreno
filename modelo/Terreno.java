package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {

    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularValorJuros() {
        // Implementação específica para calcular os juros para um terreno
        // Pode ser algo diferente, dependendo das regras específicas para terrenos
        return 0.0; // Substitua com a lógica correta
    }

    @Override
    public double getValorFinanciado() {
        // Cálculo do valor total financiado para um terreno
        return 0.0; // Substitua com a lógica correta
    }

    @Override
    public String obterAtributosEspecificos() {
        return "Tipo de Zona: " + tipoZona;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.println("Tipo de Imóvel: Terreno");
        System.out.println(obterAtributosEspecificos());
    }
}
