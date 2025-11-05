import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] price = new int[11];
        int[] dp = new int[n + 1];
        Set<Integer>[] setArr = new Set[n + 1];
        Arrays.fill(dp, -1);
        
        for (int i = 0; i <= n; i++) {
            setArr[i] = new HashSet<>();
        }
        
        dp[0] = 0;
        int aScore = 0;
        
        for (int i = 1; i < 11; i++) {
            price[i] = info[10 - i] + 1;
            
            if (info[10 - i] > 0) {
                aScore += i;
            }
        }
        
        for (int i = 1; i < 11; i++) {
            int p = price[i];
            int v = i;
            if (p > 1) {
                v += i;
            }
            
            for (int j = n; j - p >= 0; j--) {
                if (dp[j - p] == -1) {
                    continue;
                }
                
                if (dp[j - p] + v > dp[j]) {
                    dp[j] = dp[j - p] + v;
                    setArr[j] = new HashSet<>(setArr[j - p]);
                    setArr[j].add(i);
                }
                else if (dp[j - p] + v == dp[j] && (j - p) != 0) {
                    int curMinEle = Integer.MAX_VALUE;
                    for (int e : setArr[j]) {
                        curMinEle = Math.min(curMinEle, e);
                    }
                    
                    int tempMinEle = Integer.MAX_VALUE;
                    for (int e : setArr[j - p]) {
                        tempMinEle = Math.min(tempMinEle, e);
                    }
                    
                    if (tempMinEle < curMinEle) {
                        setArr[j] = new HashSet<>(setArr[j - p]);
                        setArr[j].add(i);
                    }
                    else if(tempMinEle == curMinEle) {
                        return new int[1];
                    }
                }
            }
        }
        
        int maxVal = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if ((dp[i] - aScore) > 0 && dp[i] > maxVal) {
                maxVal = dp[i];
                cnt = i;
            } else if ((dp[i] - aScore) > 0 && dp[i] == maxVal) {
                
            }
        }
        
        if (maxVal == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            int[] temp = new int[11];
            for (int e : setArr[cnt]) {
                temp[e] = price[e];
            }
            temp[0] = n - cnt;
            
            for (int i = 0; i < 11; i++) {
                answer[i] = temp[10 - i];
            }
        }
        
        return answer;
    }
}