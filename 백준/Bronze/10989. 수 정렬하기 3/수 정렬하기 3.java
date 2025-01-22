import java.io.*;

class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] count = new int[10001];

    for (int i = 0; i < N; i++){
      count[Integer.parseInt(br.readLine())]++;
    }


    for (int j = 1; j < 10001; j++){
      for (int c = 0; c < count[j]; c++){
        bw.write(Integer.toString(j));
        bw.newLine();
      }
    }

    bw.flush();
  }
}
