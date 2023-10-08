def combination(arr,n):
    tmp_arr=[]
    if n==1:
        tmp_arr=[[i] for i in arr]
        return tmp_arr
    else:
        for i in range(len(arr)):
            select = arr[i]
            excluded = combination(arr[i+1:], n-1)
            for elect in excluded:
                tmp_arr.append([select]+elect)
        return tmp_arr

N,S=map(int,input().split())
arr=list(map(int,input().split()))
count=0

for i in range(1,N+1):#원소개수
    for element in combination(arr,i):
        if S==sum(element):count+=1

print(count)