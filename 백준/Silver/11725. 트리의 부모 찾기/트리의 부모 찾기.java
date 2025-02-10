import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List < Integer > [] adjList = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList < > ();
		Deque < Integer > deque = new ArrayDeque < > ();
		boolean[] isVisited = new boolean[N + 1];
		int[] result = new int[N + 1];
      
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
      
		deque.add(1);
		while(!deque.isEmpty()) {
			int cur = deque.remove();
			if(isVisited[cur]) continue;
			isVisited[cur] = true;
			for(int e: adjList[cur]) {
				if(isVisited[e]) continue;
				result[e] = cur;
				deque.add(e);
			}
		}
      
		for(int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}