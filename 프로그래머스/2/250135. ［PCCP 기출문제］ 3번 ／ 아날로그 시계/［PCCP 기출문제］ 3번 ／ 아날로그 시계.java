class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        
        int mod = 3600 * 12;
        
        h1 = h1 * 3600 + (m1 * 60 + s1);
        m1 = m1 * 720 + s1 * 12;
        s1 = s1 * 720;
        
        if (startTime == 0 || startTime == 12 * 3600)
            answer++;
        
        while (startTime < endTime) {
            h1 += 1;
            m1 += 12;
            s1 += 720;
            
            if (s1 - 720 < m1 - 12 && m1 <= s1)
                answer++;
            
            if (s1 - 720 < h1 - 1 && h1 <= s1)
                answer++;
            
            h1 %= mod;
            m1 %= mod;
            s1 %= mod;
            
            startTime++;
            
            if (startTime == 12 * 3600)
                answer--;
        }
        
        return answer;
    }
}