package recursao;

public class MetodosRecursivos {

    public long calcularFatorial(int n) {
        long result = 1;
        if (n == 0) {
            return result;
        }
        result = n * calcularFatorial(n - 1);
        return result;
    }

    public int calcularFibonacci(int n) {
        int result = 1;
        if (n < 2) {
            return result;
        }
        result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        return result;
    }

    public int countNotNull(Object[] array) {
        return countNotNull(array, array.length - 1);
        // TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
        // QUANTIDADE DE ELEMENTOS NAO NULOS
        // DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
//        return result;
    }
    
    private int countNotNull(Object[] array, int indice) {
        int resultado = 0;
        if (indice >= 0) {
            if (array[indice] != null) {
                resultado ++;
            }
            return resultado + countNotNull(array, indice - 1);
        }
        return resultado;
    }

    

    public long potenciaDe2(int expoente) {
        long result = 1;
        if (expoente == 0) {
            return result;
        }
        result = 2 * potenciaDe2(expoente - 1);
        return result;
    }

    public double progressaoAritmetica(double termoInicial, double razao,
            int n) {
        double result = 0;
        if (n == 1) {
            return termoInicial;
        }else {
            result = progressaoAritmetica(termoInicial + razao, razao, n - 1);
        }
        return result;
    }

    public double progressaoGeometrica(double termoInicial, double razao,
            int n) {
        double result = 1;
        if (n == 1) {
            return termoInicial;
        }else {
            result = progressaoGeometrica(termoInicial * razao, razao, n - 1);
        }
        return result;
    }
}
