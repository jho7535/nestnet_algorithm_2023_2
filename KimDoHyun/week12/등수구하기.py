n,new,p=map(int,input().split())
if n==0:print(1)
else:
    grade=list(map(int,input().split()))
    for i in range(len(grade),p):grade.append(-1)
    p_in=False
    rank=[1]
    for i in range(1,p):
        if grade[i]==grade[i-1]:rank.append(rank[i-1])
        else:rank.append(i+1)

    if grade[0]<new:
        result=1
        p_in=True
    else:
        for i in range(1,p):
            if grade[i]<new:
                if i<p:p_in=True
                if grade[i-1]==new: 
                    result=rank[i-1]
                else: result=rank[i]
                break

    if p_in:print(result)
    else:print("-1")