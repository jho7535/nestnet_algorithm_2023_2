import sys
sys.setrecursionlimit(10**6)        #재귀 깊이 설정 
n,m,k=input().split()
n,m,k=int(n),int(m),int(k)

field=[[0 for i in range(m)]for j in range(n)]


for i in range(k):
    a_x,a_y,b_x,b_y=input().split()
    a_x,a_y,b_x,b_y=int(a_x),int(a_y),int(b_x),int(b_y) #입력받기

    for x in range(a_x,b_x):
        for y in range(a_y,b_y):
            field[y][x]=1

dx=[0,0,1,-1]
dy=[1,-1,0,0]

area=0  #영역의 넓이 계산
def dfs(x,y):       #dfs함수
    global area
    area+=1             #방문할 때 마다 넓이 1추가
    field[y][x]=1       #방문 처리
    for i in range(4):      #4방면으로 갈 수 있는지 확인인
        nx,ny=x+dx[i],y+dy[i]
        if 0<=nx<m and 0<=ny<n:
            if not field[ny][nx]:   
                dfs(nx,ny)

result=[]
for i in range(n):      #모든 경우의 수 dfs검사
    for j in range(m):
        if not field[i][j]:
            area=0
            dfs(j,i)
            result.append(area)

result.sort()
print(len(result))
print(*result)




