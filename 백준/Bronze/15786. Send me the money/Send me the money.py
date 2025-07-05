N, M = map(int, input().split())
l = input()
while M > 0:
    M -= 1;
    tmp = input()
    idx = 0
    for i in range(len(tmp)):
        if tmp[i] == l[idx]:
            idx += 1
        if idx == N:
            break
    if idx == N:
        print("true")
    else:
        print("false")
