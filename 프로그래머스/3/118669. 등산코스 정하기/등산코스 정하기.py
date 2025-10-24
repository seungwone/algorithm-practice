def union(parent, x, y):
    if x > y:
        x, y = y, x
    root_x = find(parent, x)
    root_y = find(parent, y)
    
    parent[root_y] = parent[root_x]
    

def find(parent, x):
    if x == parent[x]:
        return x
    
    parent[x] = find(parent, parent[x])
    return parent[x]
    

def solution(n, paths, gates, summits):
    answer = []
    max_w = 0
    for i, j, w in paths:
        max_w = max(max_w, w)
    g_set = set(gates)
    s_set = set(summits)
        
    left = 1
    right = max_w
    
    min_i = 0
    while left <= right:
        mid = (left + right) // 2
        parent = [i for i in range(n + 1)]
        is_g_in = [False] * (n + 1)
        is_s_in = [False] * (n + 1)
        
        is_possible = False
        for i, j, w in paths:
            if w > mid:
                continue
            
            root_i = find(parent, i)
            root_j = find(parent, j)
            
            g_in = is_g_in[root_i] or is_g_in[root_j] or i in g_set or j in g_set
            s_in = is_s_in[root_i] or is_s_in[root_j] or i in s_set or j in s_set
            
            if g_in and s_in:
                is_possible = True
                break
            
            union(parent, root_i, root_j)
            is_g_in[find(parent, root_i)] = g_in
            is_s_in[find(parent, root_i)] = s_in
            
        if is_possible:
            right = mid - 1
            min_i = mid
        else:
            left = mid + 1
            
    adj_li = [[] for _ in range(n + 1)]
    for i, j, w in paths:
        if w > min_i:
            continue
        adj_li[i].append(j)
        adj_li[j].append(i)
    
    parent = [i for i in range(n + 1)]
    is_g_in = [False] * (n + 1)
    is_s_in = [False] * (n + 1)
    is_visited = [False] * (n + 1)
    
    for summit in sorted(summits):
        stack = []
        stack.append(summit)
        is_visited[summit] = True
        is_p = False

        while stack:
            cur = stack.pop()

            if cur in g_set:
                is_p = True
                break

            for nxt in adj_li[cur]:
                if not is_visited[nxt] and nxt not in s_set:
                    stack.append(nxt)
                    is_visited[nxt] = True

        if is_p:
            answer = [summit, min_i]
            break
    
    return answer