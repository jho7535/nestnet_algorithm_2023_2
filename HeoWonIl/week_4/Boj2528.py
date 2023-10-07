from itertools import permutations

n = int(input())
inequal_seq = list(input().split())
avail_ans = []
        
for permutation in permutations(list(range(10)), n+1):
    for i in range(1, len(permutation)):
        if inequal_seq[i-1] == '<':
            if permutation[i-1] > permutation[i]:
                break
        else:
            if permutation[i-1] < permutation[i]:
                break
    else:
        avail_ans.append(permutation)
        min_ans = ''.join(map(str, permutation))
        
print(''.join(map(str, avail_ans[-1])))    
print(''.join(map(str, avail_ans[0])))    

