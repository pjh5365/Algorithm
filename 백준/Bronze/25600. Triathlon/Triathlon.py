N = int(input())
ret = 0
while N:
    N -= 1
    a, d, g = map(int, input().split())
    tmp = a * (d + g)
    if a == d + g:
        tmp *= 2
    ret = max(ret, tmp)
print(ret)
