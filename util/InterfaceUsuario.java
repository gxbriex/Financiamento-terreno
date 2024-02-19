package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    private static Scanner scanner = new Scanner(System.in);

    private static double validarValorPositivo(String mensagem) throws InputMismatchException {
        double valor;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("O valor deve ser positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
                scanner.next(); // Limpar o buffer do scanner
                valor = -1; // Definir um valor inválido para continuar o loop
            }
        } while (valor <= 0);
        return valor;
    }

    public static double pedirValorImovel() throws InputMismatchException {
        return validarValorPositivo("Digite o valor do imóvel: R$");
    }

    public static int pedirPrazoFinanciamento() throws InputMismatchException {
        int prazo;
        do {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                prazo = scanner.nextInt();
                if (prazo <= 0) {
                    System.out.println("O prazo deve ser um valor positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico inteiro.");
                scanner.next(); // Limpar o buffer do scanner
                prazo = -1; // Definir um valor inválido para continuar o loop
            }
        } while (prazo <= 0);
        return prazo;
    }

    public static double pedirTaxaJuros() throws InputMismatchException {
        double taxa;
        do {
            try {
                System.out.print("Digite a taxa de juros anual (%): ");
                taxa = scanner.nextDouble();
                if (taxa <= 0) {
                    System.out.println("A taxa de juros deve ser positiva. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico.");
                scanner.next(); // Limpar o buffer do scanner
                taxa = -1; // Definir um valor inválido para continuar o loop
            }
        } while (taxa <= 0);
        return taxa;
    }

    // Novos métodos para dados específicos de cada tipo de imóvel
    public static double pedirAreaConstruida() throws InputMismatchException {
        return validarValorPositivo("Digite a área construída do imóvel: ");
    }

    public static double pedirTamanhoTerreno() throws InputMismatchException {
        return validarValorPositivo("Digite o tamanho do terreno do imóvel: ");
    }

    public static int pedirNumeroVagasGaragem() throws InputMismatchException {
        return (int) validarValorPositivo("Digite o número de vagas na garagem do apartamento: ");
    }

    public static int pedirNumeroAndar() throws InputMismatchException {
        return (int) validarValorPositivo("Digite o número do andar do apartamento: ");
    }

    public static String pedirTipoZona() {
        System.out.print("Digite o tipo de zona do terreno (exemplo: residencial, comercial): ");
        return scanner.next();
    }
}
