n = int(input())
arr = []
dp = [1] * n

for _ in range(n):
    arr.append(int(input()))

for i in range(1, n):
    for j in range(0, i):
        if arr[j] < arr[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))