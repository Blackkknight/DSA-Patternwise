import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int low = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Count this character only if it is still needed
            if (need.containsKey(ch) &&
                window.get(ch) <= need.get(ch)) {
                matched++;
            }

            // All characters, including duplicates, are matched
            while (matched == t.length()) {
                int length = high - low + 1;

                if (length < minLength) {
                    minLength = length;
                    startIndex = low;
                }

                char left = s.charAt(low);
                window.put(left, window.get(left) - 1);

                // Removing this character makes the window invalid
                if (need.containsKey(left) &&
                    window.get(left) < need.get(left)) {
                    matched--;
                }

                low++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }
}