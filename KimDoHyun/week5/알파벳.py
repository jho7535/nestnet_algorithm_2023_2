import sys
input=sys.stdin.readline

# A~Z 는 아스키코드로 65부터 26개이다.

y_max,x_max=map(int,input().split())                
arr=[]
for _ in range(y_max):arr.append(list(map(ord,list(input()))))  # ord를 통해 아스키코드로 변환
visited=[False]*26      # 방문 여부 확인

result=0
# d[0]:우 d[1]:좌 d[2]:상 d[3]:하
dx=[1,-1,0,0]   
dy=[0,0,1,-1]

def dfs(level,y,x):                 # level = 깊이
    global result
    if level>result:result=level    # 최댓값 비교 
    for i in range(4):              # 상하좌우방향 모두 비교
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<x_max and 0<=ny<y_max:     # nx, ny 범위 비교
            tmp=arr[ny][nx]-65
            if not visited[tmp]:    
                visited[tmp]=True      # 방문 처리
                dfs(level+1,ny,nx)
                visited[tmp]=False  # 이미 탐색하고 다시 돌아온 경우 이기에 False처리를 반드시 해야한다.
visited[arr[0][0]-65]=True      # 초기값 방문 처리
dfs(1,0,0)
print(result)
