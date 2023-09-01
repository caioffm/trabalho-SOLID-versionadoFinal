package banco.servicos;
// Importação da classe Cliente do pacote modelo
import banco.modelo.Cliente;

// Importação da classe Scanner para entrada de dados
import java.util.Scanner;

// Definição da classe Menu que exibe as opções do menu e permite interações
public class Menu {

    // Método para exibir o menu e permitir interações
    public void exibirMenu() {
        // Criação de um objeto Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);
        // Criação de um objeto Banco para realizar operações bancárias
        Banco banco = new Banco();

        // Loop infinito para manter o menu em execução
        while (true) {
            // Exibe as opções do menu
            System.out.println("\n\nEscolha uma opção:");
            System.out.println("1: Cadastrar Cliente Pessoa Física");
            System.out.println("2: Cadastrar Conta Corrente");
            System.out.println("3: Cadastrar Conta Poupança");
            System.out.println("4: Efetuar Depósito");
            System.out.println("5: Efetuar Saque");
            System.out.println("6: Efetuar Transferência");
            System.out.println("7: Exibir Saldo");
            System.out.println("0: Sair");
            System.out.print("Digite:");

            // Lê a escolha do usuário
            int escolha = scanner.nextInt();

            // Executa a ação correspondente à escolha do usuário
            switch (escolha) {
                case 1:
                    banco.cadastrarClientePessoaFisica();
                    break;
                case 2:
                    // Solicita o CPF do cliente e busca o cliente correspondente
                    System.out.print("\n\nInforme o CPF do cliente para criar uma Conta Corrente:");
                    String cpfCorrente = scanner.next();
                    Cliente clienteCorrente = banco.getClientePorCpf(cpfCorrente);
                    if (clienteCorrente != null) {
                        // Solicita a agência e cadastra a Conta Corrente
                        System.out.print("Informe a agência:");
                        int agenciaCorrente = scanner.nextInt();
                        banco.cadastrarContaCorrente(clienteCorrente, agenciaCorrente);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 3:
                    // Solicita o CPF do cliente e busca o cliente correspondente
                    System.out.print("\n\nInforme o CPF do cliente para criar uma Conta Poupança:");
                    String cpfPoupanca = scanner.next();
                    Cliente clientePoupanca = banco.getClientePorCpf(cpfPoupanca);
                    if (clientePoupanca != null) {
                        // Solicita a agência e cadastra a Conta Poupança
                        System.out.print("Informe a agência:");
                        int agenciaPoupanca = scanner.nextInt();
                        banco.cadastrarContaPoupanca(clientePoupanca, agenciaPoupanca);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    // Chama o método para efetuar um depósito
                    banco.efetuarDeposito();
                    break;
                case 5:
                    // Chama o método para efetuar um saque
                    banco.efetuarSaque();
                    break;
                case 6:
                    // Chama o método para efetuar uma transferência
                    banco.efetuarTransferencia();
                    break;
                case 7:
                    // Chama o método para exibir o saldo
                    banco.exibirSaldo();
                    break;
                case 0:
                    // Encerra o programa
                    System.out.println("Saindo...");
                    System.exit(1);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
