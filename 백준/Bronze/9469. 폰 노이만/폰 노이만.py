import sys
input = sys.stdin.readline

P = int(input())
for i in range(P):
    N, D, A, B, F = map(float, input().split())
    T = D / (A + B) * F
    print("%d %.6f" % (N, T))
