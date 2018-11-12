import java.util.*;

/**
 * @author Simon Stratemeier 199067
 */
public class PermMiddle {
  public static void main(String[] args) {
    int count = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bitte n angeben:");
    int n = scanner.nextInt();
    long startTime = System.nanoTime();

    for(int i = 0; i <= n; i++) {
        PermGenerator permGenerator = new PermGenerator(i);
        while (permGenerator.hasMoreElements()) {
          int[] permutation = permGenerator.nextElement();
          if (checkValid(permutation)) {
            count++;
          }
        }
      System.out.println("C(" + i +") = " + " \\seqsplit{" + count + "}\\\\");
        count = 0;
    }

    long duration = (System.nanoTime() - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
    System.out.println("Time: " + duration + "ms");
  }

  static boolean checkValid(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        int a = arr[i];
        int b = arr[j];
        if((a + b) % 2 == 0) {
          int searchCriteria = (a + b) / 2;
          for (int k = i + 1; k < j; k++) {
            if(arr[k] == searchCriteria) return false;
          }
        }
      }
    }
    return true;
  }

  static class PermGenerator implements Enumeration<int[]> {
    int n;
    int[] permutation;
    int indexCol = 0;
    boolean nextCalculated = true;
    Set<Integer> usableNumbers;
    Set<Integer> prohibitedNumbers;

    private boolean nextPossibility(int column) {
      int currentValue =  permutation[column];
      int previousNum = column == 0 ? currentValue : permutation[column - 1];
      for (int i = -n; i <= n; i++) {
        int possibleValue = previousNum + i; // Calculate possible next num
        if (usableNumbers.contains(possibleValue) && possibleValue > currentValue && !prohibitedNumbers.contains(possibleValue)) { // If num is usable and bigger than before then set value in permutation
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
        if(permutation[index] != 0) {
          usableNumbers.add(permutation[index]); // If column in permutation is already set replace value
        }
        usableNumbers.remove(value);
      }
      permutation[index] = value; // Modify permutation
    }

    PermGenerator(int n) {
      this.n = n;
      permutation = new int[n];
      usableNumbers = new HashSet<>();
      prohibitedNumbers = new HashSet<>();
      for (int i = 1; i <= n; i++) {
        usableNumbers.add(i);
      }
    }

    // Calculate next bigger permutation
    @Override
    public boolean hasMoreElements() {
      while (indexCol >= 0) {
        if (indexCol == n) { // Solution found
          nextCalculated = true;
          indexCol--; // Find other solutions
          return true;
        }
        if (nextPossibility(indexCol)) { // Check if a number fits in next column
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
