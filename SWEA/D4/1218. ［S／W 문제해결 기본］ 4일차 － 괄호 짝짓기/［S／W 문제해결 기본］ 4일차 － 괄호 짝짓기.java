import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

		for (int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 1;
            Map<Character, Integer> map = new HashMap<>();
            map.put('(', 0);
            map.put('[', 0);
            map.put('{', 0);
            map.put('<', 0);
            
            int length = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    continue;
                }
                
                char key = '(';
                if (c == ']') {
                    key = '[';
                }
                else if (c == '}') {
                    key = '{';
                }
                else if (c == '>') {
                    key = '<';
                }
                
                int count = map.get(key);
                if (count == 0) {
                    answer = 0;
                    break;
                }
                
                map.put(key, count - 1);
            }
            
            if (answer == 1) {
                for (int c : map.values()) {
                    if (c != 0) {
                        answer = 0;
                        break;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}