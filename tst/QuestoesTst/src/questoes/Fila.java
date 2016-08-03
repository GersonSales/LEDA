package questoes;

import java.util.Arrays;
import java.util.Scanner;

import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

class Fila {

    private Integer[] fila;
    private int inicio;
    private int fim;

    private boolean estaCheia;
    private boolean estaVazia;

    public Fila(int tamanho) {
        this.fila = new Integer[tamanho];
        this.inicio = 0;
        this.fim = 0;
        this.estaCheia = false;
        this.estaVazia = true;
    }

    public void add(Integer elemento) {
        if (!estaCheia() && fila.length != 0) {
            fila[fim] = elemento;
            fim++;
            fim = fim % fila.length;
            estaVazia = false;
        } else {
            System.out.println("full");
        }
        if (inicio == fim) {
            estaCheia = true;
        }
    }

    private boolean estaCheia() {
        return estaCheia;
    }

    private boolean estaVazia() {
        return estaVazia;
    }

    public void remove() {
        if (!estaVazia()) {
            fila[inicio] = null;
            inicio++;
            inicio = inicio % fila.length;
            estaCheia = false;
        } else {
            System.out.println("empty");
        }

        if (inicio == fim) {
            estaVazia = true;
        }

    }

    public void element() {
        if (!estaVazia()) {
            System.out.println(fila[inicio]);
        } else {
            System.out.println("empty");
        }

    }

    public void print() {
        if (!estaCheia() && !estaVazia()) {
            StringBuffer sb = new StringBuffer();
            for (int i = inicio; i <= inicio + (fila.length - 1); i++) {
                if (fila[i % fila.length] != null) {
                    sb.append(fila[i % fila.length] + " ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);

        } else if (estaCheia()) {
            System.out.println("full");
        } else if (estaVazia()) {
            System.out.println("empty");
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(this.fila);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        sc.nextLine();

        Fila fila = new Fila(tamanho);
        String[] comando;
        do {
            comando = sc.nextLine().split(" ");

            if (comando[0].contains("print")) {
                fila.print();
            } else if (comando[0].contains("element")) {
                fila.element();
            } else if (comando[0].contains("add")) {
                fila.add(Integer.parseInt(comando[1]));
            } else if (comando[0].contains("remove")) {
                fila.remove();
            }

        } while (!comando[0].contains("end"));

        sc.close();
    }

}
