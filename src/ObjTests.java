import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjTests {

	@Test
	void isAnagramTest() {
		String word = "qwerrty";
		assertTrue(Strings.isAnagram(word, "rwqert"));
		assertTrue(Strings.isAnagram(word, "rterqw"));

		assertFalse(Strings.isAnagram(word, "qwertyuu"));
		assertFalse(Strings.isAnagram(word, "qwer"));
		assertFalse(Strings.isAnagram(word, "qwertg"));
		assertFalse(Strings.isAnagram(word, ""));
	}

	@Test
	void sortStringNumbersTest() {
		String[] array = { "2", "1", "-6", "127","5","2" };
		String[] expected = { "-6", "1", "2","2", "5", "127"};
		Strings.sortStringNumbers(array);
		assertArrayEquals(expected, array);
	}

}
