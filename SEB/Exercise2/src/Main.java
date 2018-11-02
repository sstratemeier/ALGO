import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Simon Stratemeier 199067
 */
public class Main {
  public static void main(String[] args) {
    Vector.RIGHT.setNextVectors(new Vector[] {Vector.RIGHT, Vector.LEFTUP, Vector.RIGHTDOWN, Vector.RIGHTUP});
    Vector.UP.setNextVectors(new Vector[] {Vector.UP, Vector.LEFTUP, Vector.RIGHTDOWN});
    Vector.LEFTUP.setNextVectors(new Vector[] {Vector.RIGHT, Vector.UP, Vector.LEFTUP, Vector.RIGHTUP});
    Vector.RIGHTDOWN.setNextVectors(new Vector[] {Vector.RIGHT, Vector.UP, Vector.RIGHTDOWN, Vector.RIGHTUP});
    Vector.RIGHTUP.setNextVectors(new Vector[] {Vector.RIGHT, Vector.LEFTUP, Vector.RIGHTDOWN, Vector.RIGHTUP});
    Vector.ZERO.setNextVectors(new Vector[] {Vector.RIGHT, Vector.UP, Vector.LEFTUP, Vector.RIGHTDOWN, Vector.RIGHTUP});
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bitte n angeben:");
    int n = scanner.nextInt();
    long start = System.currentTimeMillis();
    BigInteger countPaths = new PathCounter(n).countPaths();
    long time = System.currentTimeMillis() - start;
    System.out.println("n = " + n + ": " + countPaths);
    System.out.println(time + " ms");
  }
}


enum Vector {
  RIGHT(0, 1, 0), UP(1, 0, 1), LEFTUP(2, -1, 1), RIGHTDOWN(3, 1, -1), RIGHTUP(0, 1, 1), ZERO(4, 0, 0);

  private int dx;
  private int dy;
  private int cacheId;
  private Vector[] nextVectors;

  public int x (int srcX) {
    return srcX + dx;
  }
  public int y (int srcY) {
    return srcY + dy;
  }
  public int getCacheId() {
    return cacheId;
  }
  public void setNextVectors(Vector[] nextVectors) {
    this.nextVectors = nextVectors;
  }
  public Vector[] getNextVectors() {
    return nextVectors;
  }

  Vector(int id, int dx, int dy) {
    this.cacheId = id;
    this.dx = dx;
    this.dy = dy;
  }
}

class PathCounter {
  private int n;
  private BigInteger[][][] cache;

  public BigInteger countPaths() {
    return countPaths(0, 0, Vector.ZERO);
  }

  private BigInteger countPaths(int x, int y, Vector src) {
    if (outOfBoundaries(x, y)) {
      return BigInteger.ZERO;
    } else if (targetReached(x, y)) {
      return  BigInteger.ONE;
    } else if (isCached(x, y, src)) {
      return cache[x][y][src.getCacheId()];
    } else {
      BigInteger countPaths = BigInteger.ZERO;
      for (Vector vec : src.getNextVectors()) {
        countPaths = countPaths.add(countPaths(vec.x(x), vec.y(y), vec));
      }
      cache[x][y][src.getCacheId()] = countPaths;
      return countPaths;
    }
  }

  private boolean isCached(int x, int y, Vector src) {
    return  cache[x][y][src.getCacheId()] != null;
  }

  private boolean outOfBoundaries(int x, int y) {
    return  x < 0 || y < 0 || y > n - x;
  }

  private boolean targetReached(int x, int y) {
    return x == n && y == 0;
  }

  public PathCounter(int n) {
    this.n = n;
    cache = new BigInteger[n+1][n+1][5];
  }
}



