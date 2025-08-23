import sys
input = sys.stdin.readline

N = int(input())
cow = [-1] * 11
ret = 0
for _ in range(N):
    a, b = map(int, input().split())
    if cow[a] == -1:
        cow[a] = b
    else:
        if cow[a] != b:
            cow[a] = b
            ret += 1
print(ret)
