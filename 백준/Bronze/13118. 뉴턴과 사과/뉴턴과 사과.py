import sys
input = sys.stdin.readline

p = list(map(int, input().split()))
x, y, r = map(int, input().split())
ret = 0

cnt = 1
for i in p:
    if x == i:
        ret = cnt
    cnt += 1
print(ret)
