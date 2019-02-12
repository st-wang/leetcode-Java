public class IsPrime {

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
