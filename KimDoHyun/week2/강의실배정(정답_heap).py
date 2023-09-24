import sys
import heapq
input=sys.stdin.readline #시간 단축을 위한 sys모듈 활용


n=int(input())
arr=[]

for i in range(n):
    a,b=map(int,input().split())        #각 강의 시간 입력 받기
    arr.append([a,b])

arr.sort()                              #강의 시간 정렬
lecture_room=[]

heapq.heappush(lecture_room,arr[0][1])     #힙의 초기 값 설정 #강의실리스트 초기값 설정

#강의실 리스트 힙에는 강의가 끝나는 시간이 기록되어 있음

for i in range(1,len(arr)):
    if lecture_room[0]>arr[i][0]:heapq.heappush(lecture_room,arr[i][1])
    #강의가 끝나는 시간 중 가장 작은 시간보다 더 일찍 시작하는 강의가 있다면 lecture_room최소힙 구조에 강의가 끝나는 시간 push
    else:heapq.heapreplace(lecture_room,arr[i][1])
    #아닌 경우는 기존 강의실의 끝나는 시간을 변경하는 것 인데, 이때 가장 강의가 늦지 않게 끝나는 강의의 시간을 바꿔주면 된다.


print(len(lecture_room))