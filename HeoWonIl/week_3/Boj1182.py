from itertools import combinations

n, s = map(int, input().split())
num_seq = list(map(int, input().split()))
ans = 0

for r in range(1, n+1):
    tmp_list = list(combinations(num_seq, r))
    for combi in tmp_list:
        if sum(combi) == s:
            ans += 1

print(ans)



