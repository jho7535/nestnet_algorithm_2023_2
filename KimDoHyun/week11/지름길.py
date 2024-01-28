n,d=map(int,input().split())
shortcut=[]
for i in range(n):shortcut.append(list(map(int,input().split())))
shortcut.sort()
dp=[i for i in range(d+1)]     

k=0
for i in range(d+1):
    dp[i]=min(dp[i-1]+1,dp[i])
    while k<n:
        if i==shortcut[k][0]:
            if shortcut[k][1]<=d:
                dp[shortcut[k][1]]=min(dp[i]+shortcut[k][2],dp[shortcut[k][1]])
            k+=1
        else:break
    
print(dp[d])

