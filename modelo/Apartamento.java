package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {

    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public double calcularValorJuros() {
        // Implementação específica para calcular os juros para um apartamento
        // Pode ser algo diferente, dependendo das regras específicas para apartamentos
        return 0.0; // Substitua com a lógica correta
    }

    @Override
    public double getValorFinanciado() {
        // Cálculo do valor total financiado para um apartamento
        return 0.0; // Substitua com a lógica correta
    }

    @Override
    public String obterAtributosEspecificos() {
        return "Número de Vagas na Garagem: " + numeroVagasGaragem + ", Número do Andar: " + numeroAndar;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.println("Tipo de Imóvel: Apartamento");
        System.out.println(obterAtributosEspecificos());
    }
}
