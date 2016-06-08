package algoritmos;

public class Ordenador<E extends Comparable<E>> {
    public void bubbleSort(E[] lista) {
        boolean houveTroca;
        do {
            houveTroca = false;
            int ultimoOrdenado = lista.length - 1;
            for (int i = 0; i < ultimoOrdenado; i++) {
                if (lista[i].compareTo(lista[i + 1]) > 0) {
                    E aux = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = aux;
                    houveTroca = true;
                    ultimoOrdenado--;
                }
            }
        } while (houveTroca);
    }

    public void selectionSort(E[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int menor = i;
            for (int j = i; j < lista.length; j++) {
                if (lista[j].compareTo(lista[menor]) < 0) {
                    menor = j;
                }
            }
            E aux = lista[i];
            lista[i] = lista[menor];
            lista[menor] = aux;
        }
    }

    public void insertionSort(E[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int elemento = i + 1;
            while(elemento > 0 && lista[elemento].compareTo(lista[i]) < 0) {
                elemento --;
            }
            E aux = lista[i];
            lista[i] = lista[elemento];
            lista[elemento] = aux;
            
        }
    }

    public void imprimeLista(E[] lista) {
        System.out.print("[");
        for (E e : lista) {
            System.out.print(e + ", ");
        }
        System.out.println("]");
    }
}