from collections import deque

n = int(input())
drinks = list(map(int, input().split()))
drinks.sort()
q = deque(drinks)
answer = q[-1]

while True:
    if len(q) == 1:
        answer = q.pop()
        break
    min_drink = q.popleft()
    max_drink = q.pop()
    new_drink = max_drink + (min_drink / 2)
    q.append(new_drink)
    
print(answer)