from collections import deque


def solution(maps):
    # BFS를 위한 deque
    dq = deque()
    dq.append((1, 0, 0))

    # BFS
    while dq:
        # c: 현재까지 이동한 칸 수
        # x, y: 현재 위치
        c, x, y = dq.popleft()
        # 이미 방문한 칸이라면 패스
        if not maps[x][y]:
            continue
        # 방문한 칸은 0으로 표시
        maps[x][y] = 0

        # 도착지에 도달했다면 현재까지 이동한 칸 수 반환
        if x == len(maps) - 1 and y == len(maps[0]) - 1:
            return c

        # 상하좌우로 이동
        if len(maps[0]) > y + 1 and maps[x][y + 1]:
            dq.append((c + 1, x, y + 1))

        if y - 1 >= 0 and maps[x][y - 1]:
            dq.append((c + 1, x, y - 1))

        if len(maps) > x + 1 and maps[x + 1][y]:
            dq.append((c + 1, x + 1, y))

        if x - 1 >= 0 and maps[x - 1][y]:
            dq.append((c + 1, x - 1, y))

    return -1