package sorting.variationsOfQuicksort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorting.divideAndConquer.Quicksort;

public class Testes {
	@Test
	public void testSortT0() {
		Integer array[] = {};
		Integer ordered[] = {};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT1() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT3() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT4() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT5() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT6() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT7() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT8() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		QuicksortDualPivot<Integer> mysort= new QuicksortDualPivot<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT9() {
		Integer array[] = {};
		Integer ordered[] = {};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT10() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT11() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT12() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT13() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT14() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT15() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT16() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		QuickSortThreeWay<Integer> mysort= new QuickSortThreeWay<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT17() {
		Integer array[] = {};
		Integer ordered[] = {};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT18() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT19() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT20() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT21() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT22() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT23() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT24() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		Quickbest<Integer> mysort= new Quickbest<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSort25() {
		Integer array[] = {};
		Integer ordered[] = {};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT26() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT27() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT28() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT29() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT30() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT31() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT32() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		QuicksortDualPivotBruno<Integer> mysort= new QuicksortDualPivotBruno<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
}