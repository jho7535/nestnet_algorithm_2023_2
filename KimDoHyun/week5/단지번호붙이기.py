from collections import deque
n=int(input())
arr=[]
result=[]                 # 각 단지의 집의 수
count=0                   # result에 입력하기 위한 count변수
for _ in range(n):arr.append(list(map(int,list(input()))))
visited=[[False for i in range(n)] for j in range(n)]       # 방문 여부 확인

def bfs(x,y):
    queue=deque([[x,y]])        # 초기값 선언
    visited[y][x]=True          # 초기값 방문 여부 true
    dx=[1,-1,0,0]               # 방향 선택
    dy=[0,0,1,-1]               
    tmp_count=0                 # return 을 위한 임시 tmp_count변수

    while queue:                # 큐가 비어 있을 때 까지 진행
        v=queue.popleft()       
        tmp_count+=1            # 한 개의 queue값이 출력될 때 마다 +1
        x,y=v[0],v[1]           # popleft된 v값은 [before_x,before_y]이다.
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]   # i값 변화에 대해 x, y값 상하좌우 변동
            if 0<=nx<n and 0<=ny<n:     # nx, ny 범위 체크
                if not visited[ny][nx] and arr[ny][nx]==1: # 방문을 안하고 arr값이 1이라면 queue에 추가
                    queue.append([nx,ny])
                    visited[ny][nx]=True
    return tmp_count

for i in range(n):          # 모든 칸 검사
    for j in range(n):
        if not visited[i][j]:       # 방문을 안 했다면 bfs실행
            if arr[i][j]==1:
                count = bfs(j,i)      # count = 한 단지의 집의 개수 
                if count:             
                    result.append(count)    # 비어있지 않다면 result에 추가 
                count=0

result.sort()       
print(len(result))              # 출력
for res in result:print(res)
    


            

