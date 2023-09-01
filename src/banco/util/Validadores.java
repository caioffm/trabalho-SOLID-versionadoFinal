package banco.util;

public class Validadores {

    public static boolean validarCPF(String cpf) {
        // Implementar lógica de validação de CPF
        return true;
    }

    public static boolean validarValor(double valor) {
        return valor >= 0;
    }

    public static boolean validarSenha(int senha) {
        return String.valueOf(senha).length() == 4;
    }
}
