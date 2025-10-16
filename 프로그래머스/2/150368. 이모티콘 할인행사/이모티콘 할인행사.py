from itertools import product

def solution(users, emoticons):
    answer = [0, 0]
    n = len(users)
    m = len(emoticons)
    
    for prd in list(product([10, 20, 30, 40], repeat = m)):
        plus_cnt = 0
        sales = 0
        
        for base_rate, base_price in users:
            total = 0
            is_plus = False
            for i, price in enumerate(emoticons):
                if base_rate <= prd[i]:
                    total += (price * (100 - prd[i]) // 100)
                
                if total >= base_price:
                    is_plus = True
                    break
            
            if is_plus:
                plus_cnt += 1
            else:
                sales += total
                
        temp = [plus_cnt, sales]
        if answer < temp:
            answer = temp
    
    return answer