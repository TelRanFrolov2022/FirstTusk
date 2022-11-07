import static org.junit.Assert.assertEquals;
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

}
