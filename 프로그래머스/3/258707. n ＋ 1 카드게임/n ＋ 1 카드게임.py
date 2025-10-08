def solution(coin, cards):
    answer = 0
    
    n = len(cards)
    target = n + 1
    cost0 = 0
    cost1 = 0
    cost2 = 0
    init = set()
    candidate = set()
    
    for c in cards[:n // 3]:
        if (target - c) in init:
            cost0 += 1
        else:
            init.add(c)
    
    for i, c in enumerate(cards[n // 3:], n // 3):
        pair = target - c
        
        if pair in init:
            cost1 += 1
        elif pair in candidate:
            cost2 += 1
        else:
            candidate.add(c)
        
        if i % 2 == 1:
            if cost0 > 0:
                cost0 -= 1
            elif cost1 > 0 and coin >= 1:
                coin -= 1
                cost1 -= 1
            elif cost2 > 0 and coin >= 2:
                coin -= 2
                cost2 -= 1
            else:
                answer = (i - n // 3) // 2 + 1
                break
    else:
        answer = (n - n // 3) // 2 + 1        
    
    return answer