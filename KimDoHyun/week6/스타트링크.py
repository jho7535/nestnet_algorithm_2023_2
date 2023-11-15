from collections import deque

f,s,g,u,d=input().split()
f,s,g,u,d=int(f),int(s),int(g),int(u),int(d)

visited=[False]*(f+1)

def bfs(root,target):
    global f,u,d
    count=0
    queue=deque([[root,count]])
    visited[root]=True
    
    while queue:
        floor,count=queue.popleft()
        if floor==target:return count
        tmp=[floor+u,floor-d]
        for i in tmp:
            if 0<i<=f:
                if not visited[i]:
                    queue.append([i,count+1])
                    visited[i]=True
    return None

result=bfs(s,g)

if result or s==g:print(result)
else:print("use the stairs")