import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Eu, Lucca Ribeiro Zogbi, possuo matrícula 9855 - GET. Acabei adicionando os valores diretos, somados com a minha matrícula. Fiquei com preguiça de criar uma variável e trocar tudo ;)
        // Declarações para funcionamento do código
        Scanner sc = new Scanner(System.in);

        // Declarações Gerais - Computador 1
        Computador p1 = new Computador("Apple", 9855, "Linux Ubuntu", 32); // Parâmetros definidos pelo construtor (Foi instanciado a variável "hardwares" também)
        p1.hardwares[0] = new HardwareBasico("Pentium Core i3", 2200);  // Capacidade em Mhz
        p1.hardwares[1] = new HardwareBasico("Memória RAM", 8); // Capacidade em Gb
        p1.hardwares[2] = new HardwareBasico("HD", 500);    // Capacidade em Gb
        p1.memoriaUSB = new MemoriaUSB("Pen-drive", 16);    // Capacidade em Gb

        // Declarações gerais - p2
        Computador p2 = new Computador("Samsung", 11089, "Windows 8", 64);
        p2.hardwares[0] = new HardwareBasico("Pentium Core i5", 3370);
        p2.hardwares[1] = new HardwareBasico("Memória RAM", 16);
        p2.hardwares[2] = new HardwareBasico("HD", 1000);
        p2.sistema = new SistemaOperacional("Windows 8", 64);
        p2.memoriaUSB = new MemoriaUSB("Pen-drive", 32);

        // Declarações gerais - p3
        Computador p3 = new Computador("Dell", 15533, "Windows 10", 64);
        p3.hardwares[0] = new HardwareBasico("Pentium Core i7", 4500);
        p3.hardwares[1] = new HardwareBasico("Memória RAM", 32);
        p3.hardwares[2] = new HardwareBasico("HD", 2000);
        p3.sistema = new SistemaOperacional("Windows 10", 64);
        p3.memoriaUSB = new MemoriaUSB("HD Externo", 1000);

        // Declarações Usuário
        Cliente cliente = new Cliente("Lucca", 10203040506070L, 3);

        // Interface com o usuário
        int indexcompra = 0;
        boolean sair = false;   // Variável de controle para permanecer no loop

        while(!sair && indexcompra < 3) { // Multiplicação das duas condições dentro do parênteses
            System.out.println("Qual PC da promoção você deseja comprar? (1,2,3): ");
            int pcEscolhido = sc.nextInt();

            Computador escolhido = null; // Variável 'escolhido' aponta para NADA
            switch(pcEscolhido) {
                case 1:
                    escolhido = p1; // Variável 'escolhido' aponta para o PC 1
                    break;
                case 2:
                    escolhido = p2; // Variável 'escolhido' aponta para o PC 2
                    break;
                case 3:
                    escolhido = p3; // Variável 'escolhido' aponta para o PC 3
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if(escolhido != null) {
                cliente.computadoresComprados[indexcompra] = escolhido; // Adiciona o computador no "carrinho de compras" do cliente
                indexcompra++;
                System.out.println("Computador adicionado ao carrinho: ");
                escolhido.mostraPCConfigs();
            }

            System.out.println("Deseja continuar? [S/N]: ");
            String resposta = sc.next();
            if(resposta.equalsIgnoreCase("N")){ // Analisa o caractere, ignorando letra maiscula/minuscula
                sair = true;
            }
            // Saí do loop se entrar na condição acima, ou se 'indexcompra' passar a valer 3
        }

        System.out.println("\nResumo da compra de " + cliente.nome + ": ");
        for (int i = 0; i < indexcompra; i++){ // Sempre será 3 o 'indexcompra'
            System.out.println("\nComputador " + (i + 1) + ": ");
            cliente.computadoresComprados[i].mostraPCConfigs();
        }

        // Mostra o preço total das compras.
        System.out.println("\nTotal da compra: R$ " + cliente.calculaTotalCompra());
        sc.close();
    }
}