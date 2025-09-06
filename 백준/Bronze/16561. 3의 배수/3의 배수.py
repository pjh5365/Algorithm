import sys
input = sys.stdin.readline

n = int(input())

ret = 0
for i in range(3, n - 6 + 1, 3):
    for j in range(3, n - i - 3 + 1, 3):
        ret += 1
print(ret)
