import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Set<String>> tree = new HashMap<>();
        Set<String> folderSet = new HashSet<>();
        
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            boolean isFolder = Integer.parseInt(st.nextToken()) == 1;
            if (isFolder)
                folderSet.add(child);

            if (!tree.containsKey(parent)) {
                tree.put(parent, new HashSet<>());
            }
            tree.get(parent).add(child);
        }

        int K = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String from = st.nextToken();
            String to = st.nextToken();

            String[] fromVals = from.split("/");
            from = fromVals[fromVals.length - 1];
            String[] toVals = to.split("/");
            to = toVals[toVals.length - 1];
            
            if (!tree.containsKey(to)) {
                tree.put(to, new HashSet<>());
            }
            if (!tree.containsKey(from)) {
                tree.put(from, new HashSet<>());
            }

            tree.get(to).addAll(tree.get(from));
            tree.get(from).clear();
        }

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            String path = br.readLine();
            String[] temp = path.split("/");
            path = temp[temp.length - 1];

            Set<String> set = new HashSet<>();
            Deque<String> dq = new ArrayDeque<>();
            dq.add(path);

            int cnt = 0;
            while(!dq.isEmpty()) {
                String cur = dq.remove();

                if (!tree.containsKey(cur))
                    tree.put(cur, new HashSet<>());

                for (String child : tree.get(cur)) {
                    if (folderSet.contains(child)) {
                        dq.add(child);
                    }
                    else {
                        cnt++;
                        set.add(child);
                    }
                }
            }

            sb.append(set.size() + " " + cnt + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}