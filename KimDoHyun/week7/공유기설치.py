import sys
input=sys.stdin.readline

house_count,wifi_count=input().split()
house_count,wifi_count=int(house_count),int(wifi_count)
arr=[]
for _ in range(house_count):arr.append(int(input()))
arr.sort()

def binary_search(arr,wifi_count):
    result=0
    left,right=0,arr[-1]
    while left<=right:
        distanse=(left+right)//2   

        start_house=arr[0]
        tmp_count=1
        for i in range(1,house_count):
            if arr[i]-start_house>=distanse:
                tmp_count+=1
                start_house=arr[i]
        if tmp_count>=wifi_count:
            result=distanse
            left=distanse+1
        else:
            right=distanse-1
    return result
    

print(binary_search(arr,wifi_count))






