from collections import deque
MAX_DIS = 100001

n, k = map(int, input().split())
q = deque()
q.append(n)
visited = [-1] * (MAX_DIS + 1)
visited[n] = 0

while q:
    cur_n = q.popleft()
    if cur_n == k:
        print(visited[cur_n])
        break
    if 0 < cur_n * 2 < MAX_DIS and visited[cur_n * 2] == -1:
        visited[cur_n * 2] = visited[cur_n]
        q.appendleft(cur_n * 2)
    if 0 <= cur_n - 1 < MAX_DIS and visited[cur_n - 1] == -1:
        visited[cur_n - 1] = visited[cur_n] + 1
        q.append(cur_n - 1)
    if 0 <= cur_n + 1 < MAX_DIS and visited[cur_n + 1] == -1:
        visited[cur_n + 1] = visited[cur_n] + 1
        q.append(cur_n + 1)