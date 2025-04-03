import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] distance = new boolean[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            distance[a][b] = true;
        }

        for (int c = 1; c <= n; c++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = distance[i][j] || (distance[i][c] && distance[c][j]);
                }
            }
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (distance[a][b])
                sb.append("-1\n");
            else if (distance[b][a])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb);
        br.close();
    }
}