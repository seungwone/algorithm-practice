import java.io.*;
import java.util.*;

class Main {
    static long answer = -1;
    static long B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long A = Integer.parseInt(temp[0]);
        B = Integer.parseInt(temp[1]);

        dfs(A, 1);

        System.out.println(answer);
        br.close();
    }

    public static void dfs(long x, long cnt) {
        if (answer != -1) return;

        if (x > B) return;

        if (x == B) {
            answer = cnt;
            return;
        }

        dfs(x * 10 + 1, cnt + 1);
        dfs(x * 2, cnt + 1);
    } 
}