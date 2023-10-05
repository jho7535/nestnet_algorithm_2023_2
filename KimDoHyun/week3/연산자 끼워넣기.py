n=int(input())
arr=list(map(int,input().split()))
plus,minus,mul,mod=map(int,input().split())
all_numbers=[]
all_operator=[]

def qqq(value,time,befor_actoer,plus_count,minus_count,mul_count,mod_count):
    if befor_actoer=="+":plus_count+=1
    elif befor_actoer=="-":minus_count+=1
    elif befor_actoer=="*":mul_count+=1
    elif befor_actoer=="//":mod_count+=1
    if time==0:
        all_numbers.append(value)
        all_operator.append([plus_count,minus_count,mul_count,mod_count])
        return
    qqq(value+arr[n-time],time-1,"+",plus_count,minus_count,mul_count,mod_count)
    qqq(value-arr[n-time],time-1,"-",plus_count,minus_count,mul_count,mod_count)
    qqq(value*arr[n-time],time-1,"*",plus_count,minus_count,mul_count,mod_count)
    if value<0:
        qqq((-value//arr[n-time])*-1,time-1,"//",plus_count,minus_count,mul_count,mod_count)
    else:
        qqq(value//arr[n-time],time-1,"//",plus_count,minus_count,mul_count,mod_count)

qqq(arr[0],plus+minus+mul+mod,"",0,0,0,0)



result=[]
for i in range(len(all_numbers)):
    if all_operator[i]==[plus,minus,mul,mod]:result.append(all_numbers[i])

#print(result)
print(max(result))
print(min(result))
