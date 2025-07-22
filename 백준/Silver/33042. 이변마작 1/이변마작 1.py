N = int(input())
cnt = 0
card = input().split()
d = {}
flag = False
for i, t in enumerate(card, start=1):
    d[t] = d.get(t, 0) + 1
    if d[t] == 5:
        print(i)
        flag = True
        break
if not flag:
    print(0)
