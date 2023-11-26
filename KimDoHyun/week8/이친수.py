n=int(input())


dp_0=[0]*91
dp_1=[0]*91

dp_0[1],dp_1[1]=0,1
dp_0[2],dp_1[2]=1,0

for i in range(3,n+1):
    dp_0[i]=dp_0[i-1]+dp_1[i-1]
    dp_1[i]=dp_0[i-1]

if n<=2:print(1)
else:print(dp_0[i]+dp_1[i])