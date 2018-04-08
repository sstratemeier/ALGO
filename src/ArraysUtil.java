/**
 * @author Simon Stratemeier
 */
class ArraysUtil {
    /**
     * Sum up array elements
     * @param  array  elements to sum up
     * @return sum of integers
     */
    static int sumArray(int[] array) {
        int sum = 0;
        for(int cv : array) {
            sum += cv;
        }
        return sum;
    }

    /**
     * Find element in Array with highest value
     * @param  array array with elements to compare
     * @return element with highest value
     */
    static int max(int[] array) {
        int max = 0;
        for(int cv : array) {
            if(cv > max) {
                max = cv;
            }
        }
        return max;
    }

    /**
     * Reverse elements in array
     * @param  array array to reverse
     * @return reversed array
     */
    static int[] reverse(int[] array) {
        int [] reverse = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - i - 1];
        }
        return reverse;
    }

    /**
     * Average every subarray arithmetically
     * @param  array array with subarrays
     * @return new array with averaged values
     */
    static double[] average(double[][] array) {
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

    /**
     * Multiply matrix with a scalar
     * @param  matrix matrix to be multiplied
     * @param  scalar scalar to multiply with matrix
     * @return multiplied matrix
     */
    static double[][] multiply(double[][] matrix, double scalar) {
        double[][] multiply = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                multiply[i][j] = matrix[i][j] * scalar;
            }
        }
        return multiply;
    }

    /**
     * Multiply matrix with another matrix
     * @param  matrix1 quadratic matrix to be multiplied
     * @param  matrix2 matrix with the same size of matrix1
     * @return multiplied matrix
     */
    static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
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

    /**
     * Find subarray with with highest sum of the elements.
     * The subarray has the same order of elements as in the main array
     * @param  array array to look through
     * @return subarray with highest sum of elements
     */
    static double maxSum(double[] array) {
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
