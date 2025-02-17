import java.util.*;
import java.io.*;

class Solution
{
    static int D;
    static int W;
    static int K;
    static boolean[][] film;
    static int answer;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer tk = new StringTokenizer(br.readLine());
            D = Integer.parseInt(tk.nextToken());
            W = Integer.parseInt(tk.nextToken());
            K = Integer.parseInt(tk.nextToken());
            film = new boolean[D][W];
            answer = Integer.MAX_VALUE;
            
            for (int i = 0; i < D; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(tk.nextToken()) == 1;
                }
            }
            
            dfs(0, 0);
            
            System.out.println("#" + test_case + " "  + answer);
		}
        
        br.close();
	}
    
    public static void dfs(int round, int count) {
        if (answer <= count) {
            return;
        }
        
        if (check()) {
            answer = Math.min(answer, count);
            return;
        }
        
        if (round == D) {
            return;            
        }
        
        boolean[] origin = new boolean[W];
        for (int j = 0; j < W; j++) origin[j] = film[round][j];
        
        // A 주입 선택
        inject(round, false);
        dfs(round + 1, count + 1);
        
        // B 주입 선택
        inject(round, true);
        dfs(round + 1, count + 1);
        
        // 원복
        for (int j = 0; j < W; j++) film[round][j] = origin[j];
        
        // 주입 미선택
        dfs(round + 1, count);
    }
    
    public static void inject(int i, boolean b) {
        for (int j = 0; j < W; j++) {
            film[i][j] = b;
        }
    }
    
    public static boolean check() {
        if (K == 1) return true;
        
        boolean[] checkArr = new boolean[W];
        
        for (int j = 0; j < W; j++) {
            int count = 1;
            for (int i = 1; i < D; i++) {
                if (film[i - 1][j] == film[i][j]) count++;
                else count = 1;
                
                if (count >= K) {
                    checkArr[j] = true;
                    break;
                }
            }
            if (checkArr[j] == false) break;
        }
        
        boolean result = true;
        for (boolean b : checkArr) result = result && b;
        
        return result;
    }
}