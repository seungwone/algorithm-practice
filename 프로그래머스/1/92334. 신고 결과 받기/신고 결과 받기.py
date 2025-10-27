from collections import defaultdict

def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_dict = defaultdict(set)
    cnt_dict = defaultdict(int)
    
    for r in report:
        a, b = r.split()
        report_dict[b].add(a)
    
    for val in report_dict.values():
        if len(val) >= k:
            for e in val:
                cnt_dict[e] += 1
                
    for i, u_id in enumerate(id_list):
        answer[i] = cnt_dict[u_id]
    
    return answer