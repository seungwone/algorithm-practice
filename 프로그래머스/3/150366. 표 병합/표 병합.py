def union(parent, x1, x2):
    if x1 > x2:
        x1, x2 = x2, x1
    parent[find(parent, x2)] = find(parent, x1)


def find(parent, x):
    if x == parent[x]:
        return x
    
    parent[x] = find(parent, parent[x])
    return parent[x]


def solution(commands):
    answer = []
    table = [''] * 2501
    parent = [i for i in range(2501)]
    
    for c in commands:
        c_li = c.split()
        c1 = c_li[0]
        
        if c1 == 'UPDATE' and len(c_li) == 4:
            r, c, val = int(c_li[1]), int(c_li[2]), c_li[3]
            root_idx = find(parent, (r - 1) * 50 + c)
            table[root_idx] = val
            
        elif c1 == 'UPDATE' and len(c_li) == 3:
            val1, val2 = c_li[1], c_li[2]
            for i in range(1, 2501):
                root_idx = find(parent, i)
                if table[root_idx] == val1:
                    table[root_idx] = val2
            
        elif c1 == 'MERGE':
            r1, c1, r2, c2 = int(c_li[1]), int(c_li[2]), int(c_li[3]), int(c_li[4])
            root_idx1 = find(parent, (r1 - 1) * 50 + c1)
            root_idx2 = find(parent, (r2 - 1) * 50 + c2)
            
            val = table[root_idx2]
            if table[root_idx1]:
                val = table[root_idx1]
            
            union(parent, root_idx1, root_idx2)
            new_idx = find(parent, root_idx1)
            table[new_idx] = val
            
        elif c1 == 'UNMERGE':
            r, c = int(c_li[1]), int(c_li[2])
            idx = (r - 1) * 50 + c
            root_idx = find(parent, (r - 1) * 50 + c)
            val = table[root_idx]
            temp_li = []
            
            for i in range(1, 2501):
                if root_idx == find(parent, i):
                    temp_li.append(i)
            
            for i in temp_li:
                parent[i] = i
                table[i] = ''
            
            table[idx] = val
        
        elif c1 == 'PRINT':
            r, c = int(c_li[1]), int(c_li[2])
            root_idx = find(parent, (r - 1) * 50 + c)
            
            answer.append(table[root_idx])
            if not table[root_idx]:
                answer[-1] = "EMPTY"
    
    return answer