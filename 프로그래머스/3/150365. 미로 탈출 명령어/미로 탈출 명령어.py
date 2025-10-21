def solution(n, m, x, y, r, c, k):
    answer = 'impossible'
    di = [-1, 0, 0, 1]
    dj = [0, 1, -1, 0]
    dd = ['u', 'r', 'l', 'd']
    stack = []
    stack.append((x, y, ''))
    
    while stack:
        cur_i, cur_j, cur_str = stack.pop()
        str_len = len(cur_str)
        s_path = abs(cur_i - r) + abs(cur_j - c)
        
        if cur_i == r and cur_j == c and str_len == k:
            answer = cur_str
            break
        
        if str_len + s_path > k or (k - (str_len + s_path)) % 2 == 1:
            continue
        
        for d in range(4):
            next_i = cur_i + di[d]
            next_j = cur_j + dj[d]
            next_str = cur_str + dd[d]
            
            if 1 <= next_i <= n and 1 <= next_j <= m:
                stack.append((next_i, next_j, next_str))
    
    return answer