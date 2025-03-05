import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer[]> dq = new ArrayDeque<>(N);
        int[] answer = new int[N + 1];
        
        String[] temp = br.readLine().split(" ");
        for (int i = N - 1; i >= 0; i--) {
            int cur = Integer.parseInt(temp[i]);

            if (dq.isEmpty()) {
                dq.addLast(new Integer[] {cur, i + 1});
                continue;
            }

            while (!dq.isEmpty() && dq.getLast()[0] <= cur) {
                Integer[] ele = dq.removeLast();
                int val = ele[0];
                int idx = ele[1];
                answer[idx] = i + 1;
            }
            
            dq.addLast(new Integer[] {cur, i + 1});
        }

        for (int i = 1; i <= N; i++)
            sb.append(answer[i] + " ");
        
        sb.append("\n");

        System.out.println(sb);
        br.close();
    }
}