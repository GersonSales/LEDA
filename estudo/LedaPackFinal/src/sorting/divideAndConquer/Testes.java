package sorting.divideAndConquer;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorting.divideAndConquer.Quicksort;
import sorting.variationsOfMergesort.HybridMergeBubbleStoogesort;
import sorting.variationsOfQuicksort.HybridMergesortQuicksort;
import sorting.variationsOfQuicksort.QuickSortMedianOfThree;

public class Testes {
	@Test
	public void testSortT0() {
		Integer array[] = {};
		Integer ordered[] = {};
		HybridMergesortQuicksort<Integer> mysort= new HybridMergesortQuicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT1() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		HybridMergesortQuicksort<Integer> mysort= new HybridMergesortQuicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT3() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		HybridMergesortQuicksort<Integer> mysort= new HybridMergesortQuicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT4() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		HybridMergesortQuicksort<Integer> mysort= new HybridMergesortQuicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT5() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		HybridMergesortQuicksort<Integer> mysort= new HybridMergesortQuicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT6() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		HybridMergesortQuicksort<Integer> mysort= new HybridMergesortQuicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT7() {
		Integer array[] = {};
		Integer ordered[] = {};
		Mergesort<Integer> mysort= new Mergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT8() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		Mergesort<Integer> mysort= new Mergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT9() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		Mergesort<Integer> mysort= new Mergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT10() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		Mergesort<Integer> mysort= new Mergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT11() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		Mergesort<Integer> mysort= new Mergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT12() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		Mergesort<Integer> mysort= new Mergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT13() {
		Integer array[] = {};
		Integer ordered[] = {};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT14() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT15() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT16() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortTExtra() {
		Integer array[] = {3,2,1};
		Integer ordered[] = {1,2,3};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT17() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT18() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		Quicksort<Integer> mysort= new Quicksort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT19() {
		Integer array[] = {};
		Integer ordered[] = {};
		HybridMergeBubbleStoogesort<Integer> mysort= new HybridMergeBubbleStoogesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT20() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		HybridMergeBubbleStoogesort<Integer> mysort= new HybridMergeBubbleStoogesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT21() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		HybridMergeBubbleStoogesort<Integer> mysort= new HybridMergeBubbleStoogesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT22() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		HybridMergeBubbleStoogesort<Integer> mysort= new HybridMergeBubbleStoogesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT23() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		HybridMergeBubbleStoogesort<Integer> mysort= new HybridMergeBubbleStoogesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT24() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		HybridMergeBubbleStoogesort<Integer> mysort= new HybridMergeBubbleStoogesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT25() {
		Integer array[] = {};
		Integer ordered[] = {};
		QuickSortMedianOfThree<Integer> mysort= new QuickSortMedianOfThree<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT26() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		QuickSortMedianOfThree<Integer> mysort= new QuickSortMedianOfThree<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT27() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		QuickSortMedianOfThree<Integer> mysort= new QuickSortMedianOfThree<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT28() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		QuickSortMedianOfThree<Integer> mysort= new QuickSortMedianOfThree<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT29() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		QuickSortMedianOfThree<Integer> mysort= new QuickSortMedianOfThree<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT30() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		QuickSortMedianOfThree<Integer> mysort= new QuickSortMedianOfThree<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
}