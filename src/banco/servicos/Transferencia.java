package banco.servicos;

// Importação da classe Conta do pacote modelo
import banco.modelo.Conta;

// Definição da classe Transferencia que contém um método estático para efetuar transferências entre contas
public class Transferencia {

    // Método estático para efetuar uma transferência entre contas
    public static boolean efetuarTransferencia(Conta origem, Conta destino, double valor, int senhaOrigem) {
        // Verifica se a senha da conta de origem corresponde à senha fornecida e se o valor da transferência é válido
        if (origem.getSenha() == senhaOrigem && valor > 0 && origem.getSaldo() >= valor) {
            // Chama o método efetuarSaque da classe Saque para debitar o valor da conta de origem
            Saque.efetuarSaque(origem, valor, senhaOrigem);
            // Chama o método efetuarDeposito da classe Deposito para creditar o valor na conta de destino
            Deposito.efetuarDeposito(destino, valor, destino.getSenha());
            return true; // Retorna true indicando que a transferência foi realizada com sucesso
        }
        return false; // Retorna false indicando que a transferência não pôde ser realizada
    }
}
