import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoeda conversor = new ConversorMoeda();

        int opcao = 0;
        double valor = 0.0;
        

        while (opcao != 7) {
            System.out.println("*******************************************");
            System.out.println(" Seja bem-vindo(a) ao Conversor Nallrranna de Moeda!");
            System.out.println("*******************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Dólar => Real brasileiro");
            System.out.println("3) Real => Dólar");
            System.out.println("4) Dólar => Peso colombiano");
            System.out.println("5) Peso colombiano => Dólar");
            System.out.println("6) Outro");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor em USD: ");
                    valor = scanner.nextDouble();
                    conversor.consultar("USD", "ARS", valor);
                }
                case 2 -> {
                    System.out.print("Digite o valor em USD: ");
                    valor = scanner.nextDouble();
                    conversor.consultar("USD", "BRL", valor);
                }
                case 3 -> {
                    System.out.print("Digite o valor em BRL: ");
                    valor = scanner.nextDouble();
                    conversor.consultar("BRL", "USD", valor);
                }
                case 4 -> {
                    System.out.print("Digite o valor em USD: ");
                    valor = scanner.nextDouble();
                    conversor.consultar("USD", "COP", valor);
                }
                case 5 -> {
                    System.out.print("Digite o valor em COP: ");
                    valor = scanner.nextDouble();
                    conversor.consultar("COP", "USD", valor);
                }
                case 6 -> {
                    System.out.print("Moeda de origem (ex: USD): ");
                    String origem = scanner.next().toUpperCase();
                    System.out.print("Moeda de destino (ex: EUR): ");
                    String destino = scanner.next().toUpperCase();
                    System.out.print("Digite o valor: ");
                    valor = scanner.nextDouble();
                    conversor.consultar(origem, destino, valor);
                }
                case 7 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
