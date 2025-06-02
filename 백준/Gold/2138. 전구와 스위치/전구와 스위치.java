import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] cur = new boolean[N + 2];
        boolean[] cur2 = new boolean[N + 2];
        boolean[] target = new boolean[N + 2];
        int cnt = 0;
        int cnt2 = 0;
        int answer = Integer.MAX_VALUE;

        String str = br.readLine();
        String str2 = br.readLine();
        for (int i = 1; i <= N; i++) {
            cur[i] = str.charAt(i - 1) == '1';
            cur2[i] = str.charAt(i - 1) == '1';
            target[i] = str2.charAt(i - 1) == '1';
        }

        cur[1] = !cur[1];
        cur[2] = !cur[2];
        cnt++;
        for (int i = 2; i <= N; i++) {
            if (cur[i - 1] != target[i - 1]) {
                cur[i - 1] = !cur[i - 1];
                cur[i] = !cur[i];
                cur[i + 1] = !cur[i + 1];
                cnt++;
            }

            if (cur2[i - 1] != target[i - 1]) {
                cur2[i - 1] = !cur2[i - 1];
                cur2[i] = !cur2[i];
                cur2[i + 1] = !cur2[i + 1];
                cnt2++;
            }
        }

        boolean isPossible = true;
        boolean isPossible2 = true;
        for (int i = 1; i <= N; i++) {
            if (cur[i] != target[i])
                isPossible = false;
            if (cur2[i] != target[i])
                isPossible2 = false;

            if (!isPossible && !isPossible2)
                break;
        }

        if (isPossible)
            answer = cnt;

        if (isPossible2)
            answer = Math.min(answer, cnt2);

        if (answer == Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);
        br.close();
    }
}