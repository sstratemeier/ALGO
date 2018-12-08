public class MTFSort {
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

    public static void main(String[] args) {
        for(int i = 0; i <= 7; i++) {
            System.out.println(getAverageMoves(i));
        }
    }

    public static long getMoves(int n) {
        return n <= 0 ? 0
                : getMoves(n - 1) * n + factorial(n - 1) * ((long)Math.pow(2, n - 1) - 1);

    }

    public static double getAverageMoves(int n) {
        return n <= 0 ? 0
                : getAverageMoves(n -1)  + (Math.pow(2, n - 1) - 1) / n;
    }
}
