import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
		int T;
		T = Integer.parseInt(br.readLine());
        int start = 400;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[][] bottle = new int[800][800];
            PriorityQueue<Integer[]> inActive = new PriorityQueue<>((x, y) -> {if (x[0] == y[0]) return y[1] - x[1];  return x[0] - y[0];});
            List<Integer> active = new ArrayList<>();
            tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            int M = Integer.parseInt(tk.nextToken());
            int K = Integer.parseInt(tk.nextToken());
            
            for (int i = 0; i < N; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int life = Integer.parseInt(tk.nextToken());
                    if (life == 0) continue;
                    bottle[start + i][start + j] = life;
					inActive.add(new Integer[] {life, life, start + i, start + j});
                }
            }
            
            while (K > 0) {
                if (!active.isEmpty()) {
                    for (int i = 0; i < active.size(); i++) {
                        active.set(i, active.get(i) - 1);
                    }
                }
                
                while (!inActive.isEmpty() && inActive.peek()[0] == 0) {
                    Integer[] e = inActive.remove();
                    int life = e[1];
                    int curI = e[2];
                    int curJ = e[3];
                    active.add(life - 1);

                    for (int d = 0; d < 4; d++) {
                        int nextI = curI + di[d];
                        int nextJ = curJ + dj[d];
                        if (bottle[nextI][nextJ] != 0) continue;
                        bottle[nextI][nextJ] = life;
                        inActive.add(new Integer[] {life + 1, life, nextI, nextJ});
                    }
                }
                
                if (!inActive.isEmpty()) {
                    for (Integer[] inActiveEle : inActive) inActiveEle[0]--;
                }
                
                K--;
            }
            int answer = inActive.size();
            
            for (Integer e : active) {
                if (e > 0) answer++;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
        
        br.close();
	}
}