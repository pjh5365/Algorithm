N, K = map(int, input().split())
l = [i for i in range(1, N + 1)]
ret = []
now = 0
while len(l) != 0:
    now += K - 1
    now %= len(l)
    ret.append(str(l.pop(now)))
print("<", ", ".join(ret)[:], ">", sep='')
