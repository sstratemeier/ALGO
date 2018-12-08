// Java program for implementation of Heap Sort 
public class HeapSort
{
    static void heapSort (int[] a){
        int j, hi = a.length-1;
        for (j = hi/2; j >= 1;) // alle Pos. j = [n/2] .. 1:
            percolate (a, j--, hi); // versickere im Array j ... n


        /*for (j = hi ; j > 1;) { // alle Pos. j = n ... 2:
            swap (a, 1, j); // vertausche Maximum nach j
            percolate (a, 1, --j); // versickere im Array 1 ... (j-1)
        }*/
    } // heapSort

    private static void percolate (int[] a, int j, int t){
        int h;
        while ((h=2*j) <= t){ // h: linker Sohn
            if (h < t && a[h+1] > a[h]) h++; // h: groesserer Sohn
            if (a[h] > a[j]) { // versickern j->h ?
                swap (a, h, j); // ja: tausche j <-> h
                j = h; // und weiter mit h
            } else break; // nein: fertig
        }
    } // percolate

    private static void swap(int[] a, int i, int j) {
        //System.out.println("swap("+ i + ", " + j + ")");
        int temp = a[i];1
        a[i] = a[j];
        a[j] = temp;

        printArray(a);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program 
    public static void main(String args[])
    {
        int arr[] = {-1, 1, 6, 2, 5, 7, 9, 8, 4, 0, 3};
        int n = arr.length;
        heapSort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }
} 