import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

		for (int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 0;
            int l = Integer.parseInt(br.readLine());
            char[][] board = new char[8][8];
            
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            
            // 가로
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - l + 1; j++) {
                    boolean isPalindrome = true;
                    for (int d = 0; d < l / 2; d++) {
                        int front = j + d;
                        int back = j + l - 1 - d;
                        if (board[i][front] != board[i][back]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) answer++;
                }
            }
            
            // 세로
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - l + 1; j++) {
                    boolean isPalindrome = true;
                    for (int d = 0; d < l / 2; d++) {
                        int front = j + d;
                        int back = j + l - 1 - d;
                        if (board[front][i] != board[back][i]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) answer++;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
        
        br.close();
	}
}