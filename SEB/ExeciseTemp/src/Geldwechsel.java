import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Geldwechsel {
    static int betrag[] = {2, 5, 7, 9};
    static int n = betrag.length;
    final static LinkedHashMap<Key, BigInteger> table = new LinkedHashMap<Key, BigInteger>() {
        @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > 55; // 11 * 5
        }
    };

    public static class Key {
        int int1;
        int int2;
        public Key(int int1, int int2) {
            this.int1 = int1;
            this.int2 = int2;
        }

        @Override
        public boolean equals(Object obj) {
            Key other = (Key) obj;
            return int1 == other.int1 && int2 == other.int2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(int1, int2);
        }
    }

    public static BigInteger count(int g, int m) {
        for (int i = 0; i <= g + 1; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    table.put(new Key(i, j), BigInteger.ONE);
                } else if (j == 0) {
                    if (i % betrag[j] == 0) {
                        table.put(new Key(i, j), BigInteger.ONE);
                    } else {
                        table.put(new Key(i, j), BigInteger.ZERO);
                    }
                } else if (betrag[j] > i) {
                    table.put(new Key(i, j), table.get(new Key(i, j - 1)));
                } else {
                    table.put(new Key(i, j), table.get(new Key(i - betrag[j], j)).add(table.get(new Key(i, j - 1))));
                }
            }
        }
        return table.get(new Key(g, m));
    }

    public static void main(String[] args) {
        //int exp = 3;
        //int g = (int) Math.pow(5, exp);

        int g = 14;
        long startTime = System.nanoTime();
        for(int i = 0; i<= 14; i++) {
            System.out.println("Den Betrag " + i + " kann man auf " + count(i, n - 1) + " verschiedene Arten wechseln.");
        }
       /* System.out.println("Den Betrag " + g + " kann man auf " +
                count(g, n - 1) + " verschiedene Arten wechseln.");*/
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000000;  //divide by 1000000 to get milliseconds.
        System.out.println("Zeit: " + duration + "s");

    }
}
