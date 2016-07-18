package questoes;

import java.util.Scanner;

class Solucao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequencia = toArray(sc.nextLine());
        ordena(sequencia);
        imprimeArray(sequencia);

        sc.close();
    }

    private static void ordena(int[] sequencia) {
        sort(sequencia, 0, sequencia.length - 1);
    }

    public static void sort(int[] vetor, int inicio, int fim) {
        if (inicio > fim)
            return;
        if (vetor[inicio] > vetor[fim]) {
            troca(vetor, inicio, fim);
        }

        sort(vetor, inicio + 1, fim + 1);

    }

    private static void imprimeArray(int[] sequencia) {
        StringBuffer resultado = new StringBuffer();
        for (int i : sequencia) {
            resultado.append(i + " ");
        }

        resultado.deleteCharAt(resultado.length() - 1);
        System.out.println(resultado);
    }

    private static void troca(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    private static int[] toArray(String sequencia) {
        String[] sequenciaArray = sequencia.split(" ");
        int[] sequenciaInt = new int[sequenciaArray.length];
        for (int i = 0; i < sequenciaInt.length; i++) {
            sequenciaInt[i] = Integer.valueOf(sequenciaArray[i]);
        }
        return sequenciaInt;
    }

}
