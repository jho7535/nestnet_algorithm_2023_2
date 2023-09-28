import sys
input=sys.stdin.readline        #시간 단축을 위한 sys모듈 활용


n=int(input())
arr=[]
for i in range(n):
    a,b=map(int,input().split())     #각 강의 시간 입력 받기
    arr.append([a,b])
arr.sort()                          #강의 시간 정렬


lecture_room=[arr[0][1]]            #강의실리스트 초기값 설정


def binary_search(target,change_value):         #이분탐색 활용
    global lecture_room                         #전역변수 활용
    start,end=0,len(lecture_room)-1             #이분탐색 left,right값 설정
    while start<end:
        mid=(start+end)//2                      #mid값 설정
        if target==lecture_room[mid]:           #수업 시작시간이 강의실리스트에 있다면 바로 이어붙이기 위해 수업 끝나는 시간으로 값 변경
            lecture_room[mid]=change_value
            return
        elif target<lecture_room[mid]:          #작다면 end값 축소
            end=mid-1
        else:start=mid+1                        #크다면 start값 증가
    #while문이 끝나고 함수를 return으로 빠져나가지 않았다면, 찾는 값이 없다는 뜻
    #이때 end값은 start값보다 작아진 상태 여야만 종료가 된다.
    # while문이 끝난 후 end값은 내가 찾는 값 보다 바로 작은값이다.
    # ex) arr=[4, 6, 8] 일 때 5를 target으로 이분탐색을 진행하면, while문 진행시 첫 mid값은 6 그 이후 end값은 4로 while문이 종료된다.

    if target<min(lecture_room):    lecture_room.append(change_value)
    #lecture_room값의 최소값 보다 target값이 작다면 이어서 강의를 할 수 없으므로 강의실을 추가한다.
    else:   lecture_room[end]=change_value
    # end값은 우리가 찾는 최소값이므로 while문이 끝난 후 end값은 내가 찾는 target값보다 작은 수 중 가장 큰 수이게 된다.

    return


for i in range(1,n):    #모든 시간에 대해 검토하기 위해
    binary_search(arr[i][0],arr[i][1])



print(len(lecture_room))