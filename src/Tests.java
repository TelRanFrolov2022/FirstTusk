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
	}

}
