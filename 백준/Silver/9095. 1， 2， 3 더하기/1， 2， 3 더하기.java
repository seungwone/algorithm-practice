import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            product(0);
            sb.append(answer + "\n");
        }
        
        System.out.print(sb);
        br.close();
    }

    public static void product(int sum) {
        if (sum == n) {
            answer++;
            return;
        }

        if (sum > n)
            return;

        for (int i = 1; i <= 3; i++) {
            product(sum + i);
        }
    }
}