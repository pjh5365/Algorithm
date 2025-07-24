N, L = input().split()
N = int(N)
ret = 0
cnt = 0
while cnt != N:
    ret += 1
    if L in str(ret):
        continue
    cnt += 1
print(int(ret))
