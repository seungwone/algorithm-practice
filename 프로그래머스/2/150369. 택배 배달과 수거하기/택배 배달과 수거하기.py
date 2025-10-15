def solution(cap, n, deliveries, pickups):
    answer = 0
    d_idx = n - 1
    p_idx = n - 1
    
    while d_idx >= 0 or p_idx >= 0:
        while d_idx >= 0 and deliveries[d_idx] == 0:
            d_idx -= 1
        while p_idx >= 0 and pickups[p_idx] == 0:
            p_idx -= 1
        
        max_idx = max(d_idx, p_idx)
        go_li = []
        back_li = []
        
        temp_cnt = cap
        temp_idx = d_idx
        while temp_idx >= 0:
            if 0 < deliveries[temp_idx] <= temp_cnt:
                go_li.append((temp_idx, deliveries[temp_idx]))
                temp_cnt -= deliveries[temp_idx]
            elif deliveries[temp_idx] > 0 and temp_cnt > 0:
                go_li.append((temp_idx, temp_cnt))
                temp_cnt = 0
                
            if temp_cnt == 0:
                break
            temp_idx -= 1
            
        temp_cnt = cap
        temp_idx = p_idx
        while temp_idx >= 0:
            if 0 < pickups[temp_idx] <= temp_cnt:
                back_li.append((temp_idx, pickups[temp_idx]))
                temp_cnt -= pickups[temp_idx]
            elif pickups[temp_idx] > 0 and temp_cnt > 0:
                back_li.append((temp_idx, temp_cnt))
                temp_cnt = 0
                
            if temp_cnt == 0:
                break
            temp_idx -= 1
        
        cur = -1
        for ele in go_li[::-1]:
            idx = ele[0]
            cnt = ele[1]
            
            deliveries[idx] -= cnt
            
            answer += abs(idx - cur)
            cur = idx
            
        for ele in back_li:
            idx = ele[0]
            cnt = ele[1]
            
            pickups[idx] -= cnt
            
            answer += abs(idx - cur)
            cur = idx
        
        answer += abs(-1 - cur)
    
    return answer