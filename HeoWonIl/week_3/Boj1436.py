seriesNum = input()
seriesCnt = 0
ans = 666

while True:
    for i in range(len(str(ans)) - 2):
        if str(ans)[i: i+3] == '666':
            seriesCnt += 1
            break
    if seriesCnt == int(seriesNum):
        break
    else:
        ans += 1

print(ans)