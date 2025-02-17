import java.util.*;
import java.io.*;

class Solution
{
    static List<Boolean>[] li = new ArrayList[5];
    static int left = 6;
    static int right = 2;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            int K = Integer.parseInt(br.readLine());

            for (int i = 1; i < 5; i++) {
                tk = new StringTokenizer(br.readLine());
                li[i] = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    li[i].add(Integer.parseInt(tk.nextToken()) == 1);
                }
            }

            for (int i = 0; i < K; i++) {
                tk = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(tk.nextToken());
                int direct = Integer.parseInt(tk.nextToken());
                
                rotate(idx, direct, 0);
            }
            
            for (int i = 1; i < 5; i++) {
                int val = 1;
                for (int j = 1; j < i; j++) val *= 2;
                
                if (li[i].get(0)) answer += val;
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }
        
        System.out.println(sb);

        br.close();
    }

    public static void rotate(int idx, int direct, int prevIdx) {
        if (idx == 1) {
            if (li[1].get(right) != li[2].get(left) && prevIdx != 2) {
                rotate(2, -direct, idx);
            }
        }
        else if (idx == 2) {
            if (li[2].get(left) != li[1].get(right) && prevIdx != 1) {
                rotate(1, -direct, idx);
            }
            if (li[2].get(right) != li[3].get(left) && prevIdx != 3) {
                rotate(3, -direct, idx);
            }
        }
        else if (idx == 3) {
            if (li[3].get(left) != li[2].get(right) && prevIdx != 2) {
                rotate(2, -direct, idx);
            }
            if (li[3].get(right) != li[4].get(left) && prevIdx != 4) {
                rotate(4, -direct, idx);
            }
        }
        else if (idx == 4) {
            if (li[4].get(left) != li[3].get(right) && prevIdx != 3) {
                rotate(3, -direct, idx);
            }
        }

        // 돌리기
        if (direct == 1) {
            li[idx].add(0, li[idx].remove(7));
        }
        else {
            li[idx].add(li[idx].remove(0));
        }
    }
}