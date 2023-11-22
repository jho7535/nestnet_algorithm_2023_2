n, c = map(int, input().split())
homes = []
for _ in range(n):
    home = int(input())
    homes.append(home)
homes.sort()

start = 1
end = homes[-1] - homes[0]
ans = 0    

while start <= end:
    mid = (start + end) // 2
    cur = homes[0]
    cnt = 1

    for i in range(1, len(homes)):
        if homes[i] >= cur + mid:
            cnt += 1
            cur = homes[i]

    if cnt >= c:
        start = mid + 1
        ans = mid
    else:
        end = mid - 1

print(ans)