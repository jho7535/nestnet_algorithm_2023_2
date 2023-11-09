import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
n = int(input())
color_board = [list(input().rstrip()) for _ in range(n)]
check = [[0] * n for _ in range(n)]
check_RG_blindness = [[0] * n for _ in range(n)]
area_cnt = 0
area_cnt_RG_blindness = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, prev_color, RG_BLINDNESS):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if RG_BLINDNESS:
                if (check_RG_blindness[nx][ny] == 0) and (color_board[nx][ny] == prev_color or (color_board[nx][ny] == 'R' and prev_color == 'G') or (color_board[nx][ny] == 'G' and prev_color == 'R')):
                    check_RG_blindness[nx][ny] = 1
                    dfs(nx, ny, color_board[nx][ny], True)
            else:
                if check[nx][ny] == 0 and color_board[nx][ny] == prev_color:
                    check[nx][ny] = 1
                    dfs(nx, ny, color_board[nx][ny], False)

for i in range(n):                    
    for j in range(n):  
        if check[i][j] == 0:
            area_cnt += 1
            check[i][j] = 1
            dfs(i, j, color_board[i][j], False)
        if check_RG_blindness[i][j] == 0:
            area_cnt_RG_blindness += 1
            check_RG_blindness[i][j] = 1
            dfs(i, j, color_board[i][j], True)

print(area_cnt, area_cnt_RG_blindness)
            
    