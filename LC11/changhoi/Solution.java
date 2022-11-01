package LC11.changhoi;

class Solution {
    int calc(int x1, int x2, int[] height) {
        return (x2 - x1) * Math.min(height[x1], height[x2]);
    }

    public int maxArea(int[] height) {
        int x1 = 0, x2 = height.length - 1;
        int max = calc(x1, x2, height);

        while(x1 < x2) {
            if (height[x1] > height[x2]) {
                x2--;
            } else {
                x1++;
            }

            int newMax = calc(x1, x2, height);
            if (max < newMax) max = newMax;
        }


        return max;
    }
}
