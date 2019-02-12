import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindAdjacentWords {

    // Given a string and a list of words (unique words),
    // print occurences where all the words appear consecutively in the string.
    // (the order does not matter, but need to be all from the list and having no other words between them).
    // Example:
    //INPUT:
    //string: "This is a test is other a"
    //list: ["is", "a", "test"]
    //OUTPUT:
    //2
    int getAdjacentWordsFrequency (ArrayList<String> string, ArrayList<String> words) {
        ArrayList<ArrayList<String>> wordsPermutationList = wordPermutation(words);

        int windowSize = words.size();
        Queue<String> window = initializeWindow(string, windowSize);

        int frequency = 0;

        if (wordsPermutationList.contains(window)) {
            frequency++;
        }

        for (int i = 1; i < string.size() - windowSize + 1; i++) {
            ((LinkedList<String>) window).pollFirst();
            ((LinkedList<String>) window).offerLast(string.get(i + windowSize - 1));

            if (wordsPermutationList.contains(window)) {
                frequency++;
            }
        }

        return frequency;
    }

    private ArrayList<ArrayList<String>> wordPermutation(ArrayList<String> words) {
        ArrayList<ArrayList<String>> permutation = new ArrayList<>();

        if (words.size() == 1) {
            permutation.add(words);
            return permutation;
        }

        ArrayList<ArrayList<String>> lastPermutation = wordPermutation(new ArrayList<>(words.subList(1, words.size())));
        String stringToAdd = words.get(0);

        for (ArrayList<String> permutedWords: lastPermutation) {
            for (int i = 0; i < permutedWords.size(); i++) {
                ArrayList<String> newPermutedWords = new ArrayList<>(permutedWords);
                newPermutedWords.add(i, stringToAdd);
                permutation.add(newPermutedWords);
            }

            ArrayList<String> newPermutedWords = new ArrayList<>(permutedWords);
            newPermutedWords.add(stringToAdd);
            permutation.add(newPermutedWords);
        }

        return permutation;
    }

    private Queue<String> initializeWindow (ArrayList<String> stringList, int windowSize) {
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < (windowSize <= stringList.size() ? windowSize : stringList.size()); i++) {
            queue.offer(stringList.get(i));
        }

        return queue;
    }
}
