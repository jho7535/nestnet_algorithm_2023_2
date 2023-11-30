string_A=list(input())
string_B=list(input())
len_A,len_B=len(string_A),len(string_B)

i,j=0,0
LCS=[[0 for i in range(len_B+1)] for j in range(len_A+1)]

for i in range(len_A+1):
    for j in range(len_B+1):
        if i == 0 or j == 0:  LCS[i][j] = 0
        elif string_A[i-1] == string_B[j-1]:LCS[i][j] = LCS[i - 1][j - 1] + 1
        else:LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])

result=[]
while True:
    if i==0 or j==0:break
    if LCS[i][j]==LCS[i-1][j] :i=i-1  
    elif LCS[i][j]==LCS[i][j-1] :j=j-1    
    else:
        result.append(string_A[i-1])
        i,j=i-1,j-1
    
print(len(result))
for i in range(len(result)-1,-1,-1):print(result[i],end="")

