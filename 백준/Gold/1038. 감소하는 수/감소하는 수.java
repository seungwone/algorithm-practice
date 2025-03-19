import java.io.*;
import java.util.*;

class Main {
    static int C;
    static StringBuilder sb;
    static List<Long> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        for (long i = 0; i <= 9; i++)
            answer.add(i);

        for (int i = 1; i <= 9; i++) {
            C = i;
            for (int j = i; j <= 9; j++) {
                sb = new StringBuilder();
                sb.append(j);
                dfs(0);
            }
        }
        
        if (N >= answer.size())
            System.out.println(-1);
        else
            System.out.println(answer.get(N));
        br.close();
    }

    public static void dfs(int round) {
        if (round == C) {
            answer.add(Long.parseLong(sb.toString()));
            return;
        }

        for (int i = 0; i < sb.charAt(sb.length() - 1) - '0'; i++) {
            sb.append(i);
            dfs(round + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}