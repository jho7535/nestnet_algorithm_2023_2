n = int(input())
colors = input()
simple_colors = colors[0]

for i in range(1, len(colors)):
    if colors[i] == colors[i-1]:
        continue
    else:
        simple_colors = simple_colors + colors[i]
    
B_cnt = simple_colors.count('B')
R_cnt = simple_colors.count('R')
min_cnt = min(B_cnt, R_cnt)
print(min_cnt + 1)