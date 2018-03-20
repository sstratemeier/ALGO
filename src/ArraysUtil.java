/**
 * @author Simon Stratemeier
 */
public class ArraysUtil {
    public static int sumArray(int[] array) {
        int sum = 0;
        for(int cv : array) {
            sum += cv;
        }
        return sum;
    }

    public static int max(int[] array) {
        int max = 0;
        for(int cv : array) {
            if(cv > max) {
                max = cv;
            }
        }
        return max;
    }

    public static int[] reverse(int[] array) {
        int [] reverse = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - i - 1];
        }
        return reverse;
    }

    public static double[] average(double[][] array) {
        double[] average = new double[array.length];
        for(int i = 0; i < array.length; i++) {
            double sum = 0;
            for(double cv : array[i]) {
                sum += cv;
            }
            average[i] = sum / array[i].length;
        }
        return average;
    }

    public static double[][] multiply(double[][] matrix, double scalar) {
        double[][] multiply = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                multiply[i][j] = matrix[i][j] * scalar;
            }
        }
        return multiply;
    }

    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] multiply = new double[matrix1.length][matrix1.length];
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix1.length; j++) {
                multiply[i][j] = 0;
                for(int k = 0; k < matrix1.length; k++) {
                    multiply[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return multiply;
    }

    public static double maxSum(double[] array) {
        double sum = 0;
        for(int i = 1; i <= array.length; i++) {
            for(int j = 0; j <= array.length - i; j++) {
                double sumArray = 0;
                double[] currentArray = java.util.Arrays.copyOfRange(array, j, j + i);
                for(double cv : currentArray) {
                    sumArray += cv;
                }
                if(sumArray > sum) {
                    sum = sumArray;
                }
            }
        }
        return sum;
    }
}
