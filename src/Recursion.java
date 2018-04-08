/**
 * @author Simon Stratemeier
 */
class Recursion {
    /**
     * Recursive method for f(n) = n + f(n-1)
     * @param  n number of iterations
     * @return sum of n variable
     */
    static int recursiveSum(int n){
        return n == 0 ? 0 : n + recursiveSum(n-1);
    }

    /**
     * Iterative method for f(n) = n + f(n-1)
     * @param  n number of iterations
     * @return sum of n variable
     */
    static int iterativeSum(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Recursive method for calculating a value in the fibonacci sequence
     * Not very efficient due to the square growth of the call stack
     * @param  n position of value in the fibonacci sequence
     * @return value of position n in the sequence
     */
    static int recursiveFibonacci(int n){
        return n <= 1 ? 1 : recursiveFibonacci(n - 1) + recursiveFibonacci(n-2);
    }


    /**
     * Iterative method for calculating a value in the fibonacci sequence
     * @param  n position of value in the fibonacci sequence
     * @return value of position n in the sequence
     */
    static int iterativeFibonacci(int n){
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


    /**
     * iterative method for calculating the greatest common divisor
     * with the old euclidean algorithm
     * from https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
     * @param  a value to find gcd with value b
     * @param  b value to find gcd with value a
     * @return greatest common divisor
     */
    static int iterativeOldEuclid(int a, int b) {
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

    /**
     * recursive method for calculating the greatest common divisor
     * with the old euclidean algorithm
     * from https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
     * @param  a value to find gcd with value b
     * @param  b value to find gcd with value a
     * @return greatest common divisor
     */
    static int recursiveOldEuclid(int a, int b) {
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

    /**
     * recursive method for calculating the greatest common divisor
     * with the modern euclidean algorithm
     * from https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
     * @param  a value to find gcd with value b
     * @param  b value to find gcd with value a
     * @return greatest common divisor
     */
    static int recursiveModernEuclid(int a, int b) {
        if(b == 0){
            return a;
        } else {
            return recursiveModernEuclid(b, a % b);
        }
    }

    /**
     * iterative method for calculating the greatest common divisor
     * with the modern euclidean algorithm
     * from https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
     * @param  a value to find gcd with value b
     * @param  b value to find gcd with value a
     * @return greatest common divisor
     */
    static int iterativeModernEuclid(int a, int b) {
        while (b != 0) {
            int h = a % b;
            a = b;
            b = h;
        }
        return a;
    }

    /**
     * Is value even
     * @param n value to find property "even"
     * @return true if value is even
     */
    static boolean isEven(int n) {
        if(n == 0){
            return true;
        } else {
            return isOdd(n-1);
        }
    }

    /**
     * Is value odd
     * @param n value to find property "odd"
     * @return true if value is odd
     */
    static boolean isOdd(int n) {
        if(n == 0) {
            return false;
        } else {
            return isEven(n-1);
        }
    }
}
