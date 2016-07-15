package teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Ordenador {
	
	public Ordenador() {
        try {
        	
            Class[] classes = getClasses("br.com.maxiconsystems.embarcador.modelo");
            for (int i = 0; i < classes.length; i++) {
                //System.out.println(classes[i].getName());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static Class[] getClasses(String pckgname) throws ClassNotFoundException {
        ArrayList<Class> classes=new ArrayList();
        // Get a File object for the package
        File directory=null;
        try {
            directory=new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile());
        } catch(NullPointerException x) {
            throw new ClassNotFoundException(pckgname+" does not appear to be a valid package1");
        }
        if(directory.exists()) {
        // Get the list of the files contained in the package
            String[] files=directory.list();
            for(int i=0; i<files.length; i++) {
        // we are only interested in .class files
                if(files[i].endsWith(".class")) {
        // removes the .class extension
                    //classes.add(Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6)));
                    Field[] campos = null;
                    System.out.println("Tabela: "+files[i].substring(0, files[i].length()-6));
                    campos = Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6)).getFields(); // getDeclaredFields();
                    for (int j =0; j < campos.length; j++) {
                        System.out.println(campos[j].getName());
                    }
                    classes.add(Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6)));
                }
            }
        } else {
            throw new ClassNotFoundException(pckgname+" does not appear to be a valid package2");
        }
        Class[] classesA=new Class[classes.size()];
        classes.toArray(classesA);
        return classesA;
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ordenador();
            }
        });
    }

    Random randomer;
    private int qtdTestes;

    @Before
    public void setUp() throws Exception {
        this.qtdTestes = 0;
        randomer = new Random();
//        this.ordenador = new QuickSortMedianOfThree<>();
    }

    private Integer[] gerador() {
        int tamanho = randomer.nextInt(20);
        Integer[] lista = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            lista[i] = randomer.nextInt(100);
        }

        return lista;
    }

    private void logger(String texto) {
        try {
            File diretorio = new File("log");
            if (!(diretorio.exists())) {
                diretorio.mkdirs();
            }

            File arquivo = new File("log/" + "arquivo.txt");
            FileWriter fluxoSaida = new FileWriter(arquivo, true);
            BufferedWriter escritor = new BufferedWriter(fluxoSaida);

            fluxoSaida.write(texto + "\n");

            escritor.close();

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

    }

    @Test
    public void iniciaTestes() {
        while (true) {
            qtdTestes++;
            teste(gerador());
        }

    }

    public void teste(Integer[] lista) {
        String listaTS = Arrays.toString(lista);

        Integer[] auxiliar = Arrays.copyOf(lista, lista.length);

        Arrays.sort(auxiliar);
//        ordenador.sort(lista);

        try {
            Assert.assertArrayEquals(auxiliar, lista);
        } catch (Throwable erro) {
            System.out.print("F");
            logger(listaTS, Arrays.toString(auxiliar), Arrays.toString(lista));
            throw erro;
        }
        System.out.print(qtdTestes %50!=0?".":"\n");
    }

    private void logger(String entrada, String esperado, String obtido) {
        String sl = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer();
        sb.append("Teste(" + qtdTestes + "):");
        sb.append(sl + sl);

        sb.append("Entrada:  ");
        sb.append(entrada);
        sb.append(sl);

        sb.append("Esperado: ");
        sb.append(esperado);
        sb.append(sl);

        sb.append("Obtido:   ");
        sb.append(obtido);
        sb.append(sl);

        sb.append("<-------------------------------------------->");
        sb.append(sl);

        logger(sb.toString());
    }

}