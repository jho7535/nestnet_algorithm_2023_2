import sys
input = sys.stdin.readline

n = int(input())
chemi_board = [list(map(int, input().split())) for _ in range(n)]
check = [0] * n
INF = 10e9
ans = INF


def dfs(mem_cnt, idx):
    global ans
    if mem_cnt == n // 2:
        start_chemi_sum = 0
        link_chemi_sum = 0
        for i in range(n):
            for j in range(n):
                if check[i] and check[j]:
                    start_chemi_sum += chemi_board[i][j]
                elif not check[i] and not check[j]:
                    link_chemi_sum += chemi_board[i][j]
        ans = min(ans, abs(start_chemi_sum - link_chemi_sum))
        return
    else:
        for i in range(idx, n):
            if not check[i]:
                check[i] = 1
                dfs(mem_cnt + 1, i + 1)
                check[i] = 0


dfs(0, 0)
print(ans)