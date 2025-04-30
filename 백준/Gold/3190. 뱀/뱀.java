import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int curDirection = 0;
        int curI = 1;
        int curJ = 1;
        Deque<Integer[]> dq = new ArrayDeque<>();
        dq.add(new Integer[] {curI, curJ});

        int[][] board = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            board[0][i] = -1;
            board[N + 1][i] = -1;
            board[i][0] = -1;
            board[i][N + 1] = -1;
        }

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 2;
        }

        int L = Integer.parseInt(br.readLine());

        
        List<Integer> times = new ArrayList<>();
        List<Character> directions = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(Integer.parseInt(st.nextToken()));
            directions.add(st.nextToken().charAt(0));
        }

        int answer = 0;
        int idx = 0;
        while (true) {
            answer++;
            int nextI = curI + di[curDirection];
            int nextJ = curJ + dj[curDirection];
            dq.add(new Integer[] {nextI, nextJ});

            if (board[nextI][nextJ] == -1 || board[nextI][nextJ] == 1) {
                break;
            }

            if (board[nextI][nextJ] != 2) {
                Integer[] ele = dq.remove();
                int tailI = ele[0];
                int tailJ = ele[1];
                board[tailI][tailJ] = 0;
            }

            board[nextI][nextJ] = 1;
            curI = nextI;
            curJ = nextJ;

            if (idx < times.size() && answer == times.get(idx)) {
                char c = directions.get(idx);

                if (c == 'D') {
                    curDirection = (curDirection + 1) % 4;
                }
                else {
                    curDirection--;
                    if (curDirection == -1)
                        curDirection = 3;
                }

                idx++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}