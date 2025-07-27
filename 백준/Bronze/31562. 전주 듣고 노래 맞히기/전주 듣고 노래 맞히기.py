import sys
input = sys.stdin.readline

N, M = map(int, input().split())
song = {}
while N:
    N -= 1
    T, S, a1, a2, a3, a4, a5, a6, a7 = input().split()
    song[S] = a1 + a2 + a3
while M:
    M -= 1
    cnt = 0
    name = ""
    b1, b2, b3 = input().split()
    b = b1 + b2 + b3
    for s in song:
        if song[s] == b:
            cnt += 1
            name = s
    if cnt == 1:
        print(name)
    elif cnt == 0:
        print("!")
    elif cnt > 1:
        print("?")
