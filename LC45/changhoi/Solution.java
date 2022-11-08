package LC45.changhoi;

class Solution {
    public int jump(int[] nums) {
        int idx = 0, hop = 0, goal = nums.length - 1;

        while(idx < goal) {
            int curr = nums[idx];
            int maxRange = -1, maxIdx = -1;

            for (int i = 1; i <= curr; i++) {
                if (idx + i >= goal) return ++hop;
                int range = nums[idx + i] + i;
                if (maxRange < range) {
                    maxRange = range;
                    maxIdx = i;
                }
            }
            idx += maxIdx;
            hop++;
        }

        return hop;
    }
}
