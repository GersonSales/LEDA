package questoes;

import java.util.Scanner;

class Pilha {
    private Integer[] pilha;
    private int topo;

    public Pilha(int tamanho) {
        this.pilha = new Integer[tamanho];
        this.topo = -1;
    }

    public void pop() {
        if (!estaVazia()) {
            pilha[topo] = null;
            topo--;
        }

    }

    private boolean estaVazia() {
        if (topo == -1) {
            System.out.println("empty");
            return true;
        }
        return false;
    }

    public void push(int elemento) {
        if (topo == pilha.length - 1) {
            System.out.println("full");
        } else {
            topo++;
            pilha[topo] = elemento;
        }

    }

    public void peek() {
        if (!estaVazia()) {
            System.out.println(pilha[topo]);
        }
    }

    public void print() {
        if (!estaVazia()) {
            StringBuffer saida = new StringBuffer();
            for (Integer i : pilha) {
                if (i != null)
                    saida.append(i + " ");
            }
            saida.deleteCharAt(saida.length() - 1);
            System.out.println(saida);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] comando;
        Solucao pilha = new Solucao(sc.nextInt());
        sc.nextLine();

        do {
            comando = sc.nextLine().split(" ");

            switch (comando[0]) {
            case "print":
                pilha.print();
                break;
            case "peek":
                pilha.peek();
                break;
            case "pop":
                pilha.pop();
                break;
            case "push":
                pilha.push(Integer.parseInt(comando[1]));
                break;
            default:
                break;
            }

        } while (!comando[0].equals("end"));

        sc.close();
    }
}
