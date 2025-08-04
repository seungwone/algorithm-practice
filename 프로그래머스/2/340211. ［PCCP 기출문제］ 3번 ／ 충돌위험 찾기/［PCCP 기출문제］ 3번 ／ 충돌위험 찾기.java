import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][] map = new int[101][101];
        int x = routes.length;
        int m = routes[0].length;
        int[] cnt = new int[x];
        Deque<int[]> dq = new ArrayDeque<>();
        
        for (int i = 0; i < x; i++) {
            int[] ip = points[routes[i][0] - 1];
            int[] tp = points[routes[i][1] - 1];
            cnt[i] = 1;
            
            dq.add(new int[] {ip[0], ip[1], tp[0], tp[1], i});
            
            if (map[ip[0]][ip[1]] == 1) {
                answer++;
            }
            
            map[ip[0]][ip[1]]++;
        }
        
        dq.add(new int[] {-1, -1, -1, -1, -1});
        
        while (dq.size() > 1) {
            int[] ele = dq.remove();
            int currentI = ele[0];
            int currentJ = ele[1];
            int targetI = ele[2];
            int targetJ = ele[3];
            int idx = ele[4];
            
            if (currentI == -1) {
                for (int[] e : dq) {
                    int curI = e[0];
                    int curJ = e[1];
                    
                    if (map[curI][curJ] == 1) {
                        answer++;
                    }
                    
                    map[curI][curJ]++;
                }
                
                dq.add(new int[] {-1, -1, -1, -1, -1});
                continue;
            }
            
            map[currentI][currentJ]--;
            
            if (currentI == targetI && currentJ == targetJ) {
                if (cnt[idx] < m - 1) {
                    cnt[idx]++;
                    int[] target = points[routes[idx][cnt[idx]] - 1];
                    targetI = target[0];
                    targetJ = target[1];
                }
                else {
                    continue;
                }
            }
            
            int nextI = currentI;
            int nextJ = currentJ;
            
            if (currentI != targetI) {
                nextI += (targetI - currentI) / Math.abs(targetI - currentI);
            }
            else {
                nextJ += (targetJ - currentJ) / Math.abs(targetJ - currentJ);
            }
            
            dq.add(new int[] {nextI, nextJ, targetI, targetJ, idx});
        }
        
        
        return answer;
    }
}