from itertools import combinations, product
from bisect import bisect_left

def solution(dice):
    answer = []
    max_win = 0
    
    n = len(dice)
    arr = [i for i in range(n)]
    r = n // 2
    p = list(product(range(6), repeat = r))
    comb = combinations(arr, r)
    
    for a in comb:
        b = [i for i in arr if i not in a]
        
        win_cnt = 0
        a_arr = []
        b_arr = []
        
        for p_arr in p:
            sum_a = 0
            sum_b = 0
            for i, j in enumerate(p_arr):
                sum_a += dice[a[i]][j]
                sum_b += dice[b[i]][j]
            a_arr.append(sum_a)
            b_arr.append(sum_b)
        
        b_arr.sort()
        for n in a_arr:
            win_cnt += bisect_left(b_arr, n)
            
        if win_cnt > max_win:
            max_win = win_cnt
            answer = list(map(lambda x: x + 1, a))
    
    return answer