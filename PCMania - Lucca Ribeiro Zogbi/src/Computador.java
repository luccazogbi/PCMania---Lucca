public class Computador {

    // Atributos
    String marca;
    float preco;
    SistemaOperacional sistema;
    MemoriaUSB memoriaUSB;
    public HardwareBasico[] hardwares;

    // Métodos
    void mostraPCConfigs(){

        // Mostrando marca do PC
        System.out.println("Marca: " + marca);

        // Mostrando preço do PC
        System.out.println("Preco: " + preco);

        // Mostrando Hardwares do PC
        for (int i = 0 ; i < hardwares.length ; i++){
            if(i == 0){
                System.out.println("Hardware: " + hardwares[i].nome + " - " + hardwares[i].capacidade + " Mhz");
            }
            else{
                System.out.println("Hardware: " + hardwares[i].nome + " - " + hardwares[i].capacidade + " Gb");
            }
        }

        // Mostrando sistema operacional do PC
        System.out.println("Sistema Operacional: " + sistema.nome + " (" + sistema.tipo + " bits)");

        // Mostrando a memória acompanhada do PC
        if (memoriaUSB != null){
            System.out.println("Memoria USB: " + memoriaUSB.nome + " - " +memoriaUSB.capacidade + " Gb");
        }
    }

    void addMemoriaUSB(MemoriaUSB musb){
        this.memoriaUSB = musb;
    }

    // Associações - Construtor
    public Computador(String marca, float preco, String NomeSistema, int tipoSistema){
        this.marca = marca;
        this.preco = preco;

        // Composição
        sistema = new SistemaOperacional(NomeSistema, tipoSistema);
        hardwares = new HardwareBasico[3];
    }
}
