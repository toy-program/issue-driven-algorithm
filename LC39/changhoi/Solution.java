package LC39.changhoi;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    void traverse(int[] candidates, int target, int idx,  List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int c = candidates[i];
            if (c > target) continue;
            list.add(c);
            traverse(candidates, target-c, i, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traverse(candidates, target, 0, new ArrayList<>());
        return ans;
    }
}
