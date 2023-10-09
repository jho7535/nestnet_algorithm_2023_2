n = int(input())
seq = input()
ans = -10e9

def calc_two_operand(num1, oper, num2):
    if oper == '+':
        return num1 + num2
    if oper == '-':
        return num1 - num2
    if oper == '*':
        return num1 * num2

def dfs(i, value):
    global ans
    if i == n - 1:
        ans = max(ans, value)
        return
    if i + 2 < n:
        dfs(i + 2, calc_two_operand(value, seq[i + 1], int(seq[i + 2])))
    if i + 4 < n:
        dfs(i + 4, calc_two_operand(value, seq[i + 1], calc_two_operand(int(seq[i + 2]), seq[i + 3], int(seq[i + 4]))))

dfs(0, int(seq[0]))
print(ans)