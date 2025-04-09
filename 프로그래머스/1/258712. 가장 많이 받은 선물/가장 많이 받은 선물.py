def solution(friends, gifts):
    answer = 0
    li = [[0] * len(friends) for _ in range(len(friends))]
    state = [0] * len(friends)
    fdict = dict()
    cnt = 0
    for f in friends:
        fdict[f] = cnt
        cnt += 1
    
    for g in gifts:
        a, b = g.split()
        a = fdict[a]
        b = fdict[b]
        li[a][b] += 1
        state[a] += 1
        state[b] -= 1
    
    for i in range(len(friends)):
        temp = 0
        for j in range(len(friends)):
            if i == j:
                continue
            if li[i][j] > li[j][i]:
                temp += 1
            elif li[i][j] == li[j][i]:
                if state[i] > state[j]:
                    temp += 1
        answer = max(answer, temp)
    
    return answer