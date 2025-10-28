def solution(n, k):
    answer = 0
    temp = n
    li = []
    candidate = []
    
    while temp > 0:
        li.append(temp % k)
        temp //= k
        
    li.reverse()
    temp = ''
    for e in li:
        if e == 0:
            if temp != '':
                candidate.append(int(temp))
            temp = ''
            continue
        temp += str(e)
        
    if temp != '':
        candidate.append(int(temp))
    
    for e in candidate:
        if e == 1:
            continue
        
        answer += 1
        for i in range(2, int(e**0.5) + 1):
            if e % i == 0:
                answer -= 1
                break
    
    return answer