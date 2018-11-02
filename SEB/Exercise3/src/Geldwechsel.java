import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Geldwechsel {
  static int betrag[] = {2, 3, 5, 5, 11};
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
    int exp = 3;
    int g = (int) Math.pow(5, exp);

    long startTime = System.nanoTime();
    System.out.println("Den Betrag " + g + " kann man auf " +
        count(g, n - 1) + " verschiedene Arten wechseln.");
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000000;  //divide by 1000000 to get milliseconds.
    System.out.println("Zeit: " + duration + "s");

  }
}

  /*
  static BigInteger cache[][];

  static BigInteger possibilities(int g, int i) {
    return g < 0 ? BigInteger.ZERO // Geldbetrag negativ -> letze Münze war zu groß
        : i == 0 ? (g % betrag[0] == 0 ? BigInteger.ONE : BigInteger.ZERO) // Kleinste Münze erreicht, füge Möglichkeit hinzu, falls sie passt
        : cache[g][i] != null ? cache[g][i] // Cache
        : (cache[g][i] = possibilities(g, i - 1) // Möglichkeiten mit nächstkleinerer Münze
        .add(possibilities(g - betrag[i], i))); // Möglichkeiten kleinerem Betrag
  }
*/

/*
final static int maxSize = 500;
  final static LinkedHashMap<String, BigInteger> cache2 = new LinkedHashMap<String, BigInteger>() {
    @Override
    protected boolean removeEldestEntry(final Map.Entry eldest) {
      return size() > maxSize;
    }
  };
 */

/*
static BigInteger possibilities4(int g, int i) {
    if (g < 0) { // Coin too big
      return BigInteger.ZERO;
    } else if (i == 0 && g % betrag[0] == 0) {
      return BigInteger.ONE;
    } else if (i == 0) {
      return BigInteger.ZERO;
    } else if (cache[g][i] != null) {
      return cache[g][i];
    } else {
      return possibilities4(g, i - 1).add(possibilities4(g - betrag[i], i));
    }
  }
 */

/*

  static int count3(int S[], int m, int n) {
    // If n is 0 then there is 1 solution
    // (do not include any coin)
    if (n == 0)
      return 1;

    // If n is less than 0 then no
    // solution exists
    if (n < 0)
      return 0;

    // If there are no coins and n
    // is greater than 0, then no
    // solution exist
    if (m <=0 && n >= 1)
      return 0;

    if (m == 0 && n % S[m] == 0) {
        return 1;
        } else if (m == 0) {
        return 0;
        }

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count3(S, m - 1, n) +
        count3(S, m, n - S[m]);
        }
 */

/*System.out.println("Den Betrag " + g + " kann man auf " +
        count3(betrag, n-1, g) + " verschiedene Arten wechseln.");*/

    /*System.out.println("Den Betrag " + g + " kann man auf " +
        possibilities(g, n - 1) + " verschiedene Arten wechseln.");*/
    /*
    for (BigInteger[] x : cache)
    {
      for (BigInteger y : x)
      {
        System.out.print(y + " ");
      }
      System.out.println();
    }*/

/*
public static BigInteger count2(int g, int m) {
    //HashMap<String, Integer> table = new HashMap<>();
    int[][] table = new int[27][5];
    for (int i = 0; i <= g + 1; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0) { // Kein Geld mehr
          table[i][j] = 1;
        } else if (j == 0) { // Kleinster Betrag und Geldbetrag dadurch Teilbar
          table[i][j] = i % betrag[j] == 0 ? 1 : 0;
        } else if (betrag[j] > i) { // Münzwert zu groß, hole Ergebnisse mit kleinerem Münzwert.
          table[i][j] = table[i][j - 1];
        } else { // Münze passt in Betrag und Rest ist übrig
          table[i][j] = table[i - betrag[j]][j] + table[i][j - 1];
        }
      }
    }

    return BigInteger.valueOf(table[g][m]);
  }
  */

  /*
  for i from 0 to n+1
      for j from 0 to m
      if i equals 0
  table[i][j] = 1
      else if j equals 0
      if i%S[j] equals 0
  table[i][j] = 1
      else
  table[i][j] = 0;
      else if S[j] greater than i
  table[i][j] = table[i, j - 1]
      else
  table[i][j] = table[i - S[j], j] + table[i, j-1]

      return table[n, m-1]
      */

  /*
  static long possibilities2(int g, int i) {
    int possibilities = 0;
    while (i >= 0) {
      while (g >= 0) {
        if (g < 0) {
          possibilities += 0;
        } else if (i == 0 && g % betrag[0] == 0) {
          possibilities += 1;
        } else if (i == 0) {
          possibilities += 0;
        }
        g -= betrag[i];
      }
      i--;
    }
    return possibilities;
  }
*/

  /*
  static long possibilities3(int g, int i) {
    if (g < 0) {
      return 0;
    } else {
      if (i == 0) {
        if (g % betrag[0] == 0) {
          return 1;
        } else {
          return 0;
        }
      } else {
        if (cache[g][i] != 0) {
          return cache[g][i];
        } else {
          cache[g][i] = possibilities3(g, i - 1) + possibilities3(g - betrag[i], i);
          return cache[g][i];
        }
      }
    }
  }*/