N, L = map(int, input().split())
line = 0
cnt = 0
while N > 0:
    N -= 1
    tmp = input()
    tmp += "0"
    nowLine = 0
    for i in range(len(tmp)):
        if tmp[i] == "1" and tmp[i + 1] == "0":
            nowLine += 1
    if line < nowLine:
        line = nowLine
        cnt = 1
    elif line == nowLine:
        cnt += 1
print(line, cnt)
