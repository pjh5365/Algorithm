N, K = map(int, input().split())
l = list(i for i in range(1, N + 1))
ret = "<" + str(K)
now = K - 1
del l[now]
while len(l) != 0:
    now += K - 1
    now %= len(l)
    ret = ret + ", " + str(l[now])
    del l[now]
ret += ">"
print(ret)