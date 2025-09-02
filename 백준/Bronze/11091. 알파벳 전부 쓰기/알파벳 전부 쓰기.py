import sys
input = sys.stdin.readline

N = int(input())
for _ in range(N):
    cnt = 0
    s = str(input())
    l = [0] * 26
    for i in s:
        i = i.lower()
        i = ord(i) - 97
        if 0 <= i <= 25:
            l[i] = 1
    for i in l:
        if i > 0:
            cnt += 1
    if cnt == 26:
       print("pangram")
    else:
       print('missing ', end='')
       for i in range(26):
           if l[i] == 0:
               print(chr(i + 97), end='')
       print()