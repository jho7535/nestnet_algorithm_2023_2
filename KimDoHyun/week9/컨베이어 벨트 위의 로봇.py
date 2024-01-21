from collections import deque

n,k=input().split()
n,k=int(n),int(k)

field=deque()
field.extend(list(map(int,input().split())))

step=0
robot=deque()
robot.extend([False for i in range(n)]) #로봇이 있다면 true 없다면 false

while True:
    step+=1

    #1  회전

    field.rotate(1)
    robot.rotate(1)
    robot[-1]=False  # 회전 후 로봇 내리기

    #2  로봇이 움직일 수 있다면 움직이기

    for i in range(n-2,-1,-1):    #내리는 위치에 가까운 로봇부터 움직이기
        if robot[i] and not robot[i+1] and field[i+1]>=1:
            robot[i+1]=robot[i]
            robot[i]=False
            field[i+1]-=1
    robot[-1]=False  # 로봇 이동 후 로봇 내리기

    #3 로봇 올리기

    if field[0]>=1 and not robot[0]:
        robot[0]=True        #첫번째 칸이 0이아니라면 로봇 올리기
        field[0]-=1          #로봇 올려서 내구도 감소

    #4 종료 조건
    if field.count(0)>=k:break

print(step)
