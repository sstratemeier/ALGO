import java.sql.SQLOutput;
import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        //Random generator = new Random();

        /*
        // Min Comparisons
        for(int n = 1; n <= 13; n++) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i;
            }
            //System.out.println("array(" + n + ") = " + Arrays.toString(a));
            mergeSort(a, 0, a.length-1);
            //System.out.println("arraySorted(" + n + ") = " + Arrays.toString(a));
            System.out.println(compares);
        }
        */

        // MAX Comparisons
        for(int n = 0; n <= 13; n++) {
            PermGenerator generator = new PermGenerator(n);
            //System.out.println("array(" + n + ") = " + Arrays.toString(a));
            int[] minArray = new int[0];
            int[] maxArray = new int[0];
            int minCompares = Integer.MAX_VALUE;
            int maxCompares = 0;

            while (generator.hasMoreElements()) {
                int[] a = generator.nextElement();
                int countCompares = mergeSort(a.clone(), 0, a.length - 1);

                if (countCompares < minCompares) {
                    minCompares = countCompares;
                    minArray = a;
                }
                if (countCompares > maxCompares) {
                    maxCompares = countCompares;
                    maxArray = a;
                }
            }

            //System.out.println(n + " min> " + minCompares + " " + Arrays.toString(minArray));
            System.out.println(n + " max> " + maxCompares + " " + Arrays.toString(maxArray));

            //System.out.println("arraySorted(" + n + ") = " + Arrays.toString(a));
            //System.out.println(compares);
        }
    }

    private static int mergeSort(int[] a, int lo, int hi){
        int countCompare = 0;
        if (lo < hi) { // Grosses Problem:
            int m = (lo + hi +1)/2; // Divide
            countCompare += mergeSort (a, lo, m-1); // Conquer links
            countCompare += mergeSort (a, m, hi); // Conquer rechts
            // Merge nach
            int [] temp = new int[hi-lo+1]; // Hilfs-Array
            for (int i=0, j=lo, k=m; i<temp.length;){ // bis voll
                if ((k > hi)) {
                    temp[i++] = a[j++]; // von links
                } else {
                    if((j < m)) {
                        countCompare++;
                        if(a[j] < a[k]) {
                            temp[i++] = a[j++]; // von links
                        } else {
                            temp[i++] = a[k++];
                        }
                    } else {
                        temp[i++] = a[k++];
                    }
                }
            }
            for (int i=0; i<temp.length; i++){ // Kopiere zurueck
                a[lo+i] = temp[i]; // von Hilfs-Array
            }
        }
        return countCompare;
    } // mergeSort

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
            return permutation.clone();
        }
    }
}
