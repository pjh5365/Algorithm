import sys
input = sys.stdin.readline

s = ['0']
s += list(input())
cnt = 0
for i in range(len(s)):
    if s[i] == "Y":
        cnt += 1
        for j in range(i, len(s), i):
            if s[j] == "Y":
                s[j] = "N"
            elif s[j] == "N":
                s[j] = "Y"
print(cnt)
