import sys
input = sys.stdin.readline
import heapq
INF = int(1e9)

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
dis = [INF] * (n + 1)

for _ in range(m):
    s, e, c = map(int, input().split())
    graph[s].append((e, c))
    graph[e].append((s, c))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dis[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if dis[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < dis[i[0]]:
                dis[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(1)
print(dis[n])