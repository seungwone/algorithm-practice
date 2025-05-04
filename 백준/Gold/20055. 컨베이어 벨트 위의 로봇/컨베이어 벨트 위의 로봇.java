import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] durability = new int[2 * N + 1];
        boolean[] robots = new boolean[2 * N + 1];
        int level = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++)
            durability[i] = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        while (true) {
            int prev = durability[1];
            boolean prev2 = robots[1];
            for (int i = 2; i <= 2 * N; i++) {
                int temp = durability[i];
                boolean temp2 = robots[i];
                durability[i] = prev;
                robots[i] = prev2;
                prev = temp;
                prev2 = temp2;
            }
            durability[1] = prev;
            robots[1] = prev2;

            robots[N] = false;

            for (int i = N - 1; i >= 1; i--) {
                if (robots[i] && !robots[i + 1] && durability[i + 1] >= 1) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    durability[i + 1]--;
                    if (durability[i + 1] == 0)
                        cnt++;
                }
            }

            robots[N] = false;

            if (durability[1] > 0) {
                durability[1]--;
                if (durability[1] == 0)
                    cnt++;
                robots[1] = true;
            }

            if (cnt >= K)
                break;

            level++;
        }

        System.out.println(level);
        br.close();
    }
}