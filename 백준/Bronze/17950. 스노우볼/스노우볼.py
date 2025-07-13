import sys
input = sys.stdin.readline

H, x = map(int, input().split())
ret = 0
tmp = 1
r = 1000000007
for _ in range(H):
    i = int(input())
    tmp *= x
    tmp %= r
    ret += i * tmp
    ret %= r
print(ret)
