package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EntradaUsuario {

    private static final String CAMINHO_ARQUIVO = "entradasUsuario.txt";

    public static void salvarEntradasEmArquivo(double valorImovel, int prazoFinanciamento, double taxaJuros, String tipoImovel) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            writer.println("Valor do Imóvel: " + valorImovel);
            writer.println("Prazo do Financiamento: " + prazoFinanciamento + " anos");
            writer.println("Taxa de Juros Anual: " + taxaJuros + "%");
            writer.println("Tipo de Imóvel: " + tipoImovel);
            writer.println("---------------------");
            System.out.println("Entradas do usuário salvas em " + CAMINHO_ARQUIVO + " com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
