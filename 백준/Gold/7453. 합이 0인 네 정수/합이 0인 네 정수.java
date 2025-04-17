import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] list1 = new int[n * n];
        int[] list2 = new int[n * n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list1[cnt] = A[i] + B[j];
                list2[cnt++] = C[i] + D[j];
            }
        }

        Arrays.parallelSort(list1);
        Arrays.parallelSort(list2);

        int p1 = 0;
        int p2 = n * n - 1;

        long answer = 0;
        while (p1 < n * n && p2 >= 0) {
            int val = list1[p1] + list2[p2];

            if (val == 0) {
                long cnt1 = 1;
                while (p1 < n * n - 1 && list1[p1] == list1[p1 + 1]) {
                    p1++;
                    cnt1++;
                }
                p1++;
                long cnt2 = 1;
                while (p2 > 0 && list2[p2] == list2[p2 - 1]) {
                    p2--;
                    cnt2++;
                }
                p2--;
                answer += cnt1 * cnt2;
            }
            else if (val > 0) {
                p2--;
            }
            else {
                p1++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}