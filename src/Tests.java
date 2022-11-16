import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void test() {
		int i = 123;
		assertEquals(first(i), 1);
		assertEquals(two(i), 2);
		assertEquals(third(i), 3);
	}

	public int first(int i) {
		return (i - i % 100) / 100;
	}

	public int two(int i) {
		return (i % 100 - i % 10) / 10;
	}

	public int third(int i) {
		return i % 10;
	}

	@Test
	void getBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(1, BitOperation.getBitValue(number, 5));
		assertEquals(0, BitOperation.getBitValue(number, 11));
		assertEquals(0, BitOperation.getBitValue(number, 1));
		assertEquals(1, BitOperation.getBitValue(number, 2));
	}

	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperation.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperation.setBitValue(number, 5, true));
	}

	@Test
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperation.revertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperation.revertBitValue(number, 0));
	}

	@Test
	void happyTicketResultTest() {
		int winNumber = 554761;
		int loseNumber = 123456;
		assertEquals(1, Lottery.happyTicket(winNumber));
		assertEquals(0, Lottery.happyTicket(loseNumber));
	}

	@Test
	void happyTicketNumberCorrectnessTest() {
		int notCorrectNumber1 = 1000;
		int notCorrectNumber2 = 1000000000;
		int correctNumber = 123456;
		assertEquals(-1, Lottery.happyTicket(notCorrectNumber1));
		assertEquals(-1, Lottery.happyTicket(notCorrectNumber2));
		assertNotEquals(-1, Lottery.happyTicket(correctNumber));
	}

	@Test
	void verifyTest() {
		int notCorrectNumber = 123456789;
		int CorrectNumber = 123456840;
		assertEquals(false, IsraelIdentity.verify(notCorrectNumber));
		assertEquals(true, IsraelIdentity.verify(CorrectNumber));
	}

	@Test
	void generateRandomIdTest() {
		int id = IsraelIdentity.generateRandomId();
		assertEquals(true, IsraelIdentity.verify(id));
	}

	@Test
	void addsNumberTest() {
		int[] array = { 167, -2, 16, 99, 26, 92, 43, -234, 35, 80 };
		int[] newArray = MyArrays.addsNumber(array, 56);
		assertEquals(56, newArray[array.length]);
	}

	@Test
	void insertSortedTest() {
		int[] array = { 1, 2, 2, 4, 5, 5, 7, 7, 9, 11 };
		int newArray[] = MyArrays.insertSorted(array, 8);
		int newArrayStart[] = MyArrays.insertSorted(array, -30);
		int newArrayEnd[] = MyArrays.insertSorted(array, 453);
		assertEquals(8, newArray[8]);
		assertEquals(-30, newArrayStart[0]);
		assertEquals(453, newArrayEnd[10]);
		
		
		int[] arrays = { 1,2,3, 10, 5,4,11,24};
		System.out.print(MyArrays.isOneSwapForSorted(arrays));
	}
	@Test
	void binarySearchTest() {                        
		int[] ar1 = { 1, 2, 3, 4,4,4,4,4,4,4,4,5,6};      
		assertEquals(1, MyArrays.binarySearch(ar1, 2));
		assertEquals(-1, MyArrays.binarySearch(ar1, 0));
		assertEquals(3,MyArrays.binarySearch(ar1, 4));
	}
	@Test
	void bubbleSort() {
		int[] expectedArray = { 1, 2, 3, 4, 5 };
		int[] ar2 = { 9, 5, 4, 3, 2, 1 };
		int[] ar3 = { 1, 2, 4, 3, 5 };
		int[] ar4 = { 3, 2, 1, 4, 6, 5 };

		assertArrayEquals(expectedArray, MyArrays.bubbleSort(expectedArray));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 9 }, MyArrays.bubbleSort(ar2));
		assertArrayEquals(expectedArray, MyArrays.bubbleSort(ar3));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, MyArrays.bubbleSort(ar4));

	}
	@Test
	void isOneSwapTestFalse() {
	int ar1[] = { 1, 2, 3, 10,1, 5, 6 };
	int ar2[] = { 1, 2, 3, 4, 5, 10 };
	int ar3[] = { 5, 1, 2, 4, 6, 10 };
	int ar4[] = { 1, 5, 2, 4, 3, 10 };
	int ar5[] = {1, 3, 2, 5, 4, 10, 8 };
	int ar6[] = {1, 3, 20, 4, 5, 6, 10};
	int ar7[] = {1, 3, 20, 4, 5, 11, 2};
	assertFalse(MyArrays.isOneSwapForSorted(ar1));
	assertFalse(MyArrays.isOneSwapForSorted(ar2));
	assertFalse(MyArrays.isOneSwapForSorted(ar3));
	assertFalse(MyArrays.isOneSwapForSorted(ar4));
	assertFalse(MyArrays.isOneSwapForSorted(ar5));
	assertFalse(MyArrays.isOneSwapForSorted(ar6));
	assertFalse(MyArrays.isOneSwapForSorted(ar7));
	}
	
	@Test
	void isOneSwapTestTrue() {
	int ar1[] = { 10, 2, 3, 4, 1 };
	int ar2[] = { 1, 2, 4, 3, 5, 10 };
	int ar3[] = { 1, 2, 3, 10, 5, 4 };
	int ar4[] = { 1, 5, 3, 4, 2, 10 };
	int ar5[] = { 1, 2, 3, 4, 10, 5 };
	int ar6[] = { 2, 1,3, 4, 5, 10 };
	int ar7[] = { 3, 2, 1, 4, 5, 6 };
	assertTrue(MyArrays.isOneSwapForSorted(ar1));
	assertTrue(MyArrays.isOneSwapForSorted(ar2));
	assertTrue(MyArrays.isOneSwapForSorted(ar3));
	assertTrue(MyArrays.isOneSwapForSorted(ar4));
	assertTrue(MyArrays.isOneSwapForSorted(ar5));
	assertTrue(MyArrays.isOneSwapForSorted(ar6));
	assertTrue(MyArrays.isOneSwapForSorted(ar7));
	}

	@Test
	void isSum2TestTrue() {
    short ar1[] = { 10, 2, 3, 4, 1 };
	short ar2[] = { 1, 23, 4, 3, 5, 10 };
	short ar3[] = { 8, 2, 4, 10, 5, 4 };
	assertTrue(MyArrays.isSum2(ar1,(short)5));
	assertTrue(MyArrays.isSum2(ar2,(short)28));
	assertTrue(MyArrays.isSum2(ar3,(short)9));
	}
	
	@Test
	void isSum2TestFalse() {
    short ar1[] = { 10, 2, 3, 4, 1 };
	short ar2[] = { 1, 23, 4, 1, 5, 10 };
	short ar3[] = { 8, 2, 4, 10, 5, 4 };
	assertFalse(MyArrays.isSum2(ar1,(short)40));
	assertFalse(MyArrays.isSum2(ar2,(short)7));
	assertFalse(MyArrays.isSum2(ar3,(short)1));
	}

}
