n=int(input())
arr=list(map(int,input().split()))
arr.sort()
count=0

for i in range(n):
    left,right=0,n-1        #기본 left, right설정
    #반례 처리 N은 자기자신을 제외한 다른 수 이기 때문에
    if i==0:left+=1
    if i==n-1:right-=1

    #투포인터 탐색
    while left<right:
        compare=arr[left]+arr[right]
        if compare>arr[i]:
            right-=1
            if right==i:right-=1    #반례 처리 N은 자기자신을 제외한 다른 수 이기 때문에
        elif compare<arr[i]:
            left+=1
            if left==i:left+=1      #반례 처리 N은 자기자신을 제외한 다른 수 이기 때문에
        # 같다면
        else:
            count+=1
            break
print(count)