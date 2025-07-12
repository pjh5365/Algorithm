N, M = map(int, input().split())
ret = 1
while N:
    N -= 1
    i = int(input())
    if i > 0:
        ret *= i
        ret %= M
ret %= M
print(ret)
