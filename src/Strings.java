public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 complexity O[N] two passes only
	 *         one additional array only symbols or English letters 1. the same
	 *         length 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		int logicSch = 0;
		int lenght1 = str1.length();
		if (lenght1 == str2.length()) {
			int[] charCounter = new int[Character.MAX_VALUE];
			for (int i = 0; i < lenght1; i++) {
				charCounter[(int) str1.charAt(i)]++;
				charCounter[(int) str2.charAt(i)]--;
			}
			while (logicSch < charCounter.length && charCounter[logicSch] == 0) {
				logicSch++;
			}
		}
		return logicSch == Character.MAX_VALUE ? true : false;
	}

	/**
	 * The method sorts input array of Strings on the place
	 * 
	 * @param arrayOfStrings
	 */
	public static void sortStringNumbers(String[] arrayOfStrings) {
		short offset = Byte.MAX_VALUE + 1;
		int[] helper = new int[offset * 2];
		int j = 0;
		int index = 0;
		for (int i = 0; i < arrayOfStrings.length; i++) {
			helper[Byte.parseByte(arrayOfStrings[i]) + offset]++;
		}
		while (index < arrayOfStrings.length) {
			if (helper[j] == 0) {
				j++;
			} else {
				arrayOfStrings[index] = Integer.toString(j - offset);
				index++;
				helper[j]--;
			}
		}
	}
}