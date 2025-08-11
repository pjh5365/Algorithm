A = list(input().split())
B = input()

cnt = 0
for i in A:
    if B != i and i.startswith(B):
        cnt += 1
print(cnt)
