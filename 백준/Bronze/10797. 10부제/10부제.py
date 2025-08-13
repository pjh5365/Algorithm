import sys
input = sys.stdin.readline

n = int(input())
l = list(map(int, input().split()))

cnt = 0
for i in l:
    if i == n:
        cnt += 1
print(cnt)
