import java.util.Arrays;

public class ValueHistogram {

    // given a C array of doubles, and a vector of bounds defining ranges,
    // return a histogram of double values
    // i.e.: points [0.5, 0.6, 0.7, 1.0, 2.0], bounds [0.8, 1.5],
    // returned values should be: [3, 1, 1]
    // (3 values, less than 0.8, 1 value between 0.8 and 1.5, 1 value larger than 1.5)

    public int[] createHistogram(double[] points, double[] bounds) {
        int[] histogram = new int[3];

        Arrays.stream(points).forEach(point -> {
            if (point < bounds[0]) {
                histogram[0]++;
            } else if (point > bounds[1]) {
                histogram[2]++;
            } else {
                histogram[1]++;
            }
        });

        return histogram;
    }
}
