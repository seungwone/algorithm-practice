import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        int answer = 0;

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(temp[i]);
        temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(temp[i]);

        Arrays.sort(A);
        Arrays.sort(B, (x, y) -> y - x);

        for (int i = 0; i < N; i++) answer += A[i] * B[i];

        System.out.println(answer);
        br.close();
    }
}