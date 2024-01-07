# 양쪽에서 투포인터 방식으로 a의 시작과 끝을 탐지한다
# ex) abbbaa 일 경우 start = 1 end = 3
# 이후 부터 b와 가장 먼 a를 서로 바꾼다.
# abbababa 일경우 로직은 다음과 같다.
# start = 1 end = 6 cnt = 0
#
# while end > start :
#  while s[end--] != 'b':
#   pass
#  while s[start++] != 'a':
#   pass
#  if (start <= end) cnt++
# print(cnt)
import sys

string = sys.stdin.readline().rstrip()
s = 0
e = len(string) - 1
cnt = 0
while s < e and string[s] == 'a':
    s += 1
while s < e and string[e] == 'a':
    e -= 1
while s < e:
    while s < e and string[e] == 'a':
        e -= 1
    while s < e and string[s] == 'b':
        s += 1
    if s < e:
        cnt += 1
        s += 1
        e -= 1
print(cnt)