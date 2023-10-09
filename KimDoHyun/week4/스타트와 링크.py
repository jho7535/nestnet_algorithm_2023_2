
def combination(arr,n):         #조합 함수
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

import sys
input=sys.stdin.readline
n=int(input())
arr=[]
for i in range(n):arr.append(list(map(int,input().split())))    #기본 배열 리스트입력
index=[i for i in range(n)]
result=9999999999           #최솟값이 큰 양수 일 수 있으므로
total_team = set(range(0,n))



for start_case in combination(index,n//2):

    link_case=list(total_team-set(start_case))      #파이썬 문법상 리스트보다 집합을 활용하는것이 간단하다.
    start_team=0
    link_team=0

    for j in range(n//2-1):         #모든 경우의 수 검사
        for k in range(j+1,n//2):
            start_team+=arr[start_case[j]][start_case[k]]+arr[start_case[k]][start_case[j]]
            link_team+=arr[link_case[j]][link_case[k]]+arr[link_case[k]][link_case[j]]
            
    
    if result>abs(start_team-link_team):result=abs(start_team-link_team)


print(result)
    

