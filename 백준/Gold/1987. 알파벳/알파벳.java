import java.io.*;
import java.util.*;

class Main {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        boolean[] isSelected = new boolean[26];
        isSelected[board[0][0] - 'A'] = true;
        dfs(0, 0, 1, isSelected);

        System.out.println(answer);
        br.close();
    }

    public static void dfs(int curI, int curJ, int cnt, boolean[] isSelected) {
        answer = Math.max(answer, cnt);

        for (int d = 0; d < 4; d++) {
            int nextI = curI + di[d];
            int nextJ = curJ + dj[d];

            if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C && !isSelected[board[nextI][nextJ] - 'A']) {
                char alpha = board[nextI][nextJ];
                isSelected[alpha - 'A'] = true;
                dfs(nextI, nextJ, cnt + 1, isSelected);
                isSelected[alpha - 'A'] = false;
            }
        }
    }
}