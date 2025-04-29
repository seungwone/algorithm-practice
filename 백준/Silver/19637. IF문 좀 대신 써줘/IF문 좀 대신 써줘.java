import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] title = new String[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        String[] answer = new String[M];
        Integer[][] arr = new Integer[M][2];
        for (int i = 0; i < M; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        Arrays.sort(arr, (x, y) -> Integer.compare(x[0], y[0]));

        int powerIdx = 0;
        for (Integer[] ele : arr) {
            int val = ele[0];
            int idx = ele[1];
            if (val <= power[powerIdx]) {
                answer[idx] = title[powerIdx];
            }
            else {
                while (power[powerIdx] < val) {
                    powerIdx++;
                }
                answer[idx] = title[powerIdx];
            }
        }

        for (String str : answer)
            sb.append(str + "\n");
            
        System.out.print(sb);
        br.close();
    }
}