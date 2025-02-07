package String;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeString {

    // Given a string, rearrange it in decreasing order by the characters frequency
    // and in lexicographical order if their frequency is equal
    public String rearrangeAString (String s) {
        HashMap<Character, Integer> occurrenceMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (occurrenceMap.containsKey(currentChar)) {
                int occurrence = occurrenceMap.get(currentChar);
                occurrenceMap.put(currentChar, occurrence + 1);
            }

            occurrenceMap.putIfAbsent(currentChar, 1);
        }

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        for (HashMap.Entry<Character, Integer> entry: occurrenceMap.entrySet()) {
            int nextTreeMapKey = entry.getValue();

            if (treeMap.containsKey(nextTreeMapKey)) {
                treeMap.replace(nextTreeMapKey, treeMap.get(nextTreeMapKey) + entry.getKey());
            }

            treeMap.putIfAbsent(nextTreeMapKey, String.valueOf(entry.getKey()));
            //treeMap = (TreeMap<Integer, String>) treeMap.descendingMap();
        }

        StringBuilder rearrangedStringBuilder = new StringBuilder();

        for (Map.Entry<Integer, String> entry: treeMap.entrySet()) {
            if (entry.getValue().length() == 1) {
                String stringToAdd = new String(new char[entry.getKey()]) //
                        .replace("\0", entry.getValue());
                rearrangedStringBuilder.append(stringToAdd, 0, 1);
            } else {
                for (int i = 0; i < entry.getValue().length(); i++) {
                    String stringToAdd = new String(new char[entry.getKey()]) //
                            .replace("\0", String.valueOf(entry.getValue().charAt(i)));
                    rearrangedStringBuilder.append(stringToAdd, 0, 1);
                }
            }

        }

        return rearrangedStringBuilder.reverse().toString();
    }
}
