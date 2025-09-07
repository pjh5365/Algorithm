import sys
input = sys.stdin.readline

N = int(input())
tmp = 10
while N > tmp:
    if N % tmp >= tmp // 2:
        N += tmp
    N -= (N % tmp)
    tmp *= 10
print(N)
