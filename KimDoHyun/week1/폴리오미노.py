arr=list(input())

def poli():
    count=0
    for i in range(len(arr)):           #x의 개수가 4개 연속으로 있다면 A로 대체하기 위한 for문
        if arr[i]=="X": count+=1
        else:   count=0

        if count==4:
            for j in range(4):
                arr[i-j]="A"
            count=0

    count=0

    for i in range(len(arr)):       #x의 개수가 3개가 남아있는 case가 있다면 false리턴을 위한 for문
        if arr[i]=="X": count+=1
        else:   count=0
        if count==3:    return False



    for i in range(len(arr)-1):         #x의 개수가 2개 연속 xx가 있는경우 BB로 대체 하기 위한 for문
        if arr[i]=="X" and arr[i+1]=="X":
            arr[i],arr[i+1]="B","B"


    if "X" in arr:                  #모든 경우의 수를 전부 지웠음에도 X가 남아있다면, false리턴
        return False
    return True

if poli():          #poli함수가 정상적으로 종료된 경우
    print(*arr,sep="")
else:               #만들 수 없는 경우 poli함수가 false를 리턴하여 -1출력을 하기 위함
    print(-1)