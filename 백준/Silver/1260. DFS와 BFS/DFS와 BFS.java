import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N, M, V;

    N = sc.nextInt();
    M = sc.nextInt();
    V = sc.nextInt();

    List<Integer>[] adjList = new ArrayList[N+1];
    boolean[] dfsIsVisited = new boolean[N+1];
    boolean[] bfsIsVisited = new boolean[N+1];

    for (int i = 0; i < N+1; i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int j = 0; j < M; j++) {
      int a, b;
      a = sc.nextInt();
      b = sc.nextInt();

      adjList[a].add(b);
      adjList[b].add(a);
    }

    for (int k = 0; k < N+1; k++) {
      Collections.sort(adjList[k]);
    }

    List<Integer> dfsResult = new ArrayList<>();
    dfs(adjList, V, dfsIsVisited, dfsResult);
    for (int e : dfsResult) {
      System.out.print(e + " ");
    }
    System.out.println();

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(V);

    while (!deque.isEmpty()) {
      int cur = deque.poll();
      if (bfsIsVisited[cur]) continue;

      System.out.print(cur + " ");
      bfsIsVisited[cur] = true;

      for (int e : adjList[cur]) {
        deque.add(e);
      }
    }
    System.out.println();
  }

  public static void dfs(List<Integer>[] adjList, int node, boolean[] isVisited, List<Integer> result) {
    if (isVisited[node]) {
      return;
    }

    result.add(node);
    isVisited[node] = true;

    for (int i = 0; i < adjList[node].size(); i++) {
      dfs(adjList, adjList[node].get(i), isVisited, result);
    }
  }

  public static void bfs(List<Integer>[] adjList, int node, boolean[] isVisited, List<Integer> result) {
    if (isVisited[node]) {
      return;
    }

    result.add(node);
    isVisited[node] = true;

    for (int i = 0; i < adjList[node].size(); i++) {
      dfs(adjList, adjList[node].get(i), isVisited, result);
    }
  }
}