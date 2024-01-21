import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())
belt = deque(list(map(int, input().split())))
robots = deque([0] * n)
ans = 0

while belt.count(0) < k:
    # 1
    belt.rotate(1)
    robots.rotate(1)
    # 2
    robots[-1] = 0
    if sum(robots):
        for i in range(n - 2, -1, -1):
            if robots[i] == 1:
                if robots[i + 1] == 0 and belt[i + 1] >= 1:
                    robots[i], robots[i + 1] = 0, 1
                    belt[i + 1] -= 1
        robots[-1] = 0
    # 3
    if robots[0] == 0 and belt[0] > 0:
        robots[0] = 1
        belt[0] -= 1
    ans += 1

print(ans)