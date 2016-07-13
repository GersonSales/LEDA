package algoritmos;

import javax.lang.model.element.QualifiedNameable;

public class Ordenador<E extends Comparable<E>> {

    public void ordena(E[] lista) {
        // insertionSort(lista);
        // bubbleSort(lista);
        // selectionSort(lista);
        quickSort(lista);
//        mergeSort(lista);
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
    
    private void quickSort(E[] lista) {
        quickSort(lista, 0, lista.length - 1);
    }
    
    
    
    

    private void quickSort(E[] lista, int inicio, int fim) {
        if (inicio < fim) {
            int meio = particiona(lista, inicio, fim);
            quickSort(lista, inicio, meio - 1);
            quickSort(lista, meio + 1, fim);
        }
        
        
        // TODO Auto-generated method stub
        
    }

    private int particiona(E[] lista, int inicio, int fim) {
        E pivot = lista[inicio];
        int i = inicio;
        
        
        for (int j = inicio + 1; j <= fim; j ++) {
            if (lista[j].compareTo(pivot) < 0) {
                i++;
                troca(lista, i, j);
            }
        }
        
        lista[inicio] = lista[i];
        lista[i] = pivot;
        
        
        return i;
    }

    private void mergeSort(E[] lista) {
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

    @SuppressWarnings("unchecked")
    private void ordena(E[] lista, int inicio, int meio, int fim) {
        E[] listaAux = (E[]) new Comparable[fim + 1];
        for (int i = inicio; i <= fim; i++) {
            listaAux[i] = lista[i]; 
        }
        
        int i = inicio;
        int j = meio + 1;
        int k = inicio;
        
        while (i <= meio && j <= fim) {
            if (listaAux[i].compareTo(listaAux[j]) < 0) {
                lista[k] = listaAux[i];
                i++;
            }else {
                lista[k] = listaAux[j];
                j++;
            }
            
            k++;
        }
        
        
        while (i <= meio) {
            lista[k] = listaAux[i];
            i++;
            k++;
        }
        
        while (j <= fim) {
            lista[k] = listaAux[j];
            j++;
            k++;
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