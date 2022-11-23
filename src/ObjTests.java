import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

class ObjTests {

	@Test
	@Disabled
	void isAnagramTest() {
		String word = "qwerrty";
		assertTrue(Strings.isAnagram(word, "rterqw"));

		assertFalse(Strings.isAnagram(word, "qwertyuu"));
		assertFalse(Strings.isAnagram(word, "qwer"));
		assertFalse(Strings.isAnagram(word, "qwertg"));
		assertFalse(Strings.isAnagram(word, ""));
	}

	@Test
	void sortStringNumbersTest() {
		String[] array = { "2", "1", "-6", "127", "5", "2" };
		String[] expected = { "-6", "1", "2", "2", "5", "127" };
		Strings.sortStringNumbers(array);
		assertArrayEquals(expected, array);
	}

	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}

	@Test
	void ipV40OctetTest() {
		assertTrue("196".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));


		assertFalse(" 1".matches(Strings.ipV4Octet()));
		assertFalse("230 120".matches(Strings.ipV4Octet()));
		assertFalse("03".matches(Strings.ipV4Octet()));
	}

	@Test
	void ipV40Test() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("1.0.148.122".matches(Strings.ipV4()));

		assertFalse("05.220.1310.100".matches(Strings.ipV4()));
		assertFalse("777.7777.40.20".matches(Strings.ipV4()));;

	}

}
