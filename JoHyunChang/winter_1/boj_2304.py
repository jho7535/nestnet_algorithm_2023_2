# 1000짜리 배열을 초기화 한다.
# 입력을 받고 해당 배열에 해당 인덱스에 넣는다
# 가장 큰 mid 값을 구하고
# 투포인터로 양끝에서부터 면적을 구한다.

import sys
store = [0 for i in range(1001)]
n = int(sys.stdin.readline().rstrip())
mid_value = 0
mid_index = -1
for _ in range(n):
    index, value = map(int, sys.stdin.readline().split())
    store[index] = value
    if mid_value < value:
        mid_value = value
        mid_index = index
s = 0
s_max = store[s]
left_capacity = 0
while s < mid_index:
    if s_max < store[s]:
        s_max = store[s]
    left_capacity += s_max
    s += 1
e = 1000
e_max = store[e]
right_capacity = 0
while e > mid_index:
    if e_max < store[e]:
        e_max = store[e]
    right_capacity += e_max
    e -= 1
print(left_capacity+right_capacity+mid_value)