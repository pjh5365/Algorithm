N = int(input())
s = input()
idx = 0
sCnt = 0
bCnt = 0
while idx < len(s):
    if s[idx] == 's':
        sCnt += 1
        idx += 8
    else:
        bCnt += 1
        idx += 7
if sCnt < bCnt:
    print("bigdata?")
elif sCnt > bCnt:
    print("security!")
else:
    print("bigdata? security!")