from collections import deque

n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = 0
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == -1:
                if data[nx][ny] == 0:
                    visited[nx][ny] = 0
                    continue
                if data[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))
                    
for i in range(n):
    for j in range(m):
        if data[i][j] == 2 and visited[i][j] == -1:
            bfs(i, j)
            
for i in range(n):
    for j in range(m):
        if data[i][j] == 0:
            print(0, end=' ')
        else:
            print(visited[i][j], end=' ')
    print()
        