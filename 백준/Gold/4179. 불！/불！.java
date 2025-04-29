import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] maze = new char[R + 2][C + 2];
        Deque<Integer[]> dq = new ArrayDeque<>();
        int iInit = 0;
        int jInit = 0;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int i = 1; i <= R; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= C; j++) {
                maze[i][j] = temp.charAt(j - 1);
                if (maze[i][j] == 'F')
                    dq.add(new Integer[] {i, j, 1});
                if (maze[i][j] == 'J') {
                    iInit = i;
                    jInit = j;
                }
            }
        }

        dq.add(new Integer[] {iInit, jInit, 0, 0});

        int cnt = 0;
        while (!dq.isEmpty()) {
            Integer[] ele = dq.remove();
            int curI = ele[0];
            int curJ = ele[1];
            boolean isFire = ele[2] == 1;
            int time = 0;
            if (!isFire) {
                time = ele[3];
                if (maze[curI][curJ] == 0) {
                    cnt = time;
                    break;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nextI = curI + di[d];
                int nextJ = curJ + dj[d];
                if (isFire) {
                    if (maze[nextI][nextJ] == 'J' || maze[nextI][nextJ] == '.') {
                        maze[nextI][nextJ] = 'F';
                        dq.add(new Integer[] {nextI, nextJ, 1});
                    }
                }
                else {
                    if (maze[nextI][nextJ] == '.' || maze[nextI][nextJ] == 0) {
                        if (maze[nextI][nextJ] != 0)
                            maze[nextI][nextJ] = 'J';
                        dq.add(new Integer[] {nextI, nextJ, 0, time + 1});
                    }
                }        
            }
            
        }

        if (cnt == 0) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(cnt);
        }

        br.close();
    }
}