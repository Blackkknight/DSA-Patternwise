class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int max = 0;
        int max_frequent = 0;
        int[] freq = new int[26];
        for(int high = 0; high<s.length(); high++){
            char ch = s.charAt(high);
            freq[ch - 'A']++;
            max_frequent = Math.max(max_frequent,freq[ch - 'A']);

            while((high - low + 1) - max_frequent > k){      //it simply checks for how many character have to be changed to continue repeating flow
                char left = s.charAt(low);
                freq[left - 'A']--;
                low++;
            }
            
            max= Math.max(max, high - low +1);
        }
        return max;
    }
}