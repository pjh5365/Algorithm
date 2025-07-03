M = int(input())
ret = 0
if M <= 30:
    ret = M / 2
else:
    ret = (M - 30) * 3 / 2 + 15
print(ret)
