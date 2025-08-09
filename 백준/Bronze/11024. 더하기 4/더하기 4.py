import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    l = list(map(int, input().split()))
    print(sum(l))
