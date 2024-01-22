from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(a, b):
    q = deque()
    q.append((a, b))
    cost[a][b] = graph[a][b]
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if cost[nx][ny] > cost[x][y] + graph[nx][ny]:
                 cost[nx][ny] = cost[x][y] + graph[nx][ny]
                 q.append((nx, ny))
    
    return cost[n - 1][n - 1]
    
cnt = 1
while True:
    n = int(input())
    if n == 0:
        break
        
    graph = []
    cost = [[10e9] * n for _ in range(n)]
    for _ in range(n):
        graph.append(list(map(int, input().split())))
    ans = bfs(0, 0)
    print(f'Problem {cnt}: {ans}')
    cnt += 1