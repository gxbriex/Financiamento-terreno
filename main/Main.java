package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean continuarCalculando = true;

        do {
            System.out.println("Informe os dados para um novo Financiamento:");

            double valorImovel = InterfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
            double taxaJuros = InterfaceUsuario.pedirTaxaJuros();

            System.out.println("Escolha o tipo de imóvel (Casa, Apartamento, Terreno): ");
            String tipoImovel = scanner.next();

            Financiamento financiamento;

            switch (tipoImovel.toLowerCase()) {
                case "casa":
                    double areaConstruida = InterfaceUsuario.pedirAreaConstruida();
                    double tamanhoTerreno = InterfaceUsuario.pedirTamanhoTerreno();
                    financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, tamanhoTerreno);
                    break;

                case "apartamento":
                    double numeroVagasGaragem = InterfaceUsuario.pedirNumeroVagasGaragem();
                    double numeroAndar = InterfaceUsuario.pedirNumeroAndar();
                    financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, (int) numeroVagasGaragem, (int) numeroAndar);
                    break;

                case "terreno":
                    String tipoZona = InterfaceUsuario.pedirTipoZona();
                    financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJuros, tipoZona);
                    break;

                default:
                    System.out.println("Tipo de imóvel inválido. Tente novamente.");
                    continue;
            }

            financiamentos.add(financiamento);

            System.out.print("Deseja calcular mais um financiamento? (sim/não): ");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase("não")) {
                continuarCalculando = false;
            }
        } while (continuarCalculando);

        // Salvar os dados em um arquivo de texto
        System.out.print("Digite o caminho completo do arquivo para salvar os dados em texto (ex: C:\\caminho\\arquivo.txt): ");
        String caminhoArquivoTxt = scanner.next();
        salvarDadosEmArquivoTexto(financiamentos, caminhoArquivoTxt);

        // Salvar os dados serializados em um arquivo
        System.out.print("Digite o caminho completo do arquivo para salvar os dados serializados (ex: C:\\caminho\\arquivo.ser): ");
        String caminhoArquivoSer = scanner.next();
        salvarDadosSerializados(financiamentos, caminhoArquivoSer);

        // Fechar o Scanner apenas quando não for mais necessário
        scanner.close();

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        System.out.println("Detalhes dos Financiamentos:");

        for (Financiamento financiamento : financiamentos) {
            financiamento.mostrarDadosFinanciamento();

            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.getValorFinanciado();

            System.out.println("---------------------");
        }

        System.out.println("Total de todos os imóveis: R$" + totalValorImoveis);
        System.out.println("Total de todos os financiamentos: R$" + totalValorFinanciamentos);
    }

    private static void salvarDadosEmArquivoTexto(ArrayList<Financiamento> financiamentos, String caminhoArquivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                writer.println("Tipo de Imóvel: " + financiamento.getClass().getSimpleName());
                writer.println("Valor do Imóvel: R$" + financiamento.getValorImovel());
                writer.println("Prazo do Financiamento: " + financiamento.getPrazoFinanciamento() + " anos");
                writer.println("Taxa de Juros Anual: " + financiamento.getTaxaJurosAnual() + "%");
                writer.println(financiamento.obterAtributosEspecificos());
                writer.println("---------------------");
            }
            System.out.println("Dados salvos em " + caminhoArquivo + " com sucesso.");
        } catch (IOException e) {
        e.printStackTrace();
    }
}

    private static void salvarDadosSerializados(ArrayList<Financiamento> financiamentos, String caminhoArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            outputStream.writeObject(financiamentos);
            System.out.println("Dados serializados salvos em " + caminhoArquivo + " com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
