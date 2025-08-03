import sys
input = sys.stdin.readline

R = int(input())
a = input()
N = int(input())

arr = list()
ret = 0
maxV = 0
for _ in range(N):
    arr.append(input())

for i in range(R):
    now = a[i]
    cnt = [0, 0, 0]
    for j in range(N):
        if arr[j][i] == 'S':
            cnt[0] += 1
        elif arr[j][i] == 'P':
            cnt[1] += 1
        elif arr[j][i] == 'R':
            cnt[2] += 1
        if now == 'S':
            if arr[j][i] == 'S':
                ret += 1
            elif arr[j][i] == 'P':
                ret += 2
            elif arr[j][i] == 'R':
                ret += 0
        elif now == 'P':
            if arr[j][i] == 'S':
                ret += 0
            elif arr[j][i] == 'P':
                ret += 1
            elif arr[j][i] == 'R':
                ret += 2
        elif now == 'R':
            if arr[j][i] == 'S':
                ret += 2
            elif arr[j][i] == 'P':
                ret += 0
            elif arr[j][i] == 'R':
                ret += 1
    maxV += max(cnt[2] * 2 + cnt[1] * 1, cnt[1] * 2 + cnt[0] * 1, cnt[0] * 2 + cnt[2] * 1)
print(ret)
print(maxV)
