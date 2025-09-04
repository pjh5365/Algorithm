import sys
input = sys.stdin.readline

A, B, C, D, N = map(int, input().split())
s = A + B + C + D
N *= 4
if s < N:
    print(N - s)
else:
    print("0")
