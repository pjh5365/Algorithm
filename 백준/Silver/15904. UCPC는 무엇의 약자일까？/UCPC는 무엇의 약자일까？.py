import sys
input = sys.stdin.readline

s = input()

flag = [False] *  4

for i in s:
    if i == "U":
        flag[0] = True
    elif flag[0] == True and flag[1] == False and i == "C":
        flag[1] = True
    elif flag[0] == True and flag[1] == True and i == "P":
        flag[2] = True
    elif flag[0] == True and flag[1] == True and flag[2] == True and i == "C":
        flag[3] = True

if flag[0] == flag[1] == flag[2] == flag[3] == True:
    print("I love UCPC")
else:
    print("I hate UCPC")
