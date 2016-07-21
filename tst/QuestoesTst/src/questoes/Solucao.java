package questoes;

import java.util.Scanner;

class Solucao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = toArray(sc.nextLine());
        int[] index = toArray(sc.nextLine());
        int i = index[0];
        int j = index[1];

        int mqi = contaMenores(array, 0, i);
        int mqj = contaMenores(array, 0, j);

        int meio = (array.length - 1) / 2;

        int deim = diferenca(mqi, meio);
        int dejm = diferenca(mqj, meio);
        
        System.out.println(deim < dejm ? i : j);
        sc.close();
    }

    private static int diferenca(int mqi, int meio) {
        int maior = mqi >= meio ? mqi : meio;
        int menor = mqi < meio ? mqi : meio;
        return maior - menor;

    }

    private static int contaMenores(int[] array, int left, int indice) {
        int contador = 0;
        for (int i = left; i < indice; i++) {
            if (array[i] < array[indice]) {
                contador++;
            }
        }

        return contador;
    }

    private static int partition(int[] array, int left, int right) {
        if (left > right) {
            int pivot = array[left];
            int i = left;
            for (int j = i + 1; j < right; j++) {
                if (j < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i, pivot);
            return i;
        } else {
            return -1;
        }
    }

    private static void swap(int[] array, int i, int j) {
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
