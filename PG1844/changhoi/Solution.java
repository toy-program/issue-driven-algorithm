package PG1844.changhoi;

import java.util.*;

class Solution {
    int n, m;
    boolean[][] visited;

    int[][] directions = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    boolean isValid(int y, int x, int[][] maps) {
        return 0 <= x && x < n && 0 <= y && y < m && maps[y][x] == 1;
    }

    boolean isGoal(int y, int x) {
        return y == m - 1 && x == n - 1;
    }

    int bfs(int[][]maps) {
        int x = 0, y = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x, 1});
        int ret = -1;
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            if (visited[next[0]][next[1]]) continue;
            if (isGoal(next[0], next[1])) {
                ret = next[2];
                break;
            }

            visited[next[0]][next[1]] = true;

            for (int[] d : directions) {
                int dy = d[0] + next[0];
                int dx = d[1] + next[1];
                if (!isValid(dy, dx, maps) || visited[dy][dx]) continue;
                queue.add(new int[]{dy, dx, next[2] + 1});
            }
        }
        return ret;
    }
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
        return bfs(maps);
    }
}
