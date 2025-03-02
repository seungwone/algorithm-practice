import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int[][] miro = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                miro[i][j] = Math.max(miro[i - 1][j], miro[i][j - 1]) + Integer.parseInt(temp[j - 1]);
            }
        }

        System.out.println(miro[N][M]);
        br.close();
    }
}