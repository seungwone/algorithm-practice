import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        int n = land.length;
        int m = land[0].length;
        int[] arr = new int[m];
        boolean[][] isVisited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isVisited[i][j] || land[i][j] == 0) {
                    continue;
                }
                isVisited[i][j] = true;
                
                int cnt = 1;
                Set<Integer> set = new HashSet<>();
                Deque<int[]> dq = new ArrayDeque<>();
                set.add(j);
                dq.add(new int[] {i, j});
                
                while (!dq.isEmpty()) {
                    int[] ele = dq.remove();
                    int curI = ele[0];
                    int curJ = ele[1];
                    
                    for (int d = 0; d < 4; d++) {
                        int nextI = curI + di[d];
                        int nextJ = curJ + dj[d];
                        
                        if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && land[nextI][nextJ] == 1 && !isVisited[nextI][nextJ]) {
                            cnt++;
                            set.add(nextJ);
                            isVisited[nextI][nextJ] = true;
                            dq.add(new int[] {nextI, nextJ});
                        }
                    }
                }
                
                for (int e : set) {
                    arr[e] += cnt;
                }
                
            }
        }
        
        for (int j = 0; j < m; j++) {
            answer = Math.max(answer, arr[j]);
        }
        
        return answer;
    }
}