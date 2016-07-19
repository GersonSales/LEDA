package algoritmos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingTest {

	private final String LOG_DIRECTORY = "logger";
	private final String LOG_FILE_NAME = "log";

	private final String EXEC_RESULT_DIRECTORY = "statistics";
	private final String EXEC_RESULT_FILE_NAME = "execResult";
	
	private final int TEST_TIME = 3;//in seconds

	Random randomer;
	private Sorting<Integer> sorting;// PUT YOUR SORTING CLASS HERE.
	private int qtdTests;

	private Integer[] arrayGenerator() {
		int length = randomer.nextInt(20);
		Integer[] array = new Integer[length];
		for (int i = 0; i < length; i++) {
			array[i] = randomer.nextInt(100);
			if (randomer.nextBoolean())
				array[i] *= -1;
		}

		return array;
	}

	private void execResultWriter(String execResult) {
		textWriter(EXEC_RESULT_DIRECTORY, EXEC_RESULT_FILE_NAME, execResult, true);
	}

	private void execResultWriter(String execResult, boolean nextLine) {
		textWriter(EXEC_RESULT_DIRECTORY, EXEC_RESULT_FILE_NAME, execResult, nextLine);
	}

	@Test
	public void start() {
		execResultWriter("------------------BEGIN-------------------");
		execResultWriter(sorting.getClass().getSimpleName());
		
		long begin = System.currentTimeMillis();
		try {
			while (System.currentTimeMillis() - begin < TEST_TIME * 1000) {
				qtdTests++;
				simpleInput();
				indexhandler();
			}
		} catch (Throwable error) {
			logger(error);
			throw error;
		} finally {
			execResultWriter("Total of tests: " + qtdTests + " | ", false);
			execResultWriter("Total time: " + ((System.currentTimeMillis() - begin) / 1000) + "s");
			execResultWriter("===================END====================");
		}
	}

	private void logger(Throwable error) {
		textWriter(LOG_DIRECTORY, LOG_FILE_NAME, error.toString(), true);
	}

	private void execResult(String input, String expeted, String obtained, int leftIndex, int rightindex) {
		String sl = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		sb.append("Test(" + qtdTests + ") - leftIndex: " + leftIndex + " rightIndex: " + rightindex);
		sb.append(sl + sl);

		sb.append("Input:    ");
		sb.append(input);
		sb.append(sl);

		sb.append("Expected: ");
		sb.append(expeted);
		sb.append(sl);

		sb.append("Obtained: ");
		sb.append(obtained);
		sb.append(sl);

		execResultWriter(sb.toString());
	}

	private void indexhandler() {
		Integer[] array = arrayGenerator();
		String arrayToString = Arrays.toString(array);

		Integer[] assistArray = Arrays.copyOf(array, array.length);

		int length = array.length;
		int leftIndex = randomer.nextInt(length == 0 ? 1 : length);
		int rightIndex = randomer.nextInt(length == 0 ? 1 : length);

		if (randomer.nextBoolean())
			leftIndex *= -1;

		if (randomer.nextBoolean())
			rightIndex *= -1;

		try {
			if (length > 0)
				Arrays.sort(assistArray, leftIndex, rightIndex + 1);
		} catch (Exception erro) {
			logger(erro);
		}

		sorting.sort(array, leftIndex, rightIndex);

		try {
			Assert.assertArrayEquals(array, assistArray);
		} catch (Throwable erro) {
			execResult(arrayToString, Arrays.toString(assistArray), Arrays.toString(array), leftIndex, rightIndex);
			throw erro;
		}

	}

	@Before
	public void setUp() {
		this.qtdTests = 0;
		randomer = new Random();
		this.sorting = new Sorting<>();
	}

	private void simpleInput() {
		Integer[] array = arrayGenerator();
		String arraytoString = Arrays.toString(array);

		Integer[] assistArray = Arrays.copyOf(array, array.length);

		Arrays.sort(assistArray);
		sorting.sort(array, 0, array.length - 1);

		try {
			Assert.assertArrayEquals(assistArray, array);
		} catch (Throwable erro) {
			execResult(arraytoString, Arrays.toString(assistArray), Arrays.toString(array), 0, array.length - 1);
			throw erro;
		}
	}

	public void simpleTest() {
		Integer[] array = { -3, -5, -2, -8, -9, 0, -1, -10, -2, 10 };
		System.out.println("Array:    " + Arrays.toString(array));
		Integer[] assistArray = Arrays.copyOf(array, array.length);

		int leftIndex = 0;
		int rightIndex = array.length - 1;

		Arrays.sort(assistArray, leftIndex, rightIndex + 1);
		sorting.extendedCountingSort(array, leftIndex, rightIndex);

		System.out.println("Expected: " + Arrays.toString(assistArray));
		System.out.println("Obtained: " + Arrays.toString(array));

	}

	private void textWriter(String directoryName, String fileName, String text, boolean nextLine) {
		try {
			File directory = new File(directoryName);
			if (!(directory.exists())) {
				directory.mkdirs();
			}

			File file = new File(directory.getPath() + "/" + fileName + ".txt");
			FileWriter outStream = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(outStream);

			outStream.write(text + (nextLine ? "\n" : ""));

			writer.close();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

}
