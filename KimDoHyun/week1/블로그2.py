n=int(input())
arr=list(input())


def check(): #전체 원소가 같은 색깔인지 점검하는 함수
    for i in range(1,len(arr)):
        if arr[i-1]!=arr[i]:
            return False
    return True

def paint_count():
    arr_B,arr_R,result=0,0,0
    if len(arr)==1 or check(): #예외처리 arr가 1개만 입력되거나 전체 원소가 같은 색깔일때
        return False

    for i in range(1,len(arr)):
        if arr[i-1]!=arr[i]:        #연속적으로 가다가 색깔이 달라지는지
            if arr[i-1]=="B":       #달라 지는 경우 달라지기 전 까지 연속된 색깔에 count++
                arr_B+=1
            else:arr_R+=1


    if arr[-1]=="B":arr_B+=1        #마지막 원소는 위의 for문에 포함이 안되기 떄문에 if문으로 한번더 처리
    else:arr_R+=1
    result=1+min(arr_B,arr_R)       #첫 원소를 칠할 때 1+ B로 칠할지 R로 칠할지 min값
    print(result)
    return True     #예외처리가 아닌경우 정상적 return


if not paint_count(): #예외처리로 위의 함수가 종료된 경우 1출력
    print(1)