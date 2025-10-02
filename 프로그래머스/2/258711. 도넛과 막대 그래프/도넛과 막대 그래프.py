def solution(edges):
    answer = []
    
    node_cnt = 0
    for a, b in edges:
        node_cnt = max(node_cnt, a)
        node_cnt = max(node_cnt, b)
    
    in_cnt = [0] * (node_cnt + 1)
    out_cnt = [0] * (node_cnt + 1)
    adjLi = [[] for _ in range(node_cnt + 1)]
    
    for a, b in edges:
        out_cnt[a] += 1
        in_cnt[b] += 1
        adjLi[a].append(b)
        
    created_node = 0
    for i in range(1, node_cnt + 1):
        if in_cnt[i] == 0 and out_cnt[i] >= 2:
            created_node = i
            break
    
    donut = 0
    bar = 0
    eight = 0
    for n in adjLi[created_node]:
        start = n
        cur = n
        is_start = True
        while adjLi[cur]:
            if len(adjLi[cur]) >= 2:
                eight += 1
                break
            if cur == start:
                if is_start:
                    is_start = False
                else:
                    donut += 1
                    break
            cur = adjLi[cur][0]
        
        if len(adjLi[cur]) == 0:
            bar += 1
    
    answer.append(created_node)
    answer.append(donut)
    answer.append(bar)
    answer.append(eight)
    
    return answer