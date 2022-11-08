package LC3.changhoi;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (max >= s.length() - i) return max;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int len = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                len++;
            }

            if (len > max) {
                max = len;
            }
        }

        return max;
    }
}
