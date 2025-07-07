N, M = map(int, input().split())
l = list(map(int, input().split()))
total = 0
ret = 0
for i in l:
    total += i
    if total < 0:
        total = 0
    if total >= M:
        ret += 1
print(ret)