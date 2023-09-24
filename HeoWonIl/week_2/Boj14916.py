n = int(input())

def solution(n):
    ans = 0
    k = n // 5
    m = n % 5
    if m % 2 == 0:
         ans = k + (m // 2)
    else:
        if n < 5:
            return -1
        ans = (k - 1) + ((m + 5) // 2)
    return ans
        
print(solution(n))