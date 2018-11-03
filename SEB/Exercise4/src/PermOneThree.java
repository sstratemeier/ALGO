import java.util.*;

/**
 * @author Simon Stratemeier 199067
 */
public class PermOneThree {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //System.out.println("Bitte n angeben:");
    //int n = scanner.nextInt();
    int n = 20;
    int count = 0;
    long startTime = System.nanoTime();
    PermGenerator permGenerator  = new PermGenerator(n);
    while (permGenerator.hasNext()) {
      //permGenerator.getNext();
      System.out.println(Arrays.toString(permGenerator.getNext()));
      count++;
    }
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
    System.out.println("Time: " + duration + "ms");
    System.out.println("Count: " + count);
  }

  static class PermGenerator {
    int n;
    int[] permutation;
    int indexCol = 0;
    boolean nextCalculated;
    Set<Integer> usableNumbers;
    int[] deltas = new int[]{-4, -1, 1, 4};
    HashMap<Set<Integer>, int[][]> cache= new HashMap<>();

    private boolean nextPossibility(int column) {
      int currentValue =  permutation[column];
      int previousNum = column == 0 ? currentValue : permutation[column - 1];
      for (int delta : deltas) {
        int possibleValue = previousNum + delta;
        if (usableNumbers.contains(possibleValue) && possibleValue > currentValue) {
          set(column, possibleValue);
          return true;
        }
      }
      set(column, 0);
      return false;
    }


    public void set(int index, int value) {
      if(value == 0) {
        usableNumbers.add(permutation[index]);
      } else {
        if(permutation[index] != 0) usableNumbers.add(permutation[index]);
        usableNumbers.remove(value);
      }
      permutation[index] = value;
    }

    public boolean calculateNext() {
      while (indexCol >= 0) {
        if(indexCol == n) {
          nextCalculated = true;
          indexCol--; // Find other solutions
          return true;
        } if (nextPossibility(indexCol)) {
          indexCol++; // Working?
        } else {
          indexCol--; // Backtrack
        }
      }
      return false;
    }

    public boolean hasNext() {
      return calculateNext();
    }

    public int[] getNext() {
      if(!nextCalculated) {
        calculateNext();
      } else {
        nextCalculated = false;
      }
      return permutation;
    }

    public PermGenerator(int n) {
      this.n = n;
      permutation = new int[n];
      usableNumbers = new HashSet<>();
      for (int i = 1; i <= n; i++) {
        usableNumbers.add(i);
      }
    }
  }
}
