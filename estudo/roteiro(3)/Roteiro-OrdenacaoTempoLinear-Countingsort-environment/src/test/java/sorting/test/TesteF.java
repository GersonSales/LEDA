package sorting.test;

import java.util.Scanner;

public class TesteF {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a opcao: ");
        int opcao = leitor.nextInt();

        int opcao1 = leitor.nextInt();

        switch (opcao1) {
        case 1:
            System.out.println("Opcao 1");
            break;

        case 2:
            System.out.println("Opcao 2");
            break;
        default:
            break;
        }

        leitor.close();

    }
}
