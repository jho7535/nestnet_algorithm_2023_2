
n=int(input())
count=0

while n>=0:
    if n%5==0:                  #5로 나눠진다면 전부 다 나누기
        print(n//5+count)
        break
    n-=2                        #-2반복
    count+=1                    #2원을 거슬러 준 횟수를 count에 저장

if n<0:                         #n을 2를 빼고 5를 나누었을 때 떨어지지않는 경우 -1을 출력
    print(-1)
