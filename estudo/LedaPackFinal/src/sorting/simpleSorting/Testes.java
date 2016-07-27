package sorting.simpleSorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Testes {
	@Test
	public void testSortT0() {
		Integer array[] = {};
		Integer ordered[] = {};
		Bubblesort<Integer> mysort= new Bubblesort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT1() {
		Integer array[] = {10};
		Integer ordered[] = {10};
		Bubblesort<Integer> mysort= new Bubblesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT2() {
		Integer array[] = {10,7};
		Integer ordered[] = {7,10};
		Bubblesort<Integer> mysort= new Bubblesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT3() {
		Integer array[] = {10,7,1};
		Integer ordered[] = {1,7,10};
		Bubblesort<Integer> mysort= new Bubblesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT4() {
		Integer array[] = {5,1,7,4,6};
		Integer ordered[] = {1,4,5,6,7};
		Bubblesort<Integer> mysort= new Bubblesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT5() {
		Integer array[] = {-1,3,7,-6,5,10,20};
		Integer ordered[] = {-6,-1,3,5,7,10,20};
		Bubblesort<Integer> mysort= new Bubblesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT6() {
		Integer array[] = {-100,3,246,-6,125,-156,2000,1,5678,4};
		Integer ordered[] = {-156,-100,-6,1,3,4,125,246,2000,5678};
		Bubblesort<Integer> mysort= new Bubblesort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT7() {
		Integer array[] = {5,4,-7,2,8,9,-1,1,4,6};
		Integer ordered[] = {5,4,-7,2,8,9,-1,1,4,6};
		Bubblesort<Integer> mysort= new Bubblesort<>();
		
		mysort.sort(array, 5, 4);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT8() {
		Integer array[] = {15,-17,29,40,6645,3,1,563,-987};
		Integer ordered[] = {15,-17,29,-987,1,3,40,563,6645};
		Bubblesort<Integer> mysort= new Bubblesort<>();
		
		mysort.sort(array, 3, 8);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT9() {
		Integer array[] = {30,-18,1,42,1,3,1,569,-900};
		Integer ordered[] = {30,-18,1,1,1,3,42,569,-900};
		Bubblesort<Integer> mysort= new Bubblesort<>();
		
		mysort.sort(array, 2, 7);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT10() {
		Integer array[] = {0,-5,10,-15,20,-25,30,-35,40,-45,50,-55,60};
		Integer ordered[] = {0,-5,10,-15,20,-35,-25,30,40,-45,50,-55,60};
		Bubblesort<Integer> mysort= new Bubblesort<>();
		
		mysort.sort(array, 5, 8);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT11() {
		Integer array[] = {};
		Integer ordered[] = {};
		Selectionsort<Integer> mysort= new Selectionsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT12() {
		Integer array[] = {10};
		Integer ordered[] = {10};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT13() {
		Integer array[] = {10,7};
		Integer ordered[] = {7,10};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT14() {
		Integer array[] = {10,7,1};
		Integer ordered[] = {1,7,10};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT15() {
		Integer array[] = {-6,4,20,-1};
		Integer ordered[] = {-6,-1,4,20};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT16() {
		Integer array[] = {5,1,7,4,6};
		Integer ordered[] = {1,4,5,6,7};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array,0,4);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT17() {
		Integer array[] = {-1,3,7,-6,5,10,20};
		Integer ordered[] = {-6,-1,3,5,7,10,20};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT18() {
		Integer array[] = {-100,3,246,-6,125,-156,2000,1,5678,4};
		Integer ordered[] = {-156,-100,-6,1,3,4,125,246,2000,5678};
		Selectionsort<Integer> mysort= new Selectionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT() {
		Integer array[] = {5,4,-7,2,8,9,-1,1,4,6};
		Integer ordered[] = {5,4,-7,2,8,9,-1,1,4,6};
		Selectionsort<Integer> mysort= new Selectionsort<>();
		
		mysort.sort(array, 5, 4);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT19() {
		Integer array[] = {15,-17,29,40,6645,3,1,563,-987};
		Integer ordered[] = {15,-17,29,-987,1,3,40,563,6645};
		Selectionsort<Integer> mysort= new Selectionsort<>();
		
		mysort.sort(array, 3, 8);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT20() {
		Integer array[] = {30,-18,1,42,1,3,1,569,-900};
		Integer ordered[] = {30,-18,1,1,1,3,42,569,-900};
		Selectionsort<Integer> mysort= new Selectionsort<>();
		
		mysort.sort(array, 2, 7);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT21() {
		Integer array[] = {0,-5,10,-15,20,-25,30,-35,40,-45,50,-55,60};
		Integer ordered[] = {0,-5,10,-15,20,-35,-25,30,40,-45,50,-55,60};
		Selectionsort<Integer> mysort= new Selectionsort<>();
		
		mysort.sort(array, 5, 8);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT100() {
		Integer array[] = {};
		Integer ordered[] = {};
		Insertionsort<Integer> mysort= new Insertionsort<>();
		
		mysort.sort(array);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT101() {
		Integer array[] = {10};
		Integer ordered[] = {10};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT102() {
		Integer array[] = {10,7};
		Integer ordered[] = {7,10};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT103() {
		Integer array[] = {10,7,1};
		Integer ordered[] = {1,7,10};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT104() {
		Integer array[] = {-6,4,20,-1};
		Integer ordered[] = {-6,-1,4,20};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT105() {
		Integer array[] = {5,1,7,4,6};
		Integer ordered[] = {1,4,5,6,7};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array,0,4);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT106() {
		Integer array[] = {-1,3,7,-6,5,10,20};
		Integer ordered[] = {-6,-1,3,5,7,10,20};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT107() {
		Integer array[] = {-100,3,246,-6,125,-156,2000,1,5678,4};
		Integer ordered[] = {-156,-100,-6,1,3,4,125,246,2000,5678};
		Insertionsort<Integer> mysort= new Insertionsort<>();
			
		mysort.sort(array);
			
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT108() {
		Integer array[] = {5,4,-7,2,8,9,-1,1,4,6};
		Integer ordered[] = {5,4,-7,2,8,9,-1,1,4,6};
		Insertionsort<Integer> mysort= new Insertionsort<>();
		
		mysort.sort(array, 5, 4);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT109() {
		Integer array[] = {15,-17,29,40,6645,3,1,563,-987};
		Integer ordered[] = {15,-17,29,-987,1,3,40,563,6645};
		Insertionsort<Integer> mysort= new Insertionsort<>();
		
		mysort.sort(array, 3, 8);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT110() {
		Integer array[] = {30,-18,1,42,1,3,1,569,-900};
		Integer ordered[] = {30,-18,1,1,1,3,42,569,-900};
		Insertionsort<Integer> mysort= new Insertionsort<>();
		
		mysort.sort(array, 2, 7);
		
		assertArrayEquals(ordered, array);
	}
	
	@Test
	public void testSortT111() {
		Integer array[] = {0,-5,10,-15,20,-25,30,-35,40,-45,50,-55,60};
		Integer ordered[] = {0,-5,10,-15,20,-35,-25,30,40,-45,50,-55,60};
		Insertionsort<Integer> mysort= new Insertionsort<>();
		
		mysort.sort(array, 5, 8);
		
		assertArrayEquals(ordered, array);
	}
}

