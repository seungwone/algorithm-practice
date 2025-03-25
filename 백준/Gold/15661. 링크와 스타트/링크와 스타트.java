import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] S;
    static int R;
    static int[] comb;
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

        for (int i = 1; i <= N / 2; i++) {
            R = i;
            comb = new int[R];
            combination(0, 0);
        }

        System.out.println(answer);
        br.close();
    }

    public static void combination(int cnt, int start) {
        if (cnt == R) {
            List<Integer> team2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                boolean isContain = false;
                for (int j = 0; j < comb.length; j++)
                    if (comb[j] == i) {
                        isContain = true;
                        break;
                    }
                if (isContain)
                    continue;
                team2.add(i);
            }
            int team1Val = 0;
            for (int i = 0; i < comb.length; i++) {
                for (int j = i + 1; j < comb.length; j++) {
                    int idx1 = comb[i];
                    int idx2 = comb[j];

                    team1Val += S[idx1][idx2];
                    team1Val += S[idx2][idx1];
                }
            }

            int team2Val = 0;
            for (int i = 0; i < team2.size(); i++) {
                for (int j = i + 1; j < team2.size(); j++) {
                    int idx1 = team2.get(i);
                    int idx2 = team2.get(j);

                    team2Val += S[idx1][idx2];
                    team2Val += S[idx2][idx1];
                }
            }

            int gap = Math.abs(team1Val - team2Val);

            answer = Math.min(answer, gap);

            return;
        }

        for (int i = start; i < N; i++) {
            comb[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }
}