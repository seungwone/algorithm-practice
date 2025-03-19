import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int maxLen = Math.max(str1.length(), str2.length());
        char[] arr1 = new char[maxLen + 1];
        char[] arr2 = new char[maxLen + 1];
        for (int i = 1; i <= maxLen; i++) {
            if (i <= str1.length())
                arr1[i] = str1.charAt(i - 1);
            if (i <= str2.length())
                arr2[i] = str2.charAt(i - 1);
        }

        int[][] dp = new int[maxLen + 1][maxLen + 1];

        for (int i = 1; i <= maxLen; i++) {
            for (int j = 1; j <= maxLen; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (arr1[i] == arr2[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }

        System.out.println(dp[maxLen][maxLen]);
        br.close();
    }
}