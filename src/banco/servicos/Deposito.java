package banco.servicos;
// Importação da classe Conta do pacote modelo
import banco.modelo.Conta;

// Definição da classe Deposito que oferece um serviço de depósito
public class Deposito {

    // Método estático para efetuar um depósito em uma conta
    public static boolean efetuarDeposito(Conta conta, double valor, int senha) {
        // Verifica se a senha informada corresponde à senha da conta e se o valor é positivo
        if(conta.getSenha() == senha && valor > 0) {
            // Incrementa o saldo da conta com o valor do depósito
            conta.setSaldo(conta.getSaldo() + valor);
            // Retorna verdadeiro para indicar que o depósito foi bem-sucedido
            return true;
        }
        // Retorna falso caso a senha ou o valor sejam inválidos
        return false;
    }
}
