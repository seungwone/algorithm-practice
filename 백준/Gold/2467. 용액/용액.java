import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N - 1;
        int minVal = Integer.MAX_VALUE;
        int answer1 = arr[left];
        int answer2 = arr[right];
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            int gap = Math.abs(sum);
            
            if (gap < minVal) {
                minVal = gap;
                answer1 = arr[left];
                answer2 = arr[right];
            }
            
            if (sum == 0) {
                break;
            }
            
            if (sum < 0) {
                left++;
                continue;
            }
            
            if (sum > 0) {
                right--;
                continue;
            }
        }
        
        System.out.println(answer1 + " " + answer2);
        br.close();
    }
}