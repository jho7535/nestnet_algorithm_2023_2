n = int(input())
dp = list(map(int, input().split()))
ans = -10e9

for i in range(1, n):
    if dp[i] + dp[i-1] > dp[i]:
        dp[i] = dp[i] + dp[i-1]
        
print(max(dp))