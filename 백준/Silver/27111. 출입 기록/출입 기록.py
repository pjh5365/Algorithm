import sys
input = sys.stdin.readline

N = int(input())
l = set()
ret = 0
while N:
    N -= 1
    a, b = map(int, input().split())
    if b == 1:
        if a in l:
            ret += 1
        else:
            l.add(a)
    if b == 0:
        if a not in l:
            ret += 1
        else:
            l.remove(a)
ret += len(l)
print(ret)
