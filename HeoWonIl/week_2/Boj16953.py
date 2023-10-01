a, b = map(int, input().split())
small_num = str(b)
ans = 0

while True:
    if int(small_num) == a:
        ans += 1
        break
    if int(small_num) < a:
        ans = -1
        break
    rightest_num = small_num[-1]
    if int(rightest_num) != 1 and int(rightest_num) % 2 != 0:
        ans = -1
        break
    if int(rightest_num) == 1:            
        small_num = small_num[:-1]
    if int(rightest_num) % 2 == 0:
        small_num = str(int(small_num) // 2)
    ans += 1
        
print(ans)