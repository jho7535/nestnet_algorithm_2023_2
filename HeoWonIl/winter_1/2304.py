n = int(input())
pillars = [0] * 1001
first_idx = 0
last_idx = 0
max_h = 0
max_h_idx = 0
area_sum = 0

for _ in range(n):
    l, h = map(int, input().split())
    first_idx = min(first_idx, l)
    last_idx = max(last_idx, l)
    if max_h < h:
        max_h_idx = l
    max_h = max(max_h, h)
    pillars[l] = h
    
area_stack = []
for i in range(first_idx, max_h_idx + 1):
    if not area_stack:
        area_stack.append(pillars[i])
    else:
        if area_stack[-1] < pillars[i]:
            area_stack.pop()
            area_stack.append(pillars[i])
    area_sum += area_stack[-1]

area_stack = []
for j in range(last_idx, max_h_idx, -1):
    if not area_stack:
        area_stack.append(pillars[j])
    else:
        if area_stack[-1] < pillars[j]:
            area_stack.pop()
            area_stack.append(pillars[j])
    area_sum += area_stack[-1]

print(area_sum)