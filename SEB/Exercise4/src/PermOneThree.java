import java.util.*;

/**
 * @author Simon Stratemeier 199067
 */
public class PermOneThree {
  public static void main(String[] args) {
    int count = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bitte n angeben:");
    int n = scanner.nextInt();
    PermGenerator permGenerator  = new PermGenerator(n);
    long startTime = System.nanoTime();

    for(int[] permutation = permGenerator.nextElement(); permGenerator.hasMoreElements();) {
      System.out.println(Arrays.toString(permutation));
      count++;
    }

    long duration = (System.nanoTime() - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
    System.out.println("Time: " + duration + "ms");
    System.out.println("Count: " + count);
  }

  static class PermGenerator implements Enumeration<int[]> {
    int n;
    int[] permutation;
    int indexCol = 0;
    boolean nextCalculated = true;
    Set<Integer> usableNumbers;
    int[] deltas = new int[]{-4, -1, 1, 4};

    private boolean nextPossibility(int column) {
      int currentValue =  permutation[column];
      int previousNum = column == 0 ? currentValue : permutation[column - 1];
      for (int delta : deltas) {
        int possibleValue = previousNum + delta; // Calculate possible next num
        if (usableNumbers.contains(possibleValue) && possibleValue > currentValue) { // If num is usable and bigger than before then set value in permutation
          set(column, possibleValue);
          return true;
        }
      }
      set(column, 0); // No number in column found, reset column
      return false;
    }

    void set(int index, int value) {
      if(value == 0) { // 0 means reset column
        usableNumbers.add(permutation[index]); // Add number in permutation to usable numbers
      } else {
        if(permutation[index] != 0) usableNumbers.add(permutation[index]); // If column in permutation is already set replace value
        usableNumbers.remove(value);
      }
      permutation[index] = value; // Modify permutation
    }

    PermGenerator(int n) {
      this.n = n;
      permutation = new int[n];
      usableNumbers = new HashSet<>();
      for (int i = 1; i <= n; i++) {
        usableNumbers.add(i);
      }
    }

    // Calculate next bigger permutation
    @Override
    public boolean hasMoreElements() {
      while (indexCol >= 0) {
        if(indexCol == n) { // Solution found
          nextCalculated = true;
          indexCol--; // Find other solutions
          return true;
        } if (nextPossibility(indexCol)) { // Check if a number fits in next column
          indexCol++; // Working?
        } else {
          indexCol--; // Backtrack
        }
      }
      return false;
    }

    @Override
    public int[] nextElement() {
      if(!nextCalculated) { // Next element not calculated yet
        hasMoreElements();
      } else {
        nextCalculated = false;
      }
      return permutation;
    }
  }
}
