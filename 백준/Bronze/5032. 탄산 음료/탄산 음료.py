e, f, c = map(int, input().split())
ret = 0
e += f
while e >= c:
    a, b = e // c, e % c
    e = a + b
    ret += a
print(ret)
