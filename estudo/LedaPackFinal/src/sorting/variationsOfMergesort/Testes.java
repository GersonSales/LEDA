package sorting.variationsOfMergesort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorting.Implementations.Mergesort;
import sorting.divideAndConquer.Quicksort;
import sorting.variationsOfQuicksort.HybridMergesortQuicksort;
import sorting.variationsOfQuicksort.QuicksortDualPivot;

public class Testes {
	@Test
	public void testSortT0() {
		Integer array[] = {3,7,9,8,6,2,1};
		Integer removed[] = {7,9,8,6,2,1,null};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.remove(array,0,array.length-1,0);
		
		assertArrayEquals(removed, array);
	}
	
	@Test
	public void testSortT1() {
		Integer array[] = {3,7,9,8,6,2,1};
		Integer removed[] = {3,9,8,2,1,null, null};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.remove(array,0,array.length-1,1);
		mysort.remove(array,0,array.length-1,3);
		mysort.remove(array,0,array.length-1,5);
		
		assertArrayEquals(removed, array);
	}
	
	@Test
	public void testSortT2() {
		Integer array[] = {};
		Integer removed[] = {};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.remove(array,0,array.length-1,1);
		
		assertArrayEquals(removed, array);
	}
	
	@Test
	public void testSortT3() {
		Integer array[] = {4,7,2,7,9,65,3,2,5,7,-65};
		Integer removed[] = {4,7,2,7,9,5,7,-65,null,null,null};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.remove(array,0,array.length-1,5);
		mysort.remove(array,0,array.length-1,5);
		mysort.remove(array,0,array.length-1,5);
		
		assertArrayEquals(removed, array);
	}
	
	@Test
	public void testSortT4() {
		Integer array[] = {};
		Integer ordered[] = {};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT5() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT6() {
		Integer array[] = {2,6,7,8};
		Integer added[] = {2,null,null,null};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.add(array,0,added.length,array[0]);
		
		assertArrayEquals(added, array);
	}
	
	@Test
	public void testSortT7() {
		Integer array[] = {};
		Integer ordered[] = {};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT8() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT9() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT10() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT11() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT12() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT13() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT14() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		MergeX<Integer> mysort= new MergeX<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	/*@Test
	public void testSortT15() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT16() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT17() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT18() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT19() {
		Integer array[] = {21,44,7,-12,1,56,3,340,200,255,-77,12,23,6,111,92,-5};
		Integer ordered[] = {-77,-12,-5,1,3,6,7,12,21,23,44,56,92,111,200,255,340};
		Strandsort<Integer> mysort= new Strandsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	*/
	@Test
	public void testSortT20() {
		Integer array[] = {};
		Integer ordered[] = {};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT21() {
		Integer array[] = {1};
		Integer ordered[] = {1};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT22() {
		Integer array[] = {2,1};
		Integer ordered[] = {1,2};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT23() {
		Integer array[] = {2,1,-4};
		Integer ordered[] = {-4,1,2};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT24() {
		Integer array[] = {-24,200,1956, 94,4};
		Integer ordered[] = {-24,4,94,200,1956};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT25() {
		Integer array[] = {-66, 9,1,-53,790,5,3567};
		Integer ordered[] = {-66,-53,1,5,9,790,3567};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT26() {
		Integer array[] = {5,1,7,4,6};
		Integer ordered[] = {1,4,5,6,7};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT27() {
		Integer array[] = {-1,3,7,-6,5,10,20};
		Integer ordered[] = {-6,-1,3,5,7,10,20};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT28() {
		Integer array[] = {-100,3,246,-6,125,-156,2000,1,5678,4};
		Integer ordered[] = {-156,-100,-6,1,3,4,125,246,2000,5678};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT29() {
		Integer array[] = {5,4,-7,2,8,9,-1,1,4,6};
		Integer ordered[] = {5,4,-7,2,8,9,-1,1,4,6};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array, 5, 4);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT30() {
		Integer array[] = {15,-17,29,40,6645,3,1,563,-987};
		Integer ordered[] = {15,-17,29,-987,1,3,40,563,6645};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array, 3, 8);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT31() {
		Integer array[] = {30,-18,1,42,1,3,1,569,-900};
		Integer ordered[] = {30,-18,1,1,1,3,42,569,-900};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array, 2, 7);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT32() {
		Integer array[] = {0,-5,10,-15,20,-25,30,-35,40,-45,50,-55,60};
		Integer ordered[] = {0,-5,10,-15,20,-35,-25,30,40,-45,50,-55,60};
		OddEvenMergesort<Integer> mysort= new OddEvenMergesort<>();
		
		mysort.sort(array, 5, 8);
		
		assertArrayEquals(ordered, array);
	}
}