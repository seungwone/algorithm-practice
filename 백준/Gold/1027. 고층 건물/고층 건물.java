import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                
                int dx = i - j;
                int dy = buildings[i] - buildings[j];
                double a = (double) dy / (double) dx;
                double b = buildings[i] - a * i;

                boolean isPossible = true;
                if (i < j) {
                    for (int c = i + 1; c < j; c++) {
                        double y = a * c + b;
                        if (y >= 0 && y <= buildings[c]){
                            isPossible = false;
                            break;
                        }
                    }
                }
                else {
                    for (int c = i - 1; c > j; c--) {
                        double y = a * c + b;
                        if (y >= 0 && y <= buildings[c]){
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (isPossible)
                    temp++;
            }
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
        br.close();
    }
}