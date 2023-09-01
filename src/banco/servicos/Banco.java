// Importação das classes e pacotes necessários
package banco.servicos;

import banco.modelo.Cliente;
import banco.modelo.Conta;
import banco.modelo.ContaCorrente;
import banco.modelo.ContaPoupanca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
// Definição da classe Banco que oferece serviços bancários
public class Banco {
    // Declaração de atributos privados da classe
    private HashMap<String, List<Conta>> contas = new HashMap<>();
    private List<Cliente> clientes = new ArrayList<>();

    // Método para obter um cliente com base no CPF
    public Cliente getClientePorCpf(String cpf) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    // Métodos para cadastrar cliente pessoa física
    public void cadastrarClientePessoaFisica() {
        Scanner scanner = new Scanner(System.in);
        Cliente novoCliente = new Cliente();
        System.out.print("\n\nDigite o nome do cliente: ");
        novoCliente.setNome(scanner.nextLine());
        System.out.print("Digite o CPF do cliente: ");
        novoCliente.setCpf(scanner.nextLine());
        this.clientes.add(novoCliente);
    }
    // Métodos para cadastrar conta corrente
    public void cadastrarContaCorrente(Cliente cliente, int agencia) {
        Scanner sc = new Scanner(System.in);
        int senha = obterSenha(sc);
        ContaCorrente contaCorrente = new ContaCorrente(cliente, agencia, senha);
        adicionaConta(cliente, contaCorrente);
        System.out.println("Conta Corrente cadastrada com sucesso!");
        System.out.println("Número da conta: " + contaCorrente.getNumeroConta());
    }
    // Métodos para cadastrar conta poupança
    public void cadastrarContaPoupanca(Cliente cliente, int agencia) {
        Scanner sc = new Scanner(System.in);
        int senha = obterSenha(sc);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, agencia, senha);
        adicionaConta(cliente, contaPoupanca);
        System.out.println("Conta Poupança cadastrada com sucesso!");
        System.out.println("Número da conta: " + contaPoupanca.getNumeroConta());
    }

    // Método para obter uma senha válida
    private int obterSenha(Scanner sc) {
        int senha;
        do {
            System.out.print("Digite a senha (4 dígitos):");
            senha = sc.nextInt();
        } while (senha < 1000 || senha > 9999);
        return senha;
    }
    // Método para adicionar uma conta à lista de contas de um cliente
    private void adicionaConta(Cliente cliente, Conta conta) {
        List<Conta> contasDoCliente = contas.getOrDefault(cliente.getCpf(), new ArrayList<>());
        contasDoCliente.add(conta);
        contas.put(cliente.getCpf(), contasDoCliente);
    }
    // Métodos para efetuar depósito
    public void efetuarDeposito() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nInforme o CPF do cliente: ");
        String cpf = sc.nextLine();

        List<Conta> contasDoCliente = contas.getOrDefault(cpf, new ArrayList<>());
        if (contasDoCliente.isEmpty()) {
            System.out.println("Cliente não possui contas.");
            return;
        }

        System.out.print("Informe o tipo de conta (1 para Conta-Corrente, 2 para Poupança): ");
        int tipoConta = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe a agência: ");
        int agencia = sc.nextInt();

        System.out.print("Informe o número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = null;
        for (Conta c : contasDoCliente) {
            if (((tipoConta == 1 && c instanceof ContaCorrente) || (tipoConta == 2 && c instanceof ContaPoupanca))
                    && c.getAgencia() == agencia && c.getNumeroConta() == numeroConta) {
                conta = c;
                break;
            }
        }

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Informe o valor do depósito: ");
        double valor = sc.nextDouble();

        System.out.print("Informe a senha: ");
        int senha = sc.nextInt();

        if (conta.efetuarDeposito(valor, senha)) {
            System.out.println("Depósito efetuado com sucesso!");
        } else {
            System.out.println("Falha ao efetuar o depósito.");
        }
    }


    // Métodos para efetuar saque
    public void efetuarSaque() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nInforme o CPF do cliente: ");
        String cpf = sc.nextLine();

        List<Conta> contasDoCliente = contas.getOrDefault(cpf, new ArrayList<>());
        if (contasDoCliente.isEmpty()) {
            System.out.println("Cliente não possui contas.");
            return;
        }

        System.out.print("Informe o tipo de conta (1 para Conta-Corrente, 2 para Poupança): ");
        int tipoConta = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe a agência: ");
        int agencia = sc.nextInt();

        System.out.print("Informe o número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = null;
        for (Conta c : contasDoCliente) {
            if (((tipoConta == 1 && c instanceof ContaCorrente) || (tipoConta == 2 && c instanceof ContaPoupanca))
                    && c.getAgencia() == agencia && c.getNumeroConta() == numeroConta) {
                conta = c;
                break;
            }
        }

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Informe o valor do saque: ");
        double valor = sc.nextDouble();

        System.out.print("Informe a senha: ");
        int senha = sc.nextInt();

        if (conta.efetuarSaque(valor, senha)) {
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Falha ao efetuar o saque.");
        }
    }
    // Métodos para efetuar transferência
    public void efetuarTransferencia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nInforme o CPF do cliente de origem: ");
        String cpfOrigem = sc.nextLine();

        System.out.print("Informe o CPF do cliente de destino: ");
        String cpfDestino = sc.nextLine();

        List<Conta> contasOrigem = contas.getOrDefault(cpfOrigem, new ArrayList<>());
        List<Conta> contasDestino = contas.getOrDefault(cpfDestino, new ArrayList<>());

        if (contasOrigem.isEmpty() || contasDestino.isEmpty()) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Informe o tipo de conta de origem (1 para Conta-Corrente, 2 para Poupança): ");
        int tipoContaOrigem = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o tipo de conta de destino (1 para Conta-Corrente, 2 para Poupança): ");
        int tipoContaDestino = sc.nextInt();
        sc.nextLine();

        Conta contaOrigem = selecionarContaPorTipo(contasOrigem, tipoContaOrigem);
        Conta contaDestino = selecionarContaPorTipo(contasDestino, tipoContaDestino);

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        System.out.print("Informe o valor da transferência: ");
        double valor = sc.nextDouble();

        System.out.print("Informe a senha da conta de origem: ");
        int senha = sc.nextInt();

        if (Transferencia.efetuarTransferencia(contaOrigem, contaDestino, valor, senha)) {
            System.out.println("Transferência efetuada com sucesso!");

            // Exibir o saldo das contas após a transferência
            exibirSaldoDepoisTransferencia(contaOrigem, contaDestino);
        } else {
            System.out.println("Falha ao efetuar a transferência.");
        }
    }

    // Método para selecionar uma conta por tipo (conta corrente ou poupança)
    private Conta selecionarContaPorTipo(List<Conta> contas, int tipo) {
            for (Conta c : contas) {
                if ((tipo == 1 && c instanceof ContaCorrente) || (tipo == 2 && c instanceof ContaPoupanca)) {
                    return c;
                }
            }
            return null;
        }

    // Método para exibir o saldo de contas de um cliente
    public void exibirSaldo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nInforme o CPF do cliente: ");
        String cpf = sc.nextLine();

        List<Conta> contasDoCliente = contas.getOrDefault(cpf, new ArrayList<>());
        if (contasDoCliente.isEmpty()) {
            System.out.println("Conta não encontrada.");
            return;
        }

        for (Conta conta : contasDoCliente) {
            if (conta instanceof ContaCorrente) {
                // Se for uma Conta Corrente, exibe o saldo dessa conta corrente
                ContaCorrente contaCorrente = (ContaCorrente) conta; // Cast para ContaCorrente
                System.out.println("Saldo da Conta Corrente: " + contaCorrente.getSaldo());
            } else if (conta instanceof ContaPoupanca) {
                // Se for uma Conta Poupança, exibe o saldo dessa conta poupança
                ContaPoupanca contaPoupanca = (ContaPoupanca) conta; // Cast para ContaPoupanca
                System.out.println("Saldo da Conta Poupança: " + contaPoupanca.getSaldo());
            } else {
                // Caso seja um tipo de conta desconhecido (o que não deveria acontecer)
                System.out.println("Tipo de conta desconhecido.");
            }
        }
    }

    // Método para exibir o saldo após uma transferência
        public void exibirSaldoDepoisTransferencia(Conta contaOrigem, Conta contaDestino) {
            if (contaOrigem != null) {
                System.out.println("\n\nSaldo da conta origem após a transferência: " + contaOrigem.getSaldo());
            }
            if (contaDestino != null) {
                System.out.println("Saldo da conta destino após a transferência: " + contaDestino.getSaldo());
            }

        }
    }