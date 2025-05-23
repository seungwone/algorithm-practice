import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] dist = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                boolean isPossible = Integer.parseInt(st.nextToken()) == 1;
                dist[i][j] = isPossible;
                dist[j][i] = isPossible;
                if (i == j)
                    dist[i][j] = true;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = dist[i][j] || (dist[i][k] && dist[k][j]);
                }
            }
        }


        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M + 1];
        for (int i = 1; i <= M; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        String answer = "YES";
        for (int i = 1; i + 1 <= M; i++) {
            if (!dist[arr[i]][arr[i + 1]]) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}