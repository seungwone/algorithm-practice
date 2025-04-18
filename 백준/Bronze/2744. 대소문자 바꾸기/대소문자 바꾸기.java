import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        for (char c : str) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c - 'A' + 'a'));
            }
            else
                sb.append((char) (c - 'a' + 'A'));
        }

        System.out.println(sb);
        br.close();
    }
}