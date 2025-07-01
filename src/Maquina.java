public class Maquina {

    private boolean maquinaEstaSuja;
    private boolean maquinaEstaOcupada;
    private int shampooEstado;
    private int aguaEstado;
    private boolean petEstaLimpo;


    public Maquina() {
        this.aguaEstado = 0;
        this.shampooEstado = 0;
        this.maquinaEstaSuja = false;
        this.maquinaEstaOcupada = false;
        this.petEstaLimpo = false;

    }

    public void AbastecerMaquina(int abastecimentoMaquina) {
        if (abastecimentoMaquina != 1 && abastecimentoMaquina != 2) {
            System.out.println("Selecione uma opção válida!");
        } else if (this.aguaEstado > 29 || this.shampooEstado > 9) {
            if (abastecimentoMaquina == 1 && this.aguaEstado > 29) {
                System.out.println("Sua recarga de água já está no máximo de " + this.aguaEstado + " litros!");
            }  if (abastecimentoMaquina == 2 && this.shampooEstado > 9)
                System.out.println("Sua recarga de shampoo já está no máximo de " + this.shampooEstado + " litros!");
        }

        if (abastecimentoMaquina == 1 && this.aguaEstado == 29) {
            this.aguaEstado += 1;
            System.out.println("Limite alcançado, foi recarregado apenas 1 litro de água! Sua máquina está atualmente com " + this.aguaEstado + " litros de água");
        } else if (abastecimentoMaquina == 2 && this.shampooEstado == 9) {
            this.shampooEstado += 1;
            System.out.println("Limite alcançado, foi recarregado apenas 1 litro de shampoo! Sua máquina está atualmente com " + this.shampooEstado + " litros de shampoo");
        }
        if (abastecimentoMaquina == 1 && this.aguaEstado <= 28) {
            this.aguaEstado += 2;
            System.out.println("Água recarregada com sucesso! Sua máquina está atualmente com " + this.aguaEstado + " litros de água");
        } else if (abastecimentoMaquina == 2 && this.shampooEstado <=8) {
            this.shampooEstado += 2;
            System.out.println("Shampoo recarregada com sucesso! Sua máquina está atualmente com " + this.shampooEstado + " litros de shampoo");
        }
    }

    public void verificarNiveis() {
        System.out.println("Os níveis da máquina são: \n\n" + "Água: " + this.aguaEstado + " LITROS \n" + "Shampoo: " + this.shampooEstado + " LITROS \n\n");
    }

    public void inserirPet() {
        if (!this.maquinaEstaOcupada && !this.maquinaEstaSuja) {
        System.out.println("O pet foi inserido dentro da máquina");
        this.petEstaLimpo = false;
        this.maquinaEstaOcupada = true;
        } else if (this.maquinaEstaOcupada){
            System.out.println("Máquina está ocupada!");
        } else {
            System.out.println("A máquina está suja, higieniza-la antes de inserir outro pet");
        }
    }

    public void iniciarBanho() {
        if (!this.maquinaEstaOcupada) {
            System.out.println("A maquina esta vazia, inserir pet antes de iniciar o banho.");
        } else if (this.shampooEstado < 2 || this.aguaEstado < 10) {
            System.out.println("Níveis da máquina estão abaixo do necessário.");
        } else if (!petEstaLimpo){
            System.out.println("Inciando banho!");
            System.out.println("==================================");
            System.out.println("==================================");
            this.aguaEstado -= 10;
            this.shampooEstado -= 2;
            this.petEstaLimpo = true;
            System.out.println("==================================");
            System.out.println("==================================");
            System.out.println("Banho finalizado! Pet esta cheiroso e macio.");
        } else {
            System.out.println("Pet já está limpo!");
        }
    }

    public void verificarMaquina() {
        if (this.maquinaEstaOcupada && !petEstaLimpo) {
            System.out.println("Máquina ocupada, pet está aguardando seu banho");
        } else if (this.maquinaEstaOcupada) {
            System.out.println("Máquina está ocupada, banho foi concluido, pet aguardando ser retirado.");
        } else {
            System.out.println("Máquina vazia, inserir pet antes de começar o banho");
        }
    }

    public void limpezaMaquina() {
        if (this.maquinaEstaSuja && this.aguaEstado >= 3 && this.shampooEstado >=1) {
            System.out.println("A máquina está sendo higienizada");
            this.aguaEstado -= 3;
            this.shampooEstado -= 1;
            this.maquinaEstaSuja = false;
            System.out.println("==================================");
            System.out.println("==================================");
            System.out.println("Higienização completa, a máquina está pronta para uso.");
        } else if (!this.maquinaEstaSuja) {
            System.out.println("A máquina não está suja.");
        } else if (this.aguaEstado < 3) {
            System.out.println("Nível de água está abaixo do necessário.");
        } else {
            System.out.println("Nível de shampoo está abaixo do necessário.");
        }
    }

    public void removerPet() {
        if (this.maquinaEstaOcupada && !this.petEstaLimpo) {
            System.out.println("O pet foi removido da máquina antes de completar seu banho");
            System.out.println("==================================");
            System.out.println("==================================");
            System.out.println("A máquina está suja.");
            this.maquinaEstaSuja = true;
            this.maquinaEstaOcupada = false;
        } else if (this.maquinaEstaOcupada) {
            System.out.println("Pet foi removido e está cheiroso e pronto para ser entregue para seu tutor.");
            this.maquinaEstaOcupada = false;
        } else {
            System.out.println("A máquina está vazia.");
        }
    }

}
