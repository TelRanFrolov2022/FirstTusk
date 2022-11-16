public class Matrices {
	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue){
		int res[][] = new int [rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = (int) Lottery.getRandomNumber(minValue, maxValue);
			}
		}
		return res;
	}
	public static int[][] transp(int[][] matrix) {
		  int[][] transpmatrix = new int[matrix[0].length][matrix.length];
	        for (int i = 0; i < matrix.length; i++) {
	        	for (int j = 0; j < matrix[0].length; j++) {
	        		transpmatrix[j][i] = matrix[i][j];	
	        	}
	        }
	        return transpmatrix;
	}
	
}