a,b=map(int,input().split())

count=0
while b!=a:                 #B와 A가 같아 지는 경우 종료
    if b%2==0:                  #b를 나눌 수 있는 경우 우선적으로 나누기
        b=b//2
        count+=1
    else:                       #맨 뒤에 숫자가 1이 있는 경우 짝수 일 수가 없으므로 else문으로 진행
        b=list(str(b))              #b를 문자열로 변환 시키고 리스트에 한 숫자씩 집어넣음
        if b[-1]=='1' and len(b)>1:             #맨 끝 문자열 ==1 and 숫자가 2자리 수 이상
            del b[-1]
            b=int(''.join(b))
            count+=1
        else:               #짝수가 아닌데 맨뒤에 숫자가 1이 아닌 경우는 불가하기 때문에 break
            count=-2
            break

print(count+1)
