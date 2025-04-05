public class Cliente {
    String nome;
    long cpf;
    Computador[] computadoresComprados;

    // Construtor da classe cliente - Definindo os parâmetros que devem ser enviados na instânciação da classe
    public Cliente(String nome, long cpf, int quantidadeComprados) {
        this.nome = nome;
        this.cpf = cpf;
        computadoresComprados = new Computador[quantidadeComprados];
    }

    // Métodos da classe
    float calculaTotalCompra(){
        float total = 0;
        for (Computador computadoresComprado : computadoresComprados) {
            if (computadoresComprado != null) {
                total += computadoresComprado.preco;
            }
        }
        return total;
    }
}
