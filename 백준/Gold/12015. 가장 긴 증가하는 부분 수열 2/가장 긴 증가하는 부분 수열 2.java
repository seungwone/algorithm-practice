import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (list.isEmpty()) {
                list.add(val);
                continue;
            }

            if (val > list.get(list.size() - 1)) {
                list.add(val);
                continue;
            }

            int left = 0;
            int right = list.size() - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;

                if (list.get(mid) == val)
                    break;
                
                if (list.get(mid) < val)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            if (list.get(mid) < val)
                list.set(mid + 1, val);
            else
                list.set(mid, val);
        }

        System.out.println(list.size());
        br.close();
    }
}