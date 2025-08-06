class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] arr = pos.split(":");
        int cur = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        arr = video_len.split(":");
        int max = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        arr = op_start.split(":");
        int opSt = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        arr = op_end.split(":");
        int opEd = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        
        if (cur >= opSt && cur <= opEd) {
            cur = opEd;
        }
        
        for (String c : commands) {
            if (c.equals("next")) {
                cur = Math.min(cur + 10, max);
            }
            else {
                cur = Math.max(cur - 10, 0);
            }
            
            if (cur >= opSt && cur <= opEd) {
                cur = opEd;
            }
        }
        
        String answerM = Integer.toString(cur / 60);
        String answerS = Integer.toString(cur % 60);
        
        if (answerM.length() < 2) {
            answerM = "0" + answerM;
        }
        if (answerS.length() < 2) {
            answerS = "0" + answerS;
        }
        
        return answerM + ":" + answerS;
    }
}