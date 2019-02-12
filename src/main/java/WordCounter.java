import java.util.HashMap;
import java.util.List;

public class WordCounter {

    // Get the word count in a list of words
    // ex: list = {"titi", "shady", "app", "titi", "app"}
    // return: {"titi": 2, "app": 2, "shady": 1}
    public HashMap<String, Integer> wordCounter(List<String> wordList) {
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word: wordList) {
            if (wordMap.containsKey(word)) {
                wordMap.replace(word, wordMap.get(word) + 1);
            }
            wordMap.putIfAbsent(word, 1);
        }

        return wordMap;
    }
}
