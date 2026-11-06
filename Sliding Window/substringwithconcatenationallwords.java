import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class substringwithconcatenationallwords {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;

        int windowSize = wordLength * totalWords;

        if (s.length() < windowSize) {
            return result;
        }

        // Step 1: Build required frequency map
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Try all possible offsets
        for (int i = 0; i < wordLength; i++) {

            int left = i;
            int count = 0;

            Map<String, Integer> windowMap = new HashMap<>();

            // Step 3: Move right in wordLength increments
            for (int right = i; right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                // Step 4: Handle invalid word
                if (!wordMap.containsKey(word)) {
                    windowMap.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }

                // Step 5: Add word to current window
                windowMap.put(word,
                    windowMap.getOrDefault(word, 0) + 1);

                count++;

                // Step 6: Shrink if frequency exceeds required count
                while (windowMap.get(word) > wordMap.get(word)) {

                    String leftWord = s.substring(left, left + wordLength);

                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);

                    if (windowMap.get(leftWord) == 0) {
                        windowMap.remove(leftWord);
                    }

                    count--;
                    left += wordLength;
                }

                // Step 7: Found a valid concatenation
                if (count == totalWords) {

                    result.add(left);

                    // Remove leftmost word to search for overlapping matches
                    String leftWord = s.substring(left, left + wordLength);

                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);

                    if (windowMap.get(leftWord) == 0) {
                        windowMap.remove(leftWord);
                    }

                    count--;
                    left += wordLength;
                }
            }
        }

        return result;
    }
}
