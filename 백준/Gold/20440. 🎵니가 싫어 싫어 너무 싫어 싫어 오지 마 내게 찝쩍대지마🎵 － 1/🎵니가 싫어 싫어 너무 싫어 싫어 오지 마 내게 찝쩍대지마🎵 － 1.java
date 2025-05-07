import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] Te = new int[N];
        int[] Tx = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Te[i] = Integer.parseInt(st.nextToken());
            Tx[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Te);
        Arrays.sort(Tx);

        int cnt = 0;
        int front = 0;
        int rear = 0;
        int answerCnt = 0;
        int answerE = Te[0];
        int answerX = Tx[0];
        while (rear < N) {
            while (front < N && Te[front] < Tx[rear]) {
                cnt++;
                front++;
            }

            if (cnt == answerCnt && answerX == Te[front - 1]) {
                answerX = Tx[rear];
            }
            else if (cnt > answerCnt) {
                answerCnt = cnt;
                answerE = Te[front - 1];
                answerX = Tx[rear];
            }

            if (front == N)
                break;

            while (rear < N && Tx[rear] <= Te[front]) {
                cnt--;
                rear++;
            }
        }

        sb.append(answerCnt + "\n");
        sb.append(answerE + " " + answerX + "\n");
        
        System.out.print(sb);
        br.close();
    }
}