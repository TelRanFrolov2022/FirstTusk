public class Lottery {
	public static void main(String[] args) {
		getTicketNumbers();
	}

	public static void getTicketNumbers() {
		int i = 0;
		long sensorNumber = 0;
		while (i < 6) {
			int number = getRandomNumber(1, 49);
			if (BitOperation.getBitValue(sensorNumber, number) == 0) {
				sensorNumber = BitOperation.setBitValue(sensorNumber, number, true);
				i++;
				System.out.print(number + " ");
			}
		}
	}

	public static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	public static int happyTicket(int number) {
		int res = -1;
		if (number > 999999 || number < 100000) {
			res = -1;
		} else {
			int first = (number - number % 100000) / 100000;
			int second = (number % 100000 - number % 10000) / 10000;
			int third = (number % 10000 - number % 1000) / 1000;
			int fourth = (number % 1000 - number % 100) / 100;
			int fifth = (number % 100 - number % 10) / 10;
			int sixth = number % 10;
			if (first + second + third == fourth + fifth + sixth) {
				res = 1;
			} else {
				res = 0;
			}
		}
		return res;
	}
}
