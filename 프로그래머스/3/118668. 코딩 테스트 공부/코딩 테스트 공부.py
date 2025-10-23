def solution(alp, cop, problems):
    answer = 0
    max_alp = 0
    max_cop = 0
    
    for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
        max_alp = max(max_alp, alp_req)
        max_cop = max(max_cop, cop_req)
        
    alp = min(max_alp, alp)
    cop = min(max_cop, cop)
    
    dp = [[1234567890] * (max_cop + 1) for _ in range(max_alp + 1)]
    dp[alp][cop] = 0
    
    for i in range(alp, max_alp + 1):
        for j in range(cop, max_cop + 1):
            cur = dp[i][j]
            
            next_i = min(max_alp, i + 1)
            next_j = j
            dp[next_i][next_j] = min(dp[next_i][next_j], cur + 1)
            
            next_i = i
            next_j = min(max_cop, j + 1)
            dp[next_i][next_j] = min(dp[next_i][next_j], cur + 1)
            
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i < alp_req or j < cop_req:
                    continue
                
                next_i = min(max_alp, i + alp_rwd)
                next_j = min(max_cop, j + cop_rwd)
                dp[next_i][next_j] = min(dp[next_i][next_j], cur + cost)
    
    answer = dp[-1][-1]
    
    return answer