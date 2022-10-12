package PG12920.changhoi;
class Solution {
    int workCount(int time, int[] cores) {
        int cnt = 0;
        for (int c : cores) {
            cnt += time / c;
        }

        return cnt;
    }

    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;

        int max = 0;
        n -= cores.length;
        for (int c : cores) {
            if (c > max) max = c;
        }

        int l = 1, r = n * max;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = workCount(mid, cores);
            if (cnt < n) l = mid + 1;
            else r = mid - 1;
        }

        // r 분동안 수행한 작업 나머지.
        // r + 1은 작업 보다 무조건 많은 양을 처리할 수 있음
        n -= workCount(r, cores);

        for (int i = 0; i < cores.length; i++) {
            int c = cores[i];
            if ((r + 1) % c == 0) n--;
            if (n == 0) return i + 1;
        }
        return 0;
    }
}
