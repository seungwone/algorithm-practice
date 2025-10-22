from collections import defaultdict

def solution(survey, choices):
    answer = ''
    li = [('R', 'T'), ('C', 'F'), ('J', 'M'), ('A', 'N')]
    score_dict = defaultdict(int)
    
    for s, c in zip(survey, choices):
        t1 = s[0]
        t2 = s[-1]
        c -= 4
        
        if c < 0:
            score_dict[t1] += abs(c)
        else:
            score_dict[t2] += c
            
    for t1, t2 in li:
        if score_dict[t1] >= score_dict[t2]:
            answer += t1
        else:
            answer += t2
    
    return answer