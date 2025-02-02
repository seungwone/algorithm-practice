import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] miro = new int[N+2][M+2];
        boolean[][] isVisited = new boolean[N+2][M+2];
        int[] di = {-1,0,0,1};
        int[] dj = {0,-1,1,0};
        Deque<Integer[]> deque = new ArrayDeque<>();

        for (int i = 1; i < N+1; i++) {
            String temp = sc.next();
            for (int j = 1; j < M+1; j++) miro[i][j] = (temp.charAt(j-1) - '0');
        }

        deque.add(new Integer[] {1,1});

        while (!deque.isEmpty()) {
            Integer[] cur = deque.remove();
            int curI = cur[0];
            int curJ = cur[1];

            if (isVisited[curI][curJ]) continue;

            isVisited[curI][curJ] = true;

            for (int i = 0; i < 4; i++) {
                int nextI = curI + di[i];
                int nextJ = curJ + dj[i];

                if (!isVisited[nextI][nextJ] && miro[nextI][nextJ] != 0) {
                    deque.add(new Integer[] {nextI, nextJ});
                    miro[nextI][nextJ] = miro[curI][curJ] + 1;
                }
            }
        }

        System.out.println(miro[N][M]);
    }
}