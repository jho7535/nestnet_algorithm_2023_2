def combination(arr,n):     #조합함수
    tmp_arr=[]
    if n==1:
        tmp_arr=[[i] for i in arr]
        return tmp_arr
    else:
        for i in range(len(arr)):
            select = arr[i]
            excluded = combination(arr[i+1:], n-1)
            for elect in excluded:
                tmp_arr.append([select]+elect)
        return tmp_arr
    

def if_sequence(tmp):           #연산자 연속 조합선택을 예외 처리하기 위한 함수 ex) 1,2 ->true / 1,3 ->false
    for i in range(len(tmp)-1):
        if tmp[i]+1==tmp[i+1]: return True
    return False



n=int(input())
equation=list(input())
arr_number=[]   #숫자 저장
arr_operator=[] #연산자 저장

for i in range(n):             #숫자와 연산자 분리
    if i%2==0:arr_number.append(int(equation[i]))
    else:arr_operator.append(equation[i])

tmp=[i for i in range(len(arr_operator))]      #조합을 뽑기위한 임시 리스트
result = -999999999999999               #값이 양수만 나오는게 아니기 때문에 최솟값을 매우낮은값으로 설정
if len(arr_number)==1:result=arr_number[0]      #n이 1일 때 예외처리
if len(arr_number)==2:                          #n이 3일 떄 예외처리
    if arr_operator[0]=="+":
        result=arr_number[0]+arr_number[1]
    elif arr_operator[0]=="-":
        result=arr_number[0]-arr_number[1]
    elif arr_operator[0]=="*":
        result=arr_number[0]*arr_number[1]


for i in range(len(arr_operator)):      #연산자 괄호의 개수에 대해 for문          
    for j in combination(tmp,i):        
        if if_sequence(j):continue      #괄호는 연속으로 존재하는 연산자에 불가능 하기 떄문에 예외처리
        tmp_operator=arr_operator[:]       #얕은 복사를 피하기위한 문자열슬라이싱 복사
        tmp_number=arr_number[:]            #얕은 복사를 피하기위한 문자열슬라이싱 복사

        for k in range(len(j)):             #괄호 우선 계산
            if tmp_operator[j[k]]=="+":
                tmp_number[j[k]]=tmp_number[j[k]]+tmp_number[j[k]+1]
            elif tmp_operator[j[k]]=="-":
                tmp_number[j[k]]=tmp_number[j[k]]-tmp_number[j[k]+1]
            elif tmp_operator[j[k]]=="*":
                tmp_number[j[k]]=tmp_number[j[k]]*tmp_number[j[k]+1]
        sum=tmp_number[0]       

        for k in range(len(j)-1,-1,-1):     #괄호 계산 제거
            del tmp_number[j[k]+1]
            del tmp_operator[j[k]]

        for k in range(len(tmp_operator)):  #나머지 연산 계산
            if tmp_operator[k]=="+":
                sum+=tmp_number[k+1]
            elif tmp_operator[k]=="-":
                sum-=tmp_number[k+1]
            elif tmp_operator[k]=="*":
                sum*=tmp_number[k+1]

        if result<sum:result=sum            #result를 통해 최댓값 비교

print(result)
