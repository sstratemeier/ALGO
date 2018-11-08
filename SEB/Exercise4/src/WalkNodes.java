import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Simon Stratemeier 199067
 */
public class WalkNodes {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bitte n angeben:");
    int n = scanner.nextInt();
    PathCounter pathCounter  = new PathCounter(n);
    System.out.println("Count paths: " + pathCounter.countPaths());
    System.out.println("Count points visited: " + pathCounter.countPoints());
  }

  static class PathCounter {
    private int n;
    private Paths[][][] cache;

    BigInteger countPaths() {
      return countPaths(0, 0, Vector.ZERO).getCountPaths();
    }

    BigInteger countPoints() {
      return countPaths(0, 0, Vector.ZERO).getCountPoints();
    }

    private Paths countPaths(int x, int y, Vector src) {
      if (outOfBoundaries(x, y)) {
        return Paths.ZERO;
      } else if (targetReached(x, y)) {
        // Don´t return new Paths(BigInteger.ONE, steps) -> Wrong result
        // instead return Paths.ONE <- Credits to Tobias Fetzer 198318
        return Paths.ONE;
      } else if (isCached(x, y, src)) {
        return cache[x][y][src.getCacheId()];
      } else {
        Paths paths = Paths.ZERO; // Sum of all points to destination
        for (Vector vec : src.getNextVectors()) {
          paths = paths.add(countPaths(vec.x(x), vec.y(y), vec));
        }
        cache[x][y][src.getCacheId()] = paths;
        return paths;
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

    PathCounter(int n) {
      this.n = n;
      cache = new Paths[n+1][n+1][5];
    }
  }

  /**
   * Replacement of BigInt
   * Paths-Objects have a special add method
   */
  static class Paths {
    private BigInteger countPaths;
    private BigInteger countPoints;

    BigInteger getCountPoints() {
      return countPoints;
    }

    BigInteger getCountPaths() {
      return countPaths;
    }

    Paths(BigInteger countPaths, BigInteger countPoints) {
      this.countPaths = countPaths;
      this.countPoints = countPoints;
    }

    Paths add(Paths paths) {
      return new Paths(
          getCountPaths().add(paths.getCountPaths()), // Sum count paths normally
          getCountPoints().add(paths.getCountPaths().add(paths.getCountPoints())) // Sum points + countPaths to destination because Points can be used multiple times
      );
    }

    static final Paths ZERO = new Paths(BigInteger.ZERO, BigInteger.ZERO);
    static final Paths ONE = new Paths(BigInteger.ONE, BigInteger.ONE);
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

    static {
      Vector.RIGHT.setNextVectors(new Vector[] {Vector.RIGHT, Vector.LEFTUP, Vector.RIGHTDOWN, Vector.RIGHTUP});
      Vector.UP.setNextVectors(new Vector[] {Vector.UP, Vector.LEFTUP, Vector.RIGHTDOWN});
      Vector.LEFTUP.setNextVectors(new Vector[] {Vector.RIGHT, Vector.UP, Vector.LEFTUP, Vector.RIGHTUP});
      Vector.RIGHTDOWN.setNextVectors(new Vector[] {Vector.RIGHT, Vector.UP, Vector.RIGHTDOWN, Vector.RIGHTUP});
      Vector.RIGHTUP.setNextVectors(new Vector[] {Vector.RIGHT, Vector.LEFTUP, Vector.RIGHTDOWN, Vector.RIGHTUP});
      Vector.ZERO.setNextVectors(new Vector[] {Vector.RIGHT, Vector.UP, Vector.LEFTUP, Vector.RIGHTDOWN, Vector.RIGHTUP});
    }

    Vector(int id, int dx, int dy) {
      this.cacheId = id;
      this.dx = dx;
      this.dy = dy;
    }
  }
}
