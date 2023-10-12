import sys
sys.setrecursionlimit(10 ** 6)          # 메모리 초과 방지 


n=int(input())
arr=[]
count=0
blindness_count=0
for _ in range(n):arr.append(list(input())) 

visited=[[False for i in range(n)] for j in range(n)]       # 방문 여부 체크 리스트


def dfs(color,y,x,mode):    # 전 탐색위치의 색깔과 같으면 진행 아닌 경우 종료 
    global count
    if mode=="normal":              # 적록색약이 아닌경우 + 전 dfs에서 입력받은 color와 다른 경우
        if color!=arr[y][x]:return
    else:                            # 적록색약이면서 + 전 dfs에서 입력받은 color와 다른 경우
        if arr[y][x]=="R" or arr[y][x]=="G":   
            if color=="B":return
        else:
            if color!="B":return
            

    visited[y][x]=True  # 방문 처리

    dx=[-1,1,0,0]   # dx,dy활용으로 상하좌우탐색
    dy=[0,0,1,-1]
    


    
    for i in range(4):          
        nx,ny=x+dx[i],y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<n:   #범위 확인
            if not visited[ny][nx]:
                dfs(color,ny,nx,mode)


for i in range(n):                  
    for j in range(n):
        if not visited[i][j]:   # 방문하지 않은 좌표를 기준으로 모든 좌표 탐색
            dfs(arr[i][j],i,j,"normal")     #적록색약이 아닌 경우
            count+=1


visited=[[False for i in range(n)] for j in range(n)]   # 방문 여부 초기화



for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(arr[i][j],i,j,"blind")  # 적록색약인 경우 
            blindness_count+=1
        


print(count,blindness_count)

