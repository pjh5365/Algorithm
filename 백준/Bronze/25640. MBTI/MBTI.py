import sys
input = sys.stdin.readline

jinho = input()
N = int(input())
ret = 0
while N:
    N -= 1
    tmp = input()
    if tmp == jinho:
        ret += 1
print(ret)
