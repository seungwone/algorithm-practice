import java.io.*;
import java.util.*;

class Main {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] board;
    static Set<String>[][] isVisited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        isVisited = new Set[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);
                isVisited[i][j] = new HashSet<>();
            }
        }

        Set<Character> s = new HashSet<>();
        s.add(board[0][0]);
        dfs(0, 0, 1, s);

        System.out.println(answer);
        br.close();
    }

    public static void dfs(int curI, int curJ, int cnt, Set<Character> set) {
        List<Character> list = new ArrayList<>();
        for (char c : set)
            list.add(c);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(c);
        String key = sb.toString();
        
        if (isVisited[curI][curJ].contains(key))
            return;
        isVisited[curI][curJ].add(key);

        answer = Math.max(answer, cnt);

        for (int d = 0; d < 4; d++) {
            int nextI = curI + di[d];
            int nextJ = curJ + dj[d];

            if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C && !set.contains(board[nextI][nextJ])) {
                set.add(board[nextI][nextJ]);
                dfs(nextI, nextJ, cnt + 1, set);
                set.remove(board[nextI][nextJ]);
            }
        }
    }
}