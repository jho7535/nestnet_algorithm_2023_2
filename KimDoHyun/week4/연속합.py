n=int(input())
arr=list(map(int,input().split()))

dp=[0]*n                #dp배열 초기화
dp[0]=arr[0]            #dp배열 초깃값 설정

if n==1:print(arr[0])     #1일때 예외처리
else:
    for i in range(1,n):
        if arr[i]>=0:                       #현재 숫자 값이 양수인지
            if dp[i-1]>0:dp[i]=dp[i-1]+arr[i]   #num>0 dp[i-1]>0
            else:dp[i]=arr[i]                   #num>0 dp[i-1]<0
        else:                               #현재 숫자 값이 음수인지
            if dp[i-1]<arr[i]:dp[i]=arr[i]      #num<0 dp[i-1]<num
            else:dp[i]=dp[i-1]+arr[i]           #num<0  dp[i-1]>num
    print(max(dp))