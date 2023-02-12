public class IsPrime {

    /*
    *A prime number is a whole number greater than 1 whose only factors are 1 and itself.
    * A factor is a whole number that can be divided evenly into another number.
    * The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29.
    * Numbers that have more than two factors are called composite numbers.
    */

    public static boolean isANumberPrime(int N) {
        if (N == 2 || N == 3) {
            return true;
        }

        if (N == 1 || N % 2 == 0 || N % 3 == 0) {
            return false;
        }

        int root = (int) Math.sqrt(N);

        for (int i = 3; i <= root; i += 2) {
            if (N % i == 0) {
                return false;
            }
        }

        return true;
    }

    //find the smallest prime greater than N
    public int smallestPrime(int N) {
        N = N + 1;

        while (!isANumberPrime(N)) {
            N = N + 1;
        }

        return N;
    }
}
