package banco.modelo;
// Importando a classe Random para gerar números aleatórios
import java.util.Random;

// Definição da classe Conta
public class Conta {
    // Atributos da classe Conta
    protected Cliente cliente;      // Cliente associado à conta
    protected int agencia;          // Número da agência
    protected int numeroConta;      // Número da conta
    protected int senha;            // Senha da conta
    protected double saldo;         // Saldo da conta

    // Construtor da classe Conta
    public Conta(Cliente cliente, int agencia, int senha) {
        this.cliente = cliente;                       // Inicialização do cliente
        this.agencia = agencia;                       // Inicialização da agência
        this.numeroConta = new Random().nextInt(9999); // Geração aleatória do número da conta
        this.senha = senha;                           // Inicialização da senha
        this.saldo = 0;                               // Saldo inicial zerado
    }


    // Métodos de acesso para os atributos
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para realizar um depósito
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo");
        }
        this.saldo += valor;
    }

    // Método para efetuar um depósito
    public boolean efetuarDeposito(double valor, int senha) {
        if (valor < 0 || this.senha != senha) {
            return false;
        }
        this.saldo += valor;
        return true;
    }

    // Método para efetuar um saque
    public boolean efetuarSaque(double valor, int senha) {
        if (valor < 0 || this.senha != senha || this.saldo < valor) {
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    // Método para efetuar uma transferência para outra conta
    public boolean efetuarTransferencia(Conta destino, double valor, int senha) {
        if (valor < 0 || this.senha != senha || this.saldo < valor) {
            return false;
        }
        this.saldo -= valor;
        destino.saldo += valor; // Incrementa o saldo da conta de destino
        return true;
    }

    // Método para realizar um saque
    public void sacar(double valor) {
        // Implementação do saque (pode ser implementada posteriormente)
    }
}
