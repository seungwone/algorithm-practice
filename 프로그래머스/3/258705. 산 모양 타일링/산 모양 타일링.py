def solution(n, tops):
    answer = 0
    dp = [[0, 0] for _ in range(2 * n)]
    dp[0][0] = 1
    dp[0][1] = 1
    
    if tops[0] == 0:
        dp[1][0] = 2
        dp[1][1] = 1
        dp[2][0] = 3
        dp[2][1] = 2
    else:
        dp[1][0] = 2
        dp[1][1] = 2
        dp[2][0] = 4
        dp[2][1] = 3
        
    for i in range(3, 2 * n):
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 10007
        
        if i % 2 == 1 and tops[i // 2] == 1:
            dp[i][1] = (dp[i - 1][0] * 2) % 10007
        elif i % 2 == 0 and tops[(i - 1) // 2] == 1:
            dp[i][1] = (dp[i - 1][0] + dp[i - 2][0]) % 10007
        else:
            dp[i][1] = dp[i - 1][0]
    
    answer = (dp[-1][0] + dp[-1][1]) % 10007
    
    return answer