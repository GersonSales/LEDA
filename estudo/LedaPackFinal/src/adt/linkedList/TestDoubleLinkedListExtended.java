package adt.linkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDoubleLinkedListExtended {

	private DoubleLinkedListExtended<String> list1;
	private DoubleLinkedListExtended<String> list2;
	private DoubleLinkedListExtended<String> list3;

	private String[] listSortedAsArray;
	private String[] list2InvertedAsArray;
	private String[] list3InvertedAsArray;

	@Before
	public void setUp() throws Exception {

		// list1
		list1 = new DoubleLinkedListExtendedImpl<String>();
		list1.insert("3");
		list1.insert("1");
		list1.insert("5");
		list1.insert("4");
		list1.insert("2");

		// list2
		list2 = new DoubleLinkedListExtendedImpl<String>();
		list2.insert("5");
		list2.insert("4");
		list2.insert("3");
		list2.insert("2");
		list2.insert("1");

		// list2
		list3 = new DoubleLinkedListExtendedImpl<String>();
		list3.insert("5");
		list3.insert("4");
		list3.insert("3");
		list3.insert("2");
		list3.insert("1");
		list3.insert("0");

		listSortedAsArray = new String[] { "1", "2", "3", "4", "5" };
		list2InvertedAsArray = new String[] { "3", "2", "1", "5", "4" };
		list3InvertedAsArray = new String[] { "2", "1", "0", "5", "4", "3" };

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertionSortTC01() {
		list1.insertionSort();
		Assert.assertArrayEquals(listSortedAsArray, list1.toArray());
	}

	@Test
	public void testInsertionSortTC02() {
		list2.insertionSort();
		Assert.assertArrayEquals(listSortedAsArray, list2.toArray());
	}

	@Test
	public void testSplitAndInvertTC03() {
		list2.splitAndInvert();
		Assert.assertArrayEquals(list2InvertedAsArray, list2.toArray());
	}

	@Test
	public void testSplitAndInvertTC04() {
		list3.splitAndInvert();
		Assert.assertArrayEquals(list3InvertedAsArray, list3.toArray());
	}

}
