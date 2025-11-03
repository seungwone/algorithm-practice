import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int l = records.length;
        Map<String, Integer> map = new HashMap<>(l);
        Map<String, Integer> result = new HashMap<>(l);
        
        for (String r : records) {
            String[] temp = r.split(" ");
            String[] time = temp[0].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            
            if ("IN".equals(temp[2])) {
                map.put(temp[1], h * 60 + m);
            } else if (map.containsKey(temp[1])) {
                int gap = (h * 60 + m) - map.get(temp[1]);
                int val = 0;
                if (result.containsKey(temp[1])) {
                    val = result.get(temp[1]);
                }
                result.put(temp[1], val + gap);
                map.remove(temp[1]);
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            
            int prev = 0;
            if (result.containsKey(key)) {
                prev = result.get(key);
            }
            
            result.put(key, prev + (23 * 60 + 59) - val);
        }
        
        List<String> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList);
        answer = new int[keyList.size()];
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            int val = result.get(key);
            int price = fees[1];
            if (val <= fees[0]) {
                answer[i] = price;
                continue;
            }
            
            price += ((val - fees[0]) / fees[2]) * fees[3];
            if ((val - fees[0]) % fees[2] != 0) {
                price += fees[3];
            }
            
            answer[i] = price;
        }
        
        return answer;
    }
}