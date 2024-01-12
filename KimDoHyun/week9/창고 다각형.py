n=int(input())
arr=[]
stack=[]
for i in range(n):                  #입력받기
    l,h=input().split()
    arr.append([int(l),int(h)])

arr.sort()                 #정렬
arr_max,arr_max_index=0,0

for i in range(n):                          #최댓값 찾기
    if arr_max<arr[i][1]:
        arr_max=arr[i][1]           #최댓값 저장
        arr_max_index=i             #최댓값 인덱스 저장

high_x,high_y=arr[0][0],arr[0][1]           #초기화
result=0

for i in range(1,arr_max_index+1):  #최댓값과 최댓값 전까지
    if high_y<arr[i][1]:
        result+=(arr[i][0]-high_x)*high_y
        high_x,high_y=arr[i][0],arr[i][1]


result+=arr[arr_max_index][1] #최댓값 추가
high_x,high_y=arr[n-1][0],arr[n-1][1]
for i in range(n-1,arr_max_index-1,-1):
    if high_y<=arr[i][1]:
        result+=(high_x-arr[i][0])*high_y
        high_x,high_y=arr[i][0],arr[i][1]

print(result)



