N, M = map(int, input().split())
l = list()
for _ in range(N):
    l.append(input())

for i in range(N - 1):
    s1 = str(l[i])
    s2 = str(l[i + 1])
    flag = False

    for j in range(1, M + 1):
        if s1[M - j:] == s2[:j]:
            flag = True
            break
        if s1[:j] == s2[M - j:]:
            flag = True
            break

    if not flag:
        print("0")
        exit(0)

print("1")
