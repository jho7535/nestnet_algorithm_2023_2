n, k = map(int, input().split())
ph = list(input())
ans = 0

for i in range(len(ph)):
    if ph[i] == 'P':
        for j in range(i - k, i + k + 1):
            if 0 <= j < len(ph) and ph[j] == 'H':
                ph[j] = '0'
                ans += 1
                break
print(ans)