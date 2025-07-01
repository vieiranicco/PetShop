import java.util.Scanner;

public class PetShop {

    public static void main (String[] args) {

        var scanner = new Scanner(System.in);
        Maquina novaMaquina = new Maquina();

        int opcao;
        int abastecimentoMaquina;

        do {

            System.out.println("====Escolha uma opção===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer máquina");
            System.out.println("3 - Verificar níveis da máquina");
            System.out.println("4 - Verificar se tem pet no banho");
            System.out.println("5 - Colocar pet na máquina");
            System.out.println("6 - Retirar pet da máquina");
            System.out.println("7 - Limpar máquina");
            System.out.println("0 - Sair");

            try {
                opcao = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, selecione uma opção");
                scanner.next();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    novaMaquina.iniciarBanho();
                    break;
                case 2:
                    System.out.println("====Selecione o que deseja Abastecer====");
                    System.out.println("1 - Água");
                    System.out.println("2 - Shampoo");
                    abastecimentoMaquina = scanner.nextInt();
                    novaMaquina.AbastecerMaquina(abastecimentoMaquina);
                    break;
                case 3:
                    novaMaquina.verificarNiveis();
                    break;
                case 4:
                    novaMaquina.verificarMaquina();
                    break;
                case 5:
                    novaMaquina.inserirPet();
                    break;
                case 6:
                    novaMaquina.removerPet();
                    break;
                case 7:
                    novaMaquina.limpezaMaquina();
                    break;
                case 0:
                    break;
            }

        } while (opcao != 0);


    }

}
