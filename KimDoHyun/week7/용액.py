n=int(input())
arr=list(map(int,input().split()))


def two_search(arr):
    left,right=0,len(arr)-1
    dis=2e10
    result=[0,0]
    while left<right:
        value=arr[left]+arr[right]
        if value>=0:
            if abs(value)<dis:
                dis=abs(value)
                result[0],result[1]=arr[left],arr[right]
            right-=1
        else:
            if abs(value)<dis:
                dis=abs(value)
                result[0],result[1]=arr[left],arr[right]
            left+=1
    return result

print(*two_search(arr))

