package sorting.linearSorting;

import javax.swing.text.AbstractDocument.LeafElement;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

    private boolean validaArray(Integer[] array, int leftIndex,
            int rightIndex) {
        if (rightIndex < leftIndex)
            return false;
        if (leftIndex < 0)
            return false;
        if (rightIndex > array.length)
            return false;
        if (array.length < 2)
            return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null)
                return false;
        }

        return true;
    }

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (!validaArray(array, leftIndex, rightIndex))
            return;

        int menor = min(array, leftIndex, rightIndex);
        int menorAbs = Math.abs(menor);
        if (menor < 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] += menorAbs;
            }
            menorAbs = 0;
        }

        int maior = max(array, leftIndex, rightIndex);
        int diferenca = maior - menorAbs;

        int[] frequencia = new int[diferenca + 1];

        for (int i = leftIndex; i <= rightIndex; i++) {
            frequencia[array[i] - menorAbs]++;
        }

        for (int i = 0 + 1; i < frequencia.length; i++) {
            frequencia[i] += frequencia[i - 1];
        }

        Integer[] arrayFinal = new Integer[rightIndex - leftIndex + 1];

        for (int i = rightIndex; i >= leftIndex; i--) {
            arrayFinal[--frequencia[array[i] - menorAbs]] = array[i];

        }

        for (int i = 0; i < arrayFinal.length; i++) {
            array[i + leftIndex] = arrayFinal[i];
        }

        if (menor < 0)
            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] -= Math.abs(menor);
            }

    }

    private Integer max(Integer[] array, int leftIndex, int rightIndex) {
        Integer maior = array[leftIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            maior = maior.compareTo(array[i]) < 0 ? array[i] : maior;
        }
        return maior;

    }

    private int min(Integer[] array, int leftIndex, int rightIndex) {
        Integer menor = array[leftIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            menor = menor.compareTo(array[i]) > 0 ? array[i] : menor;
        }
        return menor;
    }

}
