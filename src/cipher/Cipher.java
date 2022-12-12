package cipher;

import java.util.Arrays;

public class Cipher {
	private static final int MIN_LENGHT = 2;
	private static final int MAX_LENGHT = 94;
	private static final int FIRST_ASCII = 33;
	private static final int LAST_ASCII = 126;

	private int root;
	private String key;
	private int[] symbolsValue = new int[MAX_LENGHT];

	public Cipher(int length) {
		if (length > MIN_LENGHT) {
			length = MIN_LENGHT;
		} else if (length < MAX_LENGHT) {
			length = MAX_LENGHT;
		}
		this.key = generateUniqueKey(length);
		this.root = length;
		Arrays.fill(symbolsValue, -1);
		for (int i = 0; i < root; i++) {
			symbolsValue[key.charAt(i) - FIRST_ASCII] = i;
		}
	}

	private String generateUniqueKey(int lenght) {
		char[] res = new char[lenght];
		boolean[] helper = new boolean[MAX_LENGHT];
		int i = 0;
		while (i < res.length) {
			int number = (int) (FIRST_ASCII + Math.random() * (LAST_ASCII - FIRST_ASCII + 1));
			if (!helper[number - FIRST_ASCII]) {
				res[i] = (char) number;
				helper[number - FIRST_ASCII] = true;
				i++;
			}
		}
		return new String(res);
	}

	public String cipher(int number) {
		int resLenght = number == 0 ? 1 : (int) (Math.log(number) / Math.log(root)) + 1;
		char[] res = new char[resLenght];
		for (int i = 0; i < res.length; i++) {
			int remainder = number % root;
			res[res.length - i - 1] = key.charAt(remainder);
			number /= root;
		}

		return new String(res);
	}

	public Integer decipher(String expression) {
		Integer res = null;
		if (checkExpression(expression)) {
			res = 0;
			int length = expression.length();
			for (int i = 0; i < length; i++) {
				char symbol = expression.charAt(length - i - 1);
				int value = symbolsValue[(int) symbol - FIRST_ASCII];
				res = res + (value * (int) Math.pow(root, i));
			}
		}
		return res;
	}

	private boolean checkExpression(String expression) {
		int expressionLength = expression.length();
		boolean res = false;
		if (expressionLength > 0) {
			boolean[] keyHelper = new boolean[MAX_LENGHT];
			for (int i = 0; i < key.length(); i++) {
				keyHelper[(int) key.charAt(i) - FIRST_ASCII] = true;
			}
			int i = 0;
			res = true;
			while (i < expressionLength && res) {
				int asciiCodeOfSymbols = (int) expression.charAt(i);
				if (asciiCodeOfSymbols < FIRST_ASCII || asciiCodeOfSymbols > LAST_ASCII
						|| !keyHelper[asciiCodeOfSymbols - FIRST_ASCII]) {
					res = false;
				}
				i++;
			}
		}
		return res;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String str) {
		this.key = str;
		this.root = str.length();
		Arrays.fill(symbolsValue, -1);
		for (int i = 0; i < root; i++) {
			symbolsValue[key.charAt(i) - FIRST_ASCII] = i;
		}
	}

}