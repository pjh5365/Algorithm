import sys
input = sys.stdin.readline

N = int(input())
l = list()
dic = dict()
countryCnt = [0] * N
for i in range(N):
    a, b, c = map(int, input().split())
    l.append(c)
    dic[c] = [a, b]

l.sort(reverse=True)
cnt = 0
for i in l:
    country = dic[i][0]
    player = dic[i][1]
    if countryCnt[country] < 2:
        print(country, player)
        cnt += 1
    if cnt == 3:
        break
    countryCnt[country] += 1
