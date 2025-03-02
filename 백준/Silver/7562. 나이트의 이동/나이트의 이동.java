import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] di = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] dj = {-1, 1, -1, 1, -2, 2, -2, 2};

        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            int startI = Integer.parseInt(temp[0]);
            int startJ = Integer.parseInt(temp[1]);

            temp = br.readLine().split(" ");
            int endI = Integer.parseInt(temp[0]);
            int endJ = Integer.parseInt(temp[1]);

            int[][] table = new int[l][l];
            Deque<Integer[]> dq = new ArrayDeque<>();
            dq.add(new Integer[] {startI, startJ});
            table[startI][startJ] = 1;

            while (!dq.isEmpty()) {
                Integer[] ele = dq.remove();
                int curI = ele[0];
                int curJ = ele[1];
                int price = table[curI][curJ];

                if (curI == endI && curJ == endJ) {
                    sb.append(price - 1 + "\n");
                    break;
                }

                for (int d = 0; d < 8; d++) {
                    int nextI = curI + di[d];
                    int nextJ = curJ + dj[d];
                    
                    if (nextI >= 0 && nextI < l && nextJ >= 0 && nextJ < l && table[nextI][nextJ] == 0) {
                        table[nextI][nextJ] = price + 1;
                        dq.add(new Integer[] {nextI, nextJ});
                    }
                }
            }
        }
        

        System.out.println(sb);
        br.close();
    }
}