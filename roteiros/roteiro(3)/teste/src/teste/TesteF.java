package teste;

import java.util.Scanner;

public class TesteF {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a opcao: ");
        int opcao = leitor.nextInt();
        System.out.println("opcao: " + opcao);


        leitor.close();

    }
}

