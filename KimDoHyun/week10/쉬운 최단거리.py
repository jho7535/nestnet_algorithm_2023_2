from collections import deque
n,m=map(int,input().split())
field=[]
visited=[[False for j in range(m)]for i in range(n)]
arr=[[-1 for j in range(m)]for i in range(n)]
for i in range(n):
    tmp=list(map(int,input().split()))
    field.append(tmp)
    if 2 in tmp:
        start_point_x=tmp.index(2)
        start_point_y=i

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(start_point_x,start_point_y):
    queue=deque()
    queue.append([start_point_x,start_point_y,1])
    visited[start_point_y][start_point_x]=True
    arr[start_point_y][start_point_x]=0

    while queue:

        v=queue.popleft()
        distance=v[2]
        for i in range(4):
            nx,ny=v[0]+dx[i],v[1]+dy[i]
            if -1<nx<m and -1<ny<n and visited[ny][nx]==False:
                if field[ny][nx]!=0:
                    visited[ny][nx]=True
                    arr[ny][nx]=distance
                    queue.append([nx,ny,distance+1])

bfs(start_point_x,start_point_y)

for i in range(n):
    for j in range(m):
        if not field[i][j]:arr[i][j]=0
        print(arr[i][j],end=" ")
    print()