n = int(input())
complex_board = [list(map(int, input())) for _ in range(n)]
complex_cnt_list = []

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y):
    global apart_cnt
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if complex_board[nx][ny] == 1:
                complex_board[nx][ny] = -1
                dfs(nx, ny)
                apart_cnt += 1

for i in range(n):
    for j in range(n):
        if complex_board[i][j] == 1:
            apart_cnt = 1
            complex_board[i][j] = -1
            dfs(i, j)
            complex_cnt_list.append(apart_cnt)

print(len(complex_cnt_list))
complex_cnt_list.sort()
for complex_cnt in complex_cnt_list:
    print(complex_cnt)        