import java.util.Collections;
import java.util.List;

public class SortedSums { //HackerRank medium

    // a = [3, 9, 5, 8] -> n = 3
    // s(1) = [9] -> f(1) = 1*9
    // s(2) = [5, 9] -> f(2) = 1*5 + 2*9
    // s(3) = [5, 8, 9] -> f(3) = 1*5 + 2*8 + 3*9
    // sum = f(1)+2(2)+f(3)

    double MODULO = 7 + Math.pow(10, 7);

    public int sortedSum(List<Integer> a) {
        double sum = 0.0;
        int n = a.get(0);

        for (int i = 1; i <= n; i++) {
            sum += getSubListSum(getSubList(a, i));
        }

        return (int) (sum % MODULO);
    }

    public List<Integer> getSubList(List<Integer> a, int n) {
        List<Integer> subList = a.subList(1, n + 1);
        Collections.sort(subList);
        System.out.println("n = " + n);
        System.out.println(subList);
        return subList;
    }

    public double getSubListSum(List<Integer> a) {
        return a.stream().map(i -> i * (a.indexOf(i) + 1)).reduce(0, Integer::sum);

    }
}
