import sys
input = sys.stdin.readline

n = int(input())
eggplant = list(input().split())
m, j = map(int, input().split())

flag = False

for i in range(m):
    plants = list(map(int, input().split()))
    isW = True
    for j in plants:
        if eggplant[j - 1] == 'P':
            isW = False
            break
    if isW:
        flag = True

if flag:
    print('W')
else:
    print('P')
