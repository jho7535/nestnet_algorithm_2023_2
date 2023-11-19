n=int(input())      #사람 수
visited=[False]*(n+1)   #방문 체크 함수
target_a,target_b=input().split()
target_a,target_b=int(target_a),int(target_b)
m=int(input())      #부모자식간 관계 수
graph=[]
for i in range(m):graph.append(list(map(int,input().split())))  #입력 받기

result=0
def dfs(value,level,target):            #dfs함수 
    global result
    if value==target:result=level       #종료 조건

    for i in range(len(graph)):
        if value in graph[i]:   #그래프 안에 해당값이 있다면 해당 값 말고 다른 값 선택
            if value==graph[i][0]:diretion=graph[i][1]
            else: diretion=graph[i][0]
            if not visited[diretion]:   #값 선택후 방문하지 않았으면 방문
                visited[diretion]=True
                dfs(diretion,level+1,target)
                visited[diretion]=False
dfs(target_a,0,target_b)
if result:print(result)
else:print(-1)