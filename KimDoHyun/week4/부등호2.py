k=int(input())
inequality=list(input().split())
number=[i for i in range(10)]       #부등호 정리를 위한 숫자리스트
visited=[False for _ in range(10)]  #방문처리 리스트
result=[]
tmp=[]


def dfs(level,index):           #level은 깊이 , index는 방문 인덱스
    global tmp
    global result
    tmp.append(index)       #방문했으니 숫자 저장
    visited[index]=True     #숫자 방문 처리

    if level==k:                                #dfs 종료조건 숫자방문이 끝나면 결과에 저장              
        result.append(int("".join(map(str,tmp))))
        tmp=[]      #임시배열 초기화
        return
    tmptmp=tmp[:]               #tmp배열을 한번더 tmptmp에 입력
    if inequality[level]=="<":      #연산자가 "<" 인 경우 더 큰 숫자로 dfs진행
        for i in range(index,10):
            if not visited[i]:
                dfs(level+1,i)
                visited[i]=False
                tmp=tmptmp[:]

    else:                           #연산자가 ">"인 경우 더 작은 숫자로 dfs진행
        for i in range(index,-1,-1):
            if not visited[i]:
                dfs(level+1,i)
                visited[i]=False
                tmp=tmptmp[:]

for i in range(9,-1,-1):    #시작 지점 다르게 dfs를 시작하기 위한 for문
    tmp=[]                  #임시 리스트 초기화
    visited=[False for _ in range(10)]      #방문 리스트 초기화
    if result:break
    dfs(0,i)                    

numberMax=str(max(result))                          #3줄동안 최솟값이 0으로 시작하는 경우 예외처리
if len(numberMax)!=k+1:numberMax="0"+numberMax
print(numberMax)

result=[]           # 지속적으로 사용한는 리스트 초기화
tmp=[]

#최댓값 구하기  로직은 최소와 동일
#아래의 for문의 방향이 다름 / 최소:9->0 최대:0->10
for i in range(10):                     #시작위치가 다르게 하기 위한 for문
    tmp=[]
    visited=[False for _ in range(10)]
    if result:break
    dfs(0,i)

numberMin=str(min(result))                 #맨 앞 숫자가 0인경우 예외처리
if len(numberMin)!=k+1:numberMin="0"+numberMin
print(numberMin)
