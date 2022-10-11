package PG43162.changhoi;

class Solution {
    boolean[][] edges;
    boolean[] visited;

    void traverse(int node) {
        visited[node] = true;


        for (int i = 0; i < edges[node].length; i++) {
            if (visited[i]) continue;
            if (edges[node][i]) traverse(i);
        }
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        edges = new boolean[n][n];

        int cnt = 0;
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = computers[i][j] == 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            cnt++;
            traverse(i);
        }

        return cnt;
    }
}
