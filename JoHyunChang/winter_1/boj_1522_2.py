import copy
import sys
from collections import deque

string = sys.stdin.readline().rstrip()

count = string.count("a")

cmp_target = deque('a' * count + 'b' * (len(string) - count))
origin_cmp_target = copy.deepcopy(cmp_target)
min_cnt = 2000
while True:
    cnt = 0
    for i in range(len(cmp_target)):
        if cmp_target[i] == 'b' and string[i] == 'a':
            cnt += 1
    min_cnt = min(min_cnt, cnt)
    cmp_target.appendleft(cmp_target.pop())
    if cmp_target == origin_cmp_target:
        break
print(min_cnt)