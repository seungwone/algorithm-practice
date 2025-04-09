from collections import deque


def solution(n, results):
    answer = 0
    # 인접 리스트
    adj_li = [[] for _ in range(n + 1)]
    # 해당 노드가 이긴 노드들
    win_set_li = [set() for _ in range(n + 1)]
    # 해당 노드를 이긴 노드들
    lose_set_li = [set() for _ in range(n + 1)]
    # 진입 차수
    in_degree = [0] * (n + 1)
    q = deque()

    # 인접 리스트 생성
    # 진입 차수 생성
    # 이긴 노드 세트, 패배한 노드 세트 생성
    for a, b in results:
        adj_li[a].append(b)
        in_degree[b] += 1
        win_set_li[a].add(b)
        lose_set_li[b].add(a)

    # 진입 차수가 0인 노드를 큐에 삽입
    for i, e in enumerate(in_degree[1:], 1):
        if e == 0:
            q.append(i)

    # 위상 정렬
    while q:
        idx = q.pop()

        for next_node in adj_li[idx]:
            in_degree[next_node] -= 1
            # 이긴 노드 세트, 패배한 노드 세트 갱신
            # A가 B를 이겼을때, B의 lose_set에 A의 lose_set을 추가. 즉, A가 이기지 못한 노드들은 B도 이길 수 없다
            lose_set_li[next_node].update(lose_set_li[idx])
            if in_degree[next_node] == 0:
                q.append(next_node)
                # 특정 노드 x의 패배리스트에 있는 노드들의 승리리스트에 x를 추가
                # ex) x가 1,2,3,4,5에게 패배했을 때, 1,2,3,4,5의 승리리스트에 x를 추가
                for j in lose_set_li[next_node]:
                    win_set_li[j].add(next_node)

    # 승리리스트와 패배리스트의 합이 n-1이면 정확한 순위를 알 수 있다
    for i in range(1, n + 1):
        if len(win_set_li[i]) + len(lose_set_li[i]) == n - 1:
            answer += 1

    return answer
