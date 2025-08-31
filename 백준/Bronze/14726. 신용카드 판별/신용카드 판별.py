T = int(input())

for _ in range(T):
    s = input()
    ret = 0
    for i in range(len(s)):
        if i % 2 == 0:
            tmp = int(s[i]) * 2
            if tmp >= 10:
                tmp = (tmp // 10) + (tmp % 10)
            ret += tmp
        else:
            ret += int(s[i])
    if ret % 10 == 0:
        print("T")
    else:
        print("F")
