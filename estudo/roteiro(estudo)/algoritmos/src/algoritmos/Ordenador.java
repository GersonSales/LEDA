package algoritmos;

public class Ordenador<E extends Comparable<E>> {

    public void ordena(E[] lista) {
        // insertionSort(lista);
        // bubbleSort(lista);
        // selectionSort(lista);
        mergeSort(lista);
    }

    private void bubbleSort(E[] lista) {
        boolean houveTroca;
        do {
            houveTroca = false;
            int ultimoOrdenado = lista.length - 1;
            for (int i = 0; i < ultimoOrdenado; i++) {
                if (lista[i].compareTo(lista[i + 1]) > 0) {
                    troca(lista, i, i + 1);
                    houveTroca = true;
                    ultimoOrdenado--;
                }
            }
        } while (houveTroca);
    }

    private void selectionSort(E[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int menor = i;
            for (int j = i; j < lista.length; j++) {
                if (lista[j].compareTo(lista[menor]) < 0) {
                    menor = j;
                }
            }
            troca(lista, i, menor);
        }
    }

    private void insertionSort(E[] lista) {
        for (int i = 0; i < lista.length; i++) {
            int elemento = i;
            while (elemento > 0
                    && lista[elemento].compareTo(lista[elemento - 1]) < 0) {
                troca(lista, elemento, elemento - 1);
                elemento--;
            }

        }
    }

    private void troca(E[] lista, int i, int j) {
        E aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    private E[] listaAuxiliar;

    @SuppressWarnings("unchecked")
    private void mergeSort(E[] lista) {
        this.listaAuxiliar = (E[]) new Comparable[lista.length];
        mergeSort(lista, 0, lista.length - 1);
    }

    private void mergeSort(E[] lista, int inicio, int fim) {
        if (inicio < fim) {
        
        int meio = inicio + (fim - inicio) / 2;
        mergeSort(lista, inicio, meio);
        mergeSort(lista, meio + 1, fim);

        ordena(lista, inicio, meio, fim);
        }

    }

    private void ordena(E[] lista, int inicio, int fim, int meio) {

        for (int i = inicio; i <= fim; i++) {
            listaAuxiliar[i] = lista[i];
        }

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while (i <= meio && j <= fim) {
            if (listaAuxiliar[i].compareTo(lista[j]) <= 0) {
                lista[k] = listaAuxiliar[i];
                i++;
            } else {
                lista[k] = listaAuxiliar[j];
                j++;
            }

            k++;
        }

        while (i <= meio) {
            lista[k] = listaAuxiliar[i];
            i++;
            k++;

        }
    }

    public E[] merge(E[] lista1, E[] lista2) {
        return null;
    }

    public void imprimeLista(E[] lista) {
        System.out.print("[");
        for (E e : lista) {
            System.out.print(e + ", ");
        }
        System.out.println("]");
    }

}