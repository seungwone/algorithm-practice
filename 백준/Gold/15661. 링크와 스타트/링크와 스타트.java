import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int answer;

    public static void main(String[] args) throws IOException {
        answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        selected = new boolean[N];
        dfs(0, 0);

        System.out.println(answer);
        br.close();
    }

    public static void dfs(int cnt, int round) {
        if (round == N || cnt == N / 2) {
            int team1 = 0;
            int team2 = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] != selected[j])
                        continue;
                    if (selected[i] == true)
                        team1 += S[i][j] + S[j][i];
                    else
                        team2 += S[i][j] + S[j][i];
                }
            }

            answer = Math.min(answer, Math.abs(team1 - team2));

            return;
        }

        selected[round] = true;
        dfs(cnt + 1, round + 1);
        selected[round] = false;
        dfs(cnt, round + 1);
    }
}