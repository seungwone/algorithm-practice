import java.util.*;

class Solution {
    static int redStI;
    static int redStJ;
    static int redEdI;
    static int redEdJ;
    static int blueStI;
    static int blueStJ;
    static int blueEdI;
    static int blueEdJ;
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] isVisitedRed;
    static boolean[][] isVisitedBlue;
    static int n;
    static int m;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        arr = maze;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = maze[i][j];
                if (val == 1) {
                    redStI = i;
                    redStJ = j;
                }
                if (val == 2) {
                    blueStI = i;
                    blueStJ = j;
                }
                if (val == 3) {
                    redEdI = i;
                    redEdJ = j;
                }
                if (val == 4) {
                    blueEdI = i;
                    blueEdJ = j;
                }
            }
        }
        
        isVisitedRed = new boolean[n][m];
        isVisitedBlue = new boolean[n][m];
        isVisitedRed[redStI][redStJ] = true;
        isVisitedBlue[blueStI][blueStJ] = true;
        dfs(redStI, redStJ, blueStI, blueStJ, 0);
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        
        return answer;
    }
    
    public static void dfs(int redI, int redJ, int blueI, int blueJ, int time) {
        // if (time >= answer) {
        //     return;
        // }
        
        if (redI == redEdI && redJ == redEdJ && blueI == blueEdI && blueJ == blueEdJ) {
            answer = Math.min(answer, time);
            return;
        }
        
        if (redI == redEdI && redJ == redEdJ) {
            for (int bd = 0; bd < 4; bd++) {
                int nextBlueI = blueI + di[bd];
                int nextBlueJ = blueJ + dj[bd];

                if (nextBlueI >= 0 && nextBlueI < n && nextBlueJ >= 0 && nextBlueJ < m && arr[nextBlueI][nextBlueJ] != 5 && !isVisitedBlue[nextBlueI][nextBlueJ] && !(redI == nextBlueI && redJ == nextBlueJ)) {
                    isVisitedBlue[nextBlueI][nextBlueJ] = true;
                    dfs(redI, redJ, nextBlueI, nextBlueJ, time + 1);
                    isVisitedBlue[nextBlueI][nextBlueJ] = false;
                }
            }
            return;
        }
        
        if (blueI == blueEdI && blueJ == blueEdJ) {
            for (int rd = 0; rd < 4; rd++) {
                int nextRedI = redI + di[rd];
                int nextRedJ = redJ + dj[rd];

                if (nextRedI >= 0 && nextRedI < n && nextRedJ >= 0 && nextRedJ < m && arr[nextRedI][nextRedJ] != 5 && !isVisitedRed[nextRedI][nextRedJ] && !(blueI == nextRedI && blueJ == nextRedJ)) {
                    isVisitedRed[nextRedI][nextRedJ] = true;
                    dfs(nextRedI, nextRedJ, blueI, blueJ, time + 1);
                    isVisitedRed[nextRedI][nextRedJ] = false;
                }
            }
            return;
        }
        
        for (int rd = 0; rd < 4; rd++) {
            int nextRedI = redI + di[rd];
            int nextRedJ = redJ + dj[rd];
            
            if (nextRedI >= 0 && nextRedI < n && nextRedJ >= 0 && nextRedJ < m && arr[nextRedI][nextRedJ] != 5 && !isVisitedRed[nextRedI][nextRedJ]) {
                for (int bd = 0; bd < 4; bd++) {
                    int nextBlueI = blueI + di[bd];
                    int nextBlueJ = blueJ + dj[bd];
                    
                    if (nextRedI == blueI && nextRedJ == blueJ && nextBlueI == redI && nextBlueJ == redJ) {
                        continue;
                    }
                    
                    if (nextBlueI >= 0 && nextBlueI < n && nextBlueJ >= 0 && nextBlueJ < m && arr[nextBlueI][nextBlueJ] != 5 && !isVisitedBlue[nextBlueI][nextBlueJ] && !(nextRedI == nextBlueI && nextRedJ == nextBlueJ)) {
                        isVisitedRed[nextRedI][nextRedJ] = true;
                        isVisitedBlue[nextBlueI][nextBlueJ] = true;
                        dfs(nextRedI, nextRedJ, nextBlueI, nextBlueJ, time + 1);
                        isVisitedRed[nextRedI][nextRedJ] = false;
                        isVisitedBlue[nextBlueI][nextBlueJ] = false;
                    }
                }
            }
        }
    }
}