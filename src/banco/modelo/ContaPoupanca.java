package banco.modelo;
// Definição da classe ContaPoupanca que herda da classe Conta
public class ContaPoupanca extends Conta {

    // Construtor da classe ContaPoupanca
    public ContaPoupanca(Cliente cliente, int agencia, int senha) {
        super(cliente, agencia, senha);  // Chama o construtor da classe pai (Conta)
    }

    // Sobrescrita do método sacar da classe pai (Conta)
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;  // Atualiza o saldo da conta após o saque
    }
}
