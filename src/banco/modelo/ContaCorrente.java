package banco.modelo;
// Definição da classe ContaCorrente que herda da classe Conta
public class ContaCorrente extends Conta {

    // Construtor da classe ContaCorrente
    public ContaCorrente(Cliente cliente, int agencia, int senha) {
        super(cliente, agencia, senha);  // Chama o construtor da classe pai (Conta)
    }

    // Sobrescrita do método sacar da classe pai (Conta)
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        setSaldo(getSaldo() - valor);  // Atualiza o saldo da conta após o saque
    }
}
