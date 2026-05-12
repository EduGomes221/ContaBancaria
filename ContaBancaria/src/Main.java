import java.util.Scanner;

class ContaBancaria {
    String titular;
    int numeroConta;
    double saldo;

    public ContaBancaria(String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void mostrarDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do titular: ");
        String nome = sc.nextLine();

        System.out.print("Digite o número da conta: ");
        int numero = sc.nextInt();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numero, saldoInicial);

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Mostrar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    break;

                case 2:
                    System.out.print("Valor para saque: ");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    break;

                case 3:
                    conta.consultarSaldo();
                    break;

                case 4:
                    conta.mostrarDados();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}