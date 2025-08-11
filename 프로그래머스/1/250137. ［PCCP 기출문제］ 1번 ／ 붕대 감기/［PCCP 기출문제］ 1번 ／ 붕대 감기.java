class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int curT = 0;
        int curH = health;
        
        for (int[] ele : attacks) {
            int t = ele[0];
            int power = ele[1];
            int cnt = t - curT - 1;
            curH += cnt * bandage[1];
            curH += (cnt / bandage[0]) * bandage[2];
            curH = Math.min(curH, health);
            curH -= power;
            curT = t;
            
            if (curH <= 0) {
                break;
            }
        }
        
        answer = curH;
        
        if (answer <= 0) {
            answer = -1;
        }
        
        return answer;
    }
}