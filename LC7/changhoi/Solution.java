package LC7.changhoi;

import java.util.*;

class Solution {
    public int reverse(int x) {
        boolean isMinus = x < 0;
        if (isMinus) x = x * -1;

        long ret = 0;
        while (x > 0) {
            ret *= 10;
            ret += x % 10;
            if (ret > Integer.MAX_VALUE) return 0;
            x /= 10;
        }

        if (isMinus) ret *= -1;
        return (int) ret;
    }
}
