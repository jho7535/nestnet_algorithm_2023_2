# set 풀이
import sys
input = sys.stdin.readline

R, C = map(int, input().split())
alph_board = [list(input().rstrip()) for _ in range(R)]
check = set(alph_board[0][0])
ans = 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, cnt):
    global ans
    ans = max(ans, cnt)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < R and 0 <= ny < C:
            if alph_board[nx][ny] not in check:
                check.add(alph_board[nx][ny])
                dfs(nx, ny, cnt + 1)
                check.remove(alph_board[nx][ny])

dfs(0, 0, ans)
print(ans)

# ascill 코드 풀이
R, C = map(int, input().split())
alph_board = [list(input()) for _ in range(R)]
check = [0] * 26
ans = 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, cnt):
    global ans
    ans = max(ans, cnt)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < R and 0 <= ny < C:
            index = ord(alph_board[nx][ny]) - 65
            if check[index] == 0:
                check[index] = 1
                dfs(nx, ny, cnt + 1)
                check[index] = 0

check[ord(alph_board[0][0]) - 65] = 1
dfs(0, 0, ans)
print(ans)