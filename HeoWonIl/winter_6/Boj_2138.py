n = int(input())
cur = list(map(int, input()))
target = list(map(int, input()))

def switch_from_to(a, b):
    a_copy = a[:]
    cnt = 0
    for i in range(1, n):
        if a_copy[i - 1] == b[i - 1]:
            continue
        cnt += 1
        for j in range(i - 1, i + 2):
            if j < n:
                a_copy[j] = 1 - a_copy[j]
    if a_copy == b:
        return cnt
    else:
        return 1e9

ans = switch_from_to(cur, target)
# 첫 번째 전구의 스위치를 켜는 경우
cur[0] = 1 - cur[0]
cur[1] = 1 - cur[1]

ans = min(ans, switch_from_to(cur, target) + 1)

if ans != 1e9:
    print(ans)
else:
    print(-1)