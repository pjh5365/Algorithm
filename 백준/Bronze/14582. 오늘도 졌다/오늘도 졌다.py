import sys
input = sys.stdin.readline

a = list(map(int, input().split()))
b = list(map(int, input().split()))

A = 0
B = 0
flag = False
for i in range(9):
    A += a[i]
    if A > B:
        flag = True
    B += b[i]
if flag:
    print("Yes")
else:
    print("No")
