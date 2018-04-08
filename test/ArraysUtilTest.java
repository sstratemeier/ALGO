import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Simon Stratemeier
 */
class ArraysUtilTest {

    @Test
    void sumArray() {
        int[] a = {1, 2, 3, 4};
        assertEquals(10, ArraysUtil.sumArray(a));
    }

    @Test
    void max() {
        int[] a = {3, 2, 4, 1};
        assertEquals(4, ArraysUtil.max(a));
    }

    @Test
    void reverse() {
        int[] a = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};
        assertTrue(Arrays.equals(expected, ArraysUtil.reverse(a)));
    }

    @Test
    void average() {
        double[][] a = {{1, 2}, {10, 20}, {-5, 5}};
        double[] expected = {1.5, 15, 0};
        assertTrue(Arrays.equals(expected, ArraysUtil.average(a)));
    }

    @Test
    void multiply() {

        double[][] a = {{1, 2}, {3, 4}, {5, 6}};
        double b = 2;
        double[][] expected = {{2, 4}, {6, 8}, {10, 12}};
        assertTrue(Arrays.deepEquals(expected, ArraysUtil.multiply(a,b)));
    }

    @Test
    void multiplyMatrix() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};
        double[][] expected = {{19, 22}, {43, 50}};
        assertTrue(Arrays.deepEquals(expected, ArraysUtil.multiplyMatrix(a,b)));
    }

    @Test
    void maxSum() {
        double[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        double expected = 6;
        assertEquals(expected, ArraysUtil.maxSum(a));
    }
}