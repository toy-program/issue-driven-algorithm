package LC322.changhoi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        new Solution().coinChange(new int[]{1, 2, 3}, 10);
    }


    Queue<Integer> queue = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    int bfs(int[] coins) {
        while (!queue.isEmpty()) {
            int rest = queue.poll();
            int lv = map.get(rest);
            for (int c : coins) {
                if (c > rest) continue;
                if (c == rest) return lv + 1;
                if (!map.containsKey(rest - c)) {
                    queue.add(rest - c);
                    map.put(rest - c, lv + 1);
                }
            }
        }
        return -1;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        queue.add(amount);
        map.put(amount, 0);


        return bfs(coins);
    }
}
