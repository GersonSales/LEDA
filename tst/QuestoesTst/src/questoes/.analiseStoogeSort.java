package questoes;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.LimitExceededException;

class Solucao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequencia = toArray(sc.nextLine());
        ordena(sequencia);
        imprimeArray(sequencia);

        sc.close();
    }

    private static void ordena(int[] sequencia) {
        stoogeSort(sequencia, 0, sequencia.length - 1);
    }

    public static void stoogeSort(int[] sequencia, int limEsquerdo,
            int limDireito) {
        if (sequencia[limDireito] < sequencia[limEsquerdo]) {// 3C
            troca(sequencia, limEsquerdo, limDireito);// 7C
        }

        if (limDireito - limEsquerdo > 1) { // 2C
            int terco = (1 + limDireito - limEsquerdo) / 3; // 4C
            stoogeSort(sequencia, limEsquerdo, limDireito - terco); // T(2n/3)
            stoogeSort(sequencia, limEsquerdo + terco, limDireito); // T(2n/3)
            stoogeSort(sequencia, limEsquerdo, limDireito - terco); // T(2n/3)
        }

        /*
         * Análise: Soma dos custos
         * 
         * 3C + 7C + 2C + 4C + 3T(2n/3) = 3T(2n/3) + C || 3T((2/3)n) O(1)
         * 
         * Análise: Calculando crescimento assintótico
         * 
         * F(n) = c
         * 
         * n**logb(a) < | == | > F(n)
         * 
         * n**log3/2(3) ≈ 2.7
         * 
         * logo:
         * 
         * n**logb(a) > F(n)
         * 
         * sendo assim:
         * 
         * O crescimento assintótico do StoogeSort é de Θ(n**2.7)
         * 
         * ou seja: 
         * 
         * T(n) ∈ Θ(n**2)
         * 
         * Análise: Comparação, de classe assintótica, com outros algoritmos
         * 
         * --------------------------------------------------------
         * |Algoritmo      |Melhor caso | Médio caso | Pior caso  |
         * --------------------------------------------------------
         * |Stooge Sort    |  O(n2.70)  | O(n2.70)   |  O(n2.70)  |
         * --------------------------------------------------------
         * |Bubble Sort    |   O(n2)    |   O(n2)    |   O(n2)    |
         * --------------------------------------------------------
         * |Insertion Sort |   O(n2)    |   O(n)     |   O(n2)    |
         * --------------------------------------------------------
         * |Selection Sort |   O(n2)    |   O(n2)    |   O(n2)    |
         * --------------------------------------------------------
         * 
         * 
         * Análise geral
         * 
         * Mesmo tais algoritmos pertencendo à mesma classe de crescimento assintótico
         * existem alguns pontos que devem ser levados em consideração: 
         * 
         * SelectionSort, InsertionSort: Algoritmos considerados ineficientes, porém 
         * pode-se dizer que os mesmos fazem parte dos "menos piores", realizam poucas 
         * trocas ou poucas comparações para realizar a ordenação de um vetor, fazendo 
         * assim com seja conveniente escolhê-los para ordenar pequenas entradas. 
         * 
         * BublleSort: Algoritmo considerado praticamente inútil na prática, usado na 
         * maioria das vezes com objetivo didático, pois sua solução de ordenação
         * não garante eficiência já que o mesmo precisa fazer muitas comparações e 
         * muitas trocas de elementos para conseguir ordenar a entrada.
         * 
         * StoogeSort: Pode ser considerado o pior algoritmo, pior até mesmo que o 
         * BubbleSort, pois segue uma lógica incoerente para realizar a divisão do 
         * vetor, fazendo assim com que seja multiplicado seu trabalho, e em certos 
         * casos pode-se, até, entrar em chamads recursivas infinitas, ou seja, não
         * considera-se um algoritmo minimamente eficiente ou  confiável.
         * 
         */
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
