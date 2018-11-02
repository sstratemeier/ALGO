import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Simon Stratemeier
 */
class RecursionTest {

    @Test
    void recusiveSum() {
        assertEquals(15, Recursion.recusiveSum(5));
        assertEquals(21, Recursion.recusiveSum(6));
    }

    @Test
    void iterativeSum() {
        assertEquals(15, Recursion.iterativeSum(5));
        assertEquals(21, Recursion.iterativeSum(6));
    }

    @Test
    void recursiveFibonacci() {
        assertEquals(1, Recursion.recursiveFibonacci(0));
        assertEquals(1, Recursion.recursiveFibonacci(1));
        assertEquals(13, Recursion.recursiveFibonacci(6));
    }

    @Test
    void iterativeFibonacci() {
        assertEquals(1, Recursion.iterativeFibonacci(0));
        assertEquals(1, Recursion.iterativeFibonacci(1));
        assertEquals(13, Recursion.iterativeFibonacci(6));
    }

    @Test
    void iterativeOldEuclid() {
        assertEquals(20, Recursion.iterativeOldEuclid(40, 100));
        assertEquals(1, Recursion.iterativeOldEuclid(3, 10));
    }

    @Test
    void recursiveOldEuclid() {
        assertEquals(20, Recursion.recursiveOldEuclid(40, 100));
        assertEquals(1, Recursion.recursiveOldEuclid(3, 10));
    }

    @Test
    void recursiveModernEuclid() {
        assertEquals(20, Recursion.recursiveModernEuclid(40, 100));
        assertEquals(1, Recursion.recursiveModernEuclid(3, 10));
    }

    @Test
    void iterativeModernEuclid() {
        assertEquals(20, Recursion.iterativeModernEuclid(40, 100));
        assertEquals(1, Recursion.iterativeModernEuclid(3, 10));
    }
}