from itertools import permutations 
from collections import deque

n = int(input())
operand_list = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

operator_list = []
operator_list.extend(['+'] * add)
operator_list.extend(['-'] * sub)
operator_list.extend(['*'] * mul)
operator_list.extend(['//'] * div)

operator_list = list(permutations(operator_list))
q = deque(operator_list)

max_res = -10e9
min_res = 10e9

while q:
    opers = q.popleft()
    res = operand_list[0]
    for i in range(1, len(operand_list)):
        if opers[i-1] == '+':
            res += operand_list[i]
        if opers[i-1] == '-':
            res -= operand_list[i]
        if opers[i-1] == '*':
            res *= operand_list[i]
        if opers[i-1] == '//':
            res = int(res / operand_list[i])
    max_res = max(max_res, res)
    min_res = min(min_res, res)

print(max_res)
print(min_res)



