package telran;
import java.util.Arrays;  
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
		boolean res=false;
		int lenght1 = str1.length();
		
		if (lenght1 == str2.length()) {
			int[] count = new int[Character.MAX_VALUE];
			for (int i = 0; i < lenght1; i++) {
				count[(int) str1.charAt(i)]++;
				count[(int) str2.charAt(i)]--;
			}
			while (logicSch < count.length && count[logicSch] == 0) {
				logicSch++;
			}
		}
		
		if(logicSch==Character.MAX_VALUE) {
			res=true;
		}
		
		return res;
	}

	/**
	 * The method sorts input array of Strings on the place
	 * 
	 * @param arrayOfStrings
	 */
	public static void sortStringNumbers(String[] arrayOfStrings) {
		int sch = 0;
		int index = 0;
		short n = Byte.MAX_VALUE + 1;
		int[] helper = new int[n * 2];
		for (int i = 0; i < arrayOfStrings.length; i++) {
			helper[Byte.parseByte(arrayOfStrings[i]) + n]++;
		}
		while (index < arrayOfStrings.length) {
			if (helper[sch] == 0) {
				sch++;
			} else {
				arrayOfStrings[index] = Integer.toString(sch - n);
				helper[sch]--;
				index++;
			}
		}
	}

	public static String javaNameExp() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}

	public static String ipV4Octet() {
		return "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
	}

	public static String ipV4() {
		short number = 4;
		String res = "";
		int i=0;
		while(i<number - 1) {
			res += ipV4Octet() + "\\.";
			i++;
		}
		return res + ipV4Octet();
	}
	static String arithmeticExpression() {
		String operator = operator();
		String operand= operand();

		return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operand, operator);
	}

	static String operand() {
		return String.format("(%s|%s)", returnNumber(), javaNameExp());
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {
		return "([-+*/])";
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
	
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
			
		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if(!Double.isNaN(operand2)) {
			switch(operator) {
			case "+": res = operand1 + operand2; break;
			case "-": res = operand1 - operand2; break;
			case "*": res = operand1 * operand2; break;
			case "/": res = operand1 / operand2; break;
			default: res = Double.NaN;
			}
		}
		return res;
	}
	public static String returnNumber() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}
	private static Double getOperandValue(String operand, double[] values, String[] names) {
		Double res = Double.NaN;
		if (operand.matches(returnNumber())) {
			res = Double.parseDouble(operand);
		} else {
			int index = Arrays.binarySearch(names, operand);
			res = (index != -1) ? values[index] : res;
		}
		return res;
	}

	public static boolean checkBraces(String expression) {
		int count = 0, i = 0, length = expression.length();
		while (i < length && count > -1) {
			if (expression.charAt(i) == '(') {
				count++;
			} else if (expression.charAt(i) == ')') {
				count--;
			}
			i++;
		}
		return count == 0;
	}
}