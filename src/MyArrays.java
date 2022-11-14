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

	public static boolean isOneSwapForSorted(int array[]) {
		boolean res = false;
		int sch = 0;
		int temp = array[0];
		int scg = 0;
		int elemOneIndex = 0;
		int elemTwoIndex = 0;
		for (int i = 0; i < array.length - 2; i++) {
			if (array[i] > array[i + 1]) {
				temp = array[i];
				if (scg == 0) {
					elemOneIndex = i;
				} else if (scg == 1) {
					elemTwoIndex = i;
				}
				sch++;
				scg++;
				if (sch > 1 || (array[i + 2] < temp && i != 0)) {
					sch = 3;
					break;
				}
			}
		}
		if (array[array.length - 2] > array[array.length - 1]) {
			sch++;
		}
		if (sch == 1 || (sch == 2 && (array[elemOneIndex] > array[elemTwoIndex])
				&& (array[elemOneIndex] < array[elemTwoIndex + 1]))) {
			res = true;
		}
		return res;
	}

	public static int binarySearch(int[] array, int key) {
		int low = 0;
		int hi = array.length - 1;
		int mid = 0;
		int midRepeat = 0;
		int sch = 0;
		while (low <= hi) {
			mid = (low + hi) >>> 1;
			int d = array[mid];
			if (d == key) {
				while (true) {
					if (array[mid - 1] == key) {
						midRepeat = mid - 1;
						sch++;
					}
					if (array[mid - 1] != key) {
						break;
					}
					mid--;

				}
				if (sch == 0) {
					return mid;
				} else {
					return midRepeat;
				}

			} else if (d > key) {
				hi = mid - 1;
			} else {
				low = ++mid;
			}
		}
		return -mid - 1;
	}

	public static int[] bubbleSort(int[] array) {
		int res[]=array;
		if(isSorted(array)) {
			
		}else {boolean unsorted = true;
		int temp;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < res.length - 1; i++) {
				if (res[i] > res[i + 1]) {
					temp = res[i];
					res[i] = res[i + 1];
					res[i + 1] = temp;
					unsorted = true;
				}
			}
		}}
	
		return res;
	}
	public static boolean isSorted(int[] array) {
		boolean res = true;
		for (int i = 0; i < array.length - 2; i++) {
			if (array[i] > array[i + 1]) {
				res = false;
				break;
			}
		}
		return res;
	}
}
