n = int(input())
solutions = list(map(int, input().split()))
result_a, result_b = 0, 0
prev_mix_amount = 10e9
start = 0
end = len(solutions) - 1

while start < end:
    solution_a, solution_b = solutions[start], solutions[end]
    mix_amount = solution_a + solution_b
    if mix_amount == 0:
        result_a, result_b = solution_a, solution_b
        break
    elif mix_amount < 0:
        start += 1
    else:
        end -= 1
    if abs(prev_mix_amount) > abs(mix_amount):
        result_a, result_b = solution_a, solution_b
        prev_mix_amount = mix_amount

print(result_a, result_b)
