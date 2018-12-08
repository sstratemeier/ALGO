import java.math.BigInteger;

public class Sorting {
    private static final long[] FACTORIAL_TABLE = initFactorialTable();
    private static long[] initFactorialTable() {
        final long[] factorialTable = new long[21];
        factorialTable[0] = 1;
        for (int i=1; i<factorialTable.length; i++)
            factorialTable[i] = factorialTable[i-1] * i;
        return factorialTable;
    }
    /**
     * Actually, even for {@code long}, it works only until 20 inclusively.
     */
    public static long factorial(final int n) {
        return FACTORIAL_TABLE[n];
    }

    public static double lnOfNFac(int n) {
        double main = n * Math.log(n) - 1;
        double s1 = 1d/2d * Math.log(2 * Math.PI * n);
        double s2 = 1d / (12 * n);
        double s3 = 1d / (360 * Math.pow(n, 3));
        double s4 = 1d / (1260 * Math.pow(n, 5));
        return main + s1 + s2 - s3 +s4;
    }

    public static void main(String[] args) {
        for(int i = 59; i <= 59; i++) {
           System.out.println(lnOfNFac(i));
           //System.out.println("a(" + i + ") = \\seqsplit{" + (long)Math.ceil(Math.log(factorial(i)) / Math.log(2)) + "}\\\\");
        }
    }
}
