ans = 10e9

str = input()
a_cnt = str.count('a')
str += str[0:a_cnt - 1]
for start in range(len(str) - (a_cnt - 1)):
    ans = min(ans, str[start: start + a_cnt].count('b'))

print(ans)