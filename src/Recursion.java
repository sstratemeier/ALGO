/**
 * @author Simon Stratemeier
 */
public class Recursion {
    public static int recusiveSum(int n){
        return n == 0 ? 0 : n + recusiveSum(n-1);
    }

    public static int iterativeSum(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int recursiveFibonacci(int n){
        // Nicht sonderlich effizient, da aufgrund fehlender tail recursion der Stack groß wird.
        return n <= 1 ? 1 : recursiveFibonacci(n - 1) + recursiveFibonacci(n-2);
    }

    public static int iterativeFibonacci(int n){
        // Effizient, da Stack klein gehalten wird
        int sum = 1;
        int preSum = 0;
        for(int i = 1; i <= n; i++) {
            int sumCopy = sum;
            sum += preSum;
            preSum = sumCopy;
        }
        return sum;
    }

    // https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
    public static int iterativeOldEuclid(int a, int b) {
        if(a == 0) {
            return b;
        } else {
            while(b != 0) {
                if(a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            return a;
        }
    }

    // https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
    public static int recursiveOldEuclid(int a, int b) {
        if(b == 0) {
            return a;
        } else {
           if(a == 0) {
               return b;
           } else {
               if(a > b) {
                   return recursiveOldEuclid(a - b, b);
               } else {
                   return recursiveOldEuclid(a, b - a);
               }
           }

        }
    }

    // https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
    public static int recursiveModernEuclid(int a, int b) {
        if(b == 0){
            return a;
        } else {
            return recursiveModernEuclid(b, a % b);
        }
    }

    // https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
    public static int iterativeModernEuclid(int a, int b) {
        while (b != 0) {
            int h = a % b;
            a = b;
            b = h;
        }
        return a;
    }

}
