import java.util.Scanner;

class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String numero = sc.nextLine();
		String sequencia = sc.nextLine();
		
		String resposta = contains(numero, sequencia) ? "sim" : "n\u00e3o";
		
		System.out.println(resposta);
		sc.close();
	}

	private static boolean contains(String numero, String sequencia) {
		for (String item: sequencia.split(" ")) {
			if (numero.equals(item)) {
				return true;
			}
		}
		return false;
	}

}
