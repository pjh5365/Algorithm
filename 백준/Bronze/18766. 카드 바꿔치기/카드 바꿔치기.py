import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    l1 = list(map(str, input().split()))
    l2 = list(map(str, input().split()))
    l1.sort()
    l2.sort()
    if l1 == l2:
        print("NOT CHEATER")
    else:
        print("CHEATER")
