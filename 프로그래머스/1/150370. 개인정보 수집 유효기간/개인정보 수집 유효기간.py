def solution(today, terms, privacies):
    answer = []
    term_dict = dict()
    
    for t in terms:
        key, val = t.split()
        term_dict[key] = val
        
    for i, p in enumerate(privacies, 1):
        ymd, t = p.split()
        y, m, d = map(int, ymd.split('.'))
        exm = int(term_dict[t])
        exy = exm // 12
        exm %= 12
        y += exy
        m += exm
        d -= 1
        
        if d == 0:
            m -= 1
            d = 28
        if m > 12:
            m %= 12
            y += 1
            
        ty, tm, td = today.split('.')
        target = int(str(y) + (str(m) if m >= 10 else "0" + str(m)) + (str(d) if d >= 10 else "0" + str(d)))
        
        if target < int(ty + tm + td):
            answer.append(i)
    
    return answer