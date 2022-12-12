package cipher;

import cipher.Cipher;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CipherTest {

	@Test
	void testCipherDeciper() {
		int length = 22;
		int testNumber = 9998;
		Cipher testCipher = new Cipher(length);
		String testCode = testCipher.cipher(testNumber);
		assertEquals(testNumber, testCipher.decipher(testCode));
	}
}