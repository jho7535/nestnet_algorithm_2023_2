import heapq
import sys
input = sys.stdin.readline

INF = int(10e9)

def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    shortest[s] = 0
    while q:
        dist, now = heapq.heappop(q)
        
        if dist > shortest[now]:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < shortest[i[0]]:
                shortest[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

n, d = map(int, input().split())
graph = [[] for _ in range(d + 1)]
shortest = [INF] * (d + 1)

for i in range(d):
    graph[i].append((i+1, 1))
    
for _ in range(n):
    s, e, de = map(int, input().split())
    if e <= d:
        graph[s].append((e, de))

dijkstra(0)
print(shortest[d])

    
