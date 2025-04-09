# 보드 90도 회전 함수
def turn(game_board):
    temp = [[0] * len(game_board) for _ in range(len(game_board))]
    for i, row in enumerate(game_board):
        for j, e in enumerate(row[::-1]):
            temp[j][i] = e
    return temp


# DFS로 공백 또는 퍼즐을 찾는 함수
# 리턴값 : [boolean : 퍼즐 조립 여부, tuple : 시작 위치, tuple... : 상대적인 위치]
def search(game_board, is_puzzle):
    board_len = len(game_board)
    temp = []
    is_visited = set()

    for i in range(board_len):
        for j in range(board_len):
            if game_board[i][j] == is_puzzle and (i, j) not in is_visited:
                is_visited.add((i, j))
                temp.append(
                    dfs(
                        game_board,
                        (i, j),
                        i,
                        j,
                        # (0, 0)을 기준으로 상대적인 위치를 저장
                        # 첫번째 원소는 퍼즐 조립 여부, 두번째 원소는 시작 위치, 세번째 원소부터 상대적인 위치
                        [False, (i, j), (0, 0)],
                        is_visited,
                        is_puzzle,
                    )
                )

    return temp


# DFS로 공백 또는 퍼즐의 상대적인 위치를 찾는 함수
def dfs(board, origin, x, y, path, is_visited, is_puzzle):
    x_shift = [1, -1, 0, 0]
    y_shift = [0, 0, -1, 1]

    for i in range(4):
        next_x = x + x_shift[i]
        next_y = y + y_shift[i]

        if (
            next_x >= 0
            and next_y >= 0
            and next_x < len(board)
            and next_y < len(board)
            and board[next_x][next_y] == is_puzzle
        ):
            if (next_x, next_y) in is_visited:
                continue
            is_visited.add((next_x, next_y))
            path.append((next_x - origin[0], next_y - origin[1]))
            dfs(board, origin, next_x, next_y, path, is_visited, is_puzzle)

    return path


# DFS로 공백을 채우는 함수
# 즉, 퍼즐을 조립하는 함수
def fill_blank(board, x, y):
    board[x][y] = 1

    x_shift = [1, -1, 0, 0]
    y_shift = [0, 0, -1, 1]

    for i in range(4):
        next_x = x + x_shift[i]
        next_y = y + y_shift[i]

        if (
            next_x >= 0
            and next_y >= 0
            and next_x < len(board)
            and next_y < len(board)
            and board[next_x][next_y] == 0
        ):
            fill_blank(board, next_x, next_y)


def solution(game_board, table):
    answer = 0
    # 퍼즐 조각들을 찾음
    puzzle_list = search(table, 1)

    # 게임 보드를 90도씩 회전하면서 퍼즐을 끼워 맞춤
    for i in range(4):
        # 공백을 찾음
        blank_list = search(game_board, 0)

        # 퍼즐과 공백을 비교하여 퍼즐을 조립
        for p in puzzle_list:
            if p[0]:
                continue
            for b in blank_list:
                if b[0]:
                    continue
                # 퍼즐과 공백이 일치한다면 퍼즐을 조립
                if p[2:] == b[2:]:
                    p[0] = True
                    b[0] = True
                    x, y = b[1]
                    # 공백을 채움
                    fill_blank(game_board, x, y)
                    # 퍼즐의 크기를 더함
                    answer += len(b) - 2
                    # 퍼즐을 조립했으므로 다음 퍼즐로 넘어감
                    break

        # 총 3번만 회전
        if i == 3:
            break
        # 게임 보드를 90도 회전
        game_board = turn(game_board)

    return answer
