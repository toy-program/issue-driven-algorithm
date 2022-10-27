package LC16.changhoi;

/*
 * n <= 500 -> 500 Combination 3 (n^3) -> 2천만 -> 다돌아도 되겠군
 * 만약 수가 커지면 정렬 -> 하나는 인덱스 돌면서 투 포인터
 * n log n + n ^ 2 -> n^2이 최선 같음
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = (int) 1e5;

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int v = nums[i] + nums[j] + nums[k];
                    if (v == target) return v;
                    if(Math.abs(target - v) < Math.abs(target - ans)) {
                        ans = v;
                    }
                }
            }
        }
        return ans;
    }
}
