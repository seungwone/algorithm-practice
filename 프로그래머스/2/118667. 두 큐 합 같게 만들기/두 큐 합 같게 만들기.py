def solution(queue1, queue2):
    answer = 1234567890
    sum_q = queue1[:]
    sum_q.extend(queue2[:])
    l = len(sum_q)
    sum_val = sum(sum_q)
    
    if sum_val % 2 == 1:
        return answer
    
    target = sum_val // 2
    
    p1 = -1
    p2 = 0
    cur = sum_q[0]
    
    while p1 <= p2:
        if cur == target:
            if p2 < l // 2:
                if p2 == l // 2 - 1:
                    answer = min(answer, p1 + 1)
                else:
                    answer = min(answer, (p1 + 1) * 2 + (p2 - p1) + (l // 2 - 1))
            elif p1 < l // 2 - 1 and p2 > l // 2 - 1:
                answer = min(answer, p1 + 1 + (p2 - l // 2 + 1))
            elif p1 >= l // 2 - 1:
                if p2 == l - 1:
                    answer = min(answer, p1 + 1 - l // 2)
                else:
                    answer = min(answer, (p1 + 1 - l // 2) * 2 + (p2 - p1) + (l // 2))
            
            if p2 < l - 1:
                p2 += 1
                cur += sum_q[p2]
                continue
            
            break
            
        if cur < target and p2 < l - 1:
            p2 += 1
            cur += sum_q[p2]
            continue
        
        if cur > target and p1 < p2:
            p1 += 1
            cur -= sum_q[p1]
            continue
        
        break
        
    if answer == 1234567890:
        answer = -1
    
    return answer