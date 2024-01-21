arr=input()
result=[]
size=arr.count('a')     #윈도우 크기

for i in range(len(arr)):
    b_count=0
    for j in range(size):
        index=i+j
        if index>len(arr)-1:index-=len(arr)     #index가 리스트를 넘어간다면 -=리스트크기 해주기-> 원형 유지
        if arr[index]=="b":b_count+=1
    result.append(b_count)

print(min(result))