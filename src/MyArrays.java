import java.util.Arrays;

public class MyArrays {
	public static int[] addsNumber(int[] array, int number) {
		int[] numbersCopy = Arrays.copyOf(array, array.length + 1);
		numbersCopy[array.length] = number;
		return numbersCopy;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array if index
	 *         doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		int[] result = new int[array.length - 1];
		System.arraycopy(array, 0, result, 0, index);
		System.arraycopy(array, index + 1, result, index, array.length - index - 1);
		return result;
	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		int[] result = new int[arraySorted.length + 1];
		int index = Math.abs(Arrays.binarySearch(arraySorted, number)) - 1;
		System.arraycopy(arraySorted, 0, result, 0, index);
		System.arraycopy(arraySorted, index, result, index + 1, arraySorted.length - index);
		result[index] = number;
		return result;
	}
}
//1 2 2 4 5 5 7 7 9 11
//0 1 2 3 4 5 6 7 8 9  -9
//1 2 2 4 5 5 7 7 0 0 0
