package Amazon;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TriangleNumbers {

    // Given an unsorted array of positive integers. Find the number of triangles
    // that can be formed with three different array elements as three sides of triangles.
    // For a triangle to be possible from 3 values,
    // the sum of any two values (or sides) must be greater than the third value (or third side).
    // For example:
    // input: {4, 6, 3, 7}
    // output: 3. Triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note that {3, 4, 7} is not a possible triangle.
    // Another example:
    // input: {10, 21, 22, 100, 101, 200, 300}
    // output: 6 ({10, 21, 22}, {21, 100, 101}, {22, 100, 101}, {10, 100, 101}, {100, 101, 200} and {101, 200, 300})

    // solution 1: brutal
    // O(n3) worst case
    public int numberOfPossibleTriangles(List<Integer> array) {
        array = array.stream().sorted().collect(toList());

        int firstSide, secondSide, thirdSide;
        int size = array.size();
        int possibleNumber = 0;

        for (firstSide = 0; firstSide < size - 3; firstSide++) {
            for (secondSide = firstSide + 1; secondSide < size - 2; secondSide++) {
                for (thirdSide = secondSide + 1; thirdSide < size - 1; thirdSide++) {
                    if (array.get(firstSide) + array.get(secondSide) > array.get(thirdSide)) {
                        possibleNumber++;
                    } else {
                        break;
                    }
                }
            }
        }

        return possibleNumber;
    }

    // solution 2:
    // find the rightmost index ‘thirdSide’ (or largest ‘arr[thirdSide]’)
    // such that ‘arr[firstSide] + arr[secondSide] > arr[thirdSide]
}
