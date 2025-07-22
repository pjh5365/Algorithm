n = int(input())
while n:
    n -= 1
    s = input()
    s = s.lower()
    idx = 0
    flag = True
    while idx < len(s) // 2 + 1:
        if s[idx] != s[len(s) - 1 - idx]:
            flag = False
            break
        idx += 1
    if flag:
        print("Yes")
    else:
        print("No")
