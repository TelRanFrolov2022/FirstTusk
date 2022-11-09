
public class IsraelIdentity {
	public static final int NUMBER_OF_CHARACTERS_ID = 9;

	public static boolean verify(int id) {
		boolean res = false;
		int N = Numbers.getNdigits(id);
		if (N == NUMBER_OF_CHARACTERS_ID) {
			int sum = logicSum(id);
			if (sum % 10 == 0) {
				res = true;
			}
		}
		return res;
	}

	public static int generateRandomId() {
		int res = 0;
		int id = Lottery.getRandomNumber(100000000, 999999999);
		int number = 2;
		if (verify(id)) {
			res = id;
		} else {
			int digitsId[] = Numbers.getDigits(id);
			int sum = logicSum(id);
			sum = sum - digitsId[number];
			if (sum % 10 == 0) {
				int newNumber = 0;
				digitsId[number] = newNumber;
				res = Numbers.getNumberFromDigits(digitsId);
			} else {
				int disch = sum - sum % 10;
				int newNumber = disch + 10 - sum;
				digitsId[number] = newNumber;
				res = Numbers.getNumberFromDigits(digitsId);
			}
		}
		return res;
	}

	public static int logicSum(int id) {
		int N = NUMBER_OF_CHARACTERS_ID;
		int digitsId[] = Numbers.getDigits(id);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				sum += digitsId[i];
			} else {
				if (digitsId[i] < 5) {
					sum += digitsId[i] * 2;
				} else {
					int mtrx[] = Numbers.getDigits(digitsId[i] * 2);
					sum += mtrx[0] + mtrx[1];
				}
			}
		}
		return sum;
	}

}