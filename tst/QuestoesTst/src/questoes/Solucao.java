package questoes;

import java.util.Scanner;

class Solucao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequencia = toArray(sc.nextLine());
        
        
        particiona(sequencia);
        imprimeArray(sequencia);

        sc.close();
    }

    private static void particiona(int[] array) {
    	int pivo = array.length/2;
    	int i = 0;
    	int j = array.length - 1;
    	
    	while (i < j) {
    		if (array[j] < pivo) {
    			troca(array, j, pivo);
    			pivo = j;
    			array[j] = pivo;
    		}else {
    			j--;
    		}
    		
    		if (array[i] > pivo) {
    			troca(array, i, pivo);
    			pivo = i;
    		}else {
    			i++;
    		}
    	}
    			
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
