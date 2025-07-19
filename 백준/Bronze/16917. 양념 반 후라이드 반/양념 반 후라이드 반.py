A, B, C, X, Y = map(int, input().split())
ret = 0
if C * 2 < A + B:
    while X > 0 and Y > 0:
        ret += C * 2
        X -= 1
        Y -= 1
if C * 2 < A:
    while X > 0:
        ret += C * 2
        X -= 1
if C * 2 < B:
    while Y > 0:
        ret += C * 2
        Y -= 1
ret += X * A
ret += Y * B
print(ret)
