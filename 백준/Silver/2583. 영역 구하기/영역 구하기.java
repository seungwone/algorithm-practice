import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int[][] paper = new int[M][N];
        boolean[][] isVisited = new boolean[M][N];
        int count = 0;
        List<Integer> result = new ArrayList<>();
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int i = 0; i < K; i++) {
            tk = new StringTokenizer(br.readLine());
            int j1 = Integer.parseInt(tk.nextToken());
            int i2 = (M - 1) - Integer.parseInt(tk.nextToken());
            int j2 = Integer.parseInt(tk.nextToken()) - 1;
            int i1 = M - Integer.parseInt(tk.nextToken());

            for (int a = i1; a <= i2; a++) {
                for (int b = j1; b <= j2; b++) {
                    paper[a][b] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] != 0 || isVisited[i][j]) continue;

                count++;
                Deque<Integer[]> deque = new ArrayDeque<>();
                deque.add(new Integer[] {i, j});

                int temp = 0;
                while (!deque.isEmpty()) {
                    Integer[] e = deque.remove();
                    int curI = e[0];
                    int curJ = e[1];

                    if (isVisited[curI][curJ] == true) continue;
                    temp++;
                    isVisited[curI][curJ] = true;

                    for (int d = 0; d < 4; d++) {
                        int ni = curI + di[d];
                        int nj = curJ + dj[d];
    
                        if (ni >= 0 && ni < M && nj >= 0 && nj < N && paper[ni][nj] == 0 && isVisited[ni][nj] == false) {
                            deque.add(new Integer[] {ni, nj});
                        }
                    }
                }
                result.add(temp);
            }
        }

        Collections.sort(result);

        System.out.println(count);
        for (int n : result) System.out.print(n + " ");
        System.out.println();
        br.close();
    }
}