#많은 양을 남기고 적은양을 /2값하여 많은 에너지 드링크에 합치면 되는 문제

n=int(input())
arr=list(map(int,input().split()))


max_drink=max(arr)
arr.remove(max_drink)   #제일 큰 값 제외 전부 /2하여 큰값에 더하면 되기 때문에 

for ele in arr:         #for문을 통해 제일 큰 값에 계속 더해주기
    max_drink+=ele/2

print(max_drink)
