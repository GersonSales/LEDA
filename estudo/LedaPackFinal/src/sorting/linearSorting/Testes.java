package sorting.linearSorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorting.divideAndConquer.Quicksort;

public class Testes {
	@Test
	public void testSortT0() {
		Integer array[] = {};
		Integer ordered[] = {};
		Radixsort mysort= new Radixsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT1() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		Radixsort mysort= new Radixsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT3() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		Radixsort mysort= new Radixsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT4() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		Radixsort mysort= new Radixsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT5() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		Radixsort mysort= new Radixsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT6() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		Radixsort mysort= new Radixsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT7() {
		Integer array[] = {};
		Integer ordered[] = {};
		Countingsort mysort= new Countingsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT8() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		Countingsort mysort= new Countingsort();
		
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT9() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		Countingsort mysort= new Countingsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT10() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		Countingsort mysort= new Countingsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT11() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		Countingsort mysort= new Countingsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT12() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {3567,790,9,5,1,-53,-66};
		Countingsort mysort= new Countingsort();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
}