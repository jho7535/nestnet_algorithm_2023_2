import sys
input = sys.stdin.readline

n, m = map(int, input().split())
titles = []
powers = []

for _ in range(n):
    title_name, power = input().split()
    titles.append(title_name)
    powers.append(int(power))

def binary_search(t, data):
    s, e = 0, len(data) - 1
    while s <= e:
        m = (s + e) // 2
        if t > data[m]:
            s = m + 1
        else:
            e = m - 1
    
    return e + 1

for _ in range(m):
    print(titles[binary_search( int(input()), powers)])