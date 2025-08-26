import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N + 1];
        int[][] answer = new int[N + 1][2];
        
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            if (dq.isEmpty()) {
                dq.add(new int[] {buildings[i], i});
                continue;
            }
            
            while (!dq.isEmpty() && buildings[i] >= dq.getLast()[0]) {
                dq.removeLast();
            }
            
            if (!dq.isEmpty()) {
                int[] ele = dq.getLast();
                int idx = ele[1];
                answer[i][0] = dq.size();
                answer[i][1] = idx;
            }
            
            dq.add(new int[] {buildings[i], i});
        }
        
        dq.clear();
        for (int i = N; i >= 1; i--) {
            if (dq.isEmpty()) {
                dq.add(new int[] {buildings[i], i});
                continue;
            }
            
            while (!dq.isEmpty() && buildings[i] >= dq.getLast()[0]) {
                dq.removeLast();
            }
            
            if (!dq.isEmpty()) {
                int[] ele = dq.getLast();
                int idx = ele[1];
                answer[i][0] += dq.size();
                if (answer[i][1] == 0) {
                    answer[i][1] = idx;
                }
                else {
                    int gap1 = Math.abs(answer[i][1] - i);
                    int gap2 = Math.abs(idx - i);
                    if (gap2 < gap1) {
                        answer[i][1] = idx;
                    }
                }
            }
            
            dq.add(new int[] {buildings[i], i});
        }
        
        for (int i = 1; i <= N; i++) {
            if (answer[i][0] == 0) {
                sb.append(0 + "\n");
            }
            else {
                sb.append(answer[i][0] + " " + answer[i][1] + "\n");
            }
        }
        
        System.out.print(sb);
        br.close();
    }
}