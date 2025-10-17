def solution(numbers):
    answer = [0] * len(numbers)
    
    for i, n in enumerate(numbers):
        if n == 1:
            answer[i] = 1
            continue
        
        bi = []
        temp = n
        
        while temp:
            bi.append(temp % 2)
            temp //= 2
        
        temp_l = len(bi)
        cnt = 2
        
        while temp_l >= cnt:
            cnt *= 2
        
        bi.extend([0] * (cnt - 1 - temp_l))
            
        l = len(bi)
        cnt_sum = [0] * l
        dfs(bi, cnt_sum, 0, l - 1)
        mid = (l - 1) // 2
        
        if bi[mid] == 1 and check(bi, cnt_sum, 0, mid - 1) and check(bi, cnt_sum, mid + 1, l - 1):
            answer[i] = 1
        
    return answer


def dfs(tree, cnt_sum, st, ed):
    if st == ed:
        cnt_sum[st] = tree[st]
        return cnt_sum[st]
    
    mid = (st + ed) // 2
    
    cnt_sum[mid] = tree[mid] + dfs(tree, cnt_sum, st, mid - 1) + dfs(tree, cnt_sum, mid + 1, ed)
    return cnt_sum[mid]
    

def check(tree, cnt_sum, st, ed):
    if st == ed:
        return True
    
    mid = (st + ed) // 2
    
    if tree[mid] == 1:
        return check(tree, cnt_sum, st, mid - 1) and check(tree, cnt_sum, mid + 1, ed)
    elif tree[mid] == 0:
        if cnt_sum[(st + mid - 1) // 2] > 0 or cnt_sum[(mid + 1 + ed) // 2] > 0:
            return False
    
    return True
    