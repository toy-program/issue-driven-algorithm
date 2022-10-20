package LC1996.changhoi;

import java.util.*;

class Solution {
    int order(int[]a, int[]b) {
        if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
        return Integer.compare(a[1], b[1]);
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, this::order);
        int max = Integer.MIN_VALUE, cnt = 0;
        for (int[] p : properties) {
            if (max > p[1]) cnt++;
            else max = p[1];
        }

        return cnt;
    }
}
