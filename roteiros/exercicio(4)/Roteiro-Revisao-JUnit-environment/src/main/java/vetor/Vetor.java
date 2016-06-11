package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<E> {

    // O array interno onde os objetos manipulados são guardados
    private E[] arrayInterno;

    // O tamanho que o array interno terá
    private int tamanho;

    // Indice que guarda a proxima posição vazia do array interno
    private int indice;

    // O Comparators a serem utilizados
    private Comparator<E> comparadorMaximo;
    private Comparator<E> comparadorMinimo;

    @SuppressWarnings("unchecked")
    public Vetor(int tamanho) {
        super();
        this.tamanho = tamanho;
        this.indice = 0;
        this.arrayInterno = (E[]) new Comparable[tamanho];
    }

    public void setComparadorMaximo(Comparator<E> comparadorMaximo) {
        this.comparadorMaximo = comparadorMaximo;
    }

    public void setComparadorMinimo(Comparator<E> comparadorMinimo) {
        this.comparadorMinimo = comparadorMinimo;
    }

    // Insere um objeto no vetor
    public void inserir(E elemento) {
        if (indice < tamanho) {
            this.arrayInterno[this.indice] = elemento;
            this.indice++;
        }
    }

    // Remove um objeto do vetor
    public E remover() {
        E elemento = this.arrayInterno[indice - 1];
        this.arrayInterno[indice - 1] = null;
        indice --;
        return elemento;
    }

    // Procura um elemento no vetor
    public E procurar(E o) {
        for (E e : arrayInterno) {
            if (e != null && e.equals(o)) {
                return e;
            }
        }
        return null;
    }

    // Diz se o vetor está vazio
    public boolean isVazio() {
        for (E e : arrayInterno) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }

    // Diz se o vetor está cheio
    public boolean isCheio() {
        if (indice < tamanho) {
            return false;
        }
        return true;
    }

}