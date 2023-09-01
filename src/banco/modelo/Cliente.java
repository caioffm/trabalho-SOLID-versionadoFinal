package banco.modelo;


// Definição da classe Cliente
public class Cliente {
    // Método para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método para definir o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter o CPF do cliente
    public String getCpf() {
        return cpf;
    }

    // Método para definir o CPF do cliente
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Atributo para armazenar o nome do cliente
    private String nome;

    // Atributo para armazenar o CPF do cliente
    private String cpf;
}
