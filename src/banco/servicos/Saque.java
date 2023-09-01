package banco.servicos;

// Importação da classe Conta do pacote modelo
import banco.modelo.Conta;

// Definição da classe Saque que contém um método estático para efetuar saques em uma conta
public class Saque {

    // Método estático para efetuar um saque em uma conta
    public static boolean efetuarSaque(Conta conta, double valor, int senha) {
        // Verifica se a senha informada corresponde à senha da conta e se o valor do saque é válido
        if (conta.getSenha() == senha && valor > 0 && conta.getSaldo() >= valor) {
            // Atualiza o saldo da conta após o saque
            conta.setSaldo(conta.getSaldo() - valor);
            return true; // Retorna true indicando que o saque foi realizado com sucesso
        }
        return false; // Retorna false indicando que o saque não pôde ser realizado
    }
}

