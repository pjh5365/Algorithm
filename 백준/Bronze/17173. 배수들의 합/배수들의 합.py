import sys
input = sys.stdin.readline

N, M = map(int, input().split())
K = list(map(int, input().split()))
sum = 0
s = set()
for i in range(1, N + 1):
    for j in K:
        if i % j == 0:
            s.add(i)
for i in s:
    sum += i
print(sum)
