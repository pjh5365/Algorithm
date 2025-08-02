import sys
input = sys.stdin.readline

n = int(input())

minV = 1e9
a = b = c = 0
ret = [0, 0, 0]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i * j > n:
            break

        for k in range(1, n + 1):
            if i * j * k > n:
                break
            if i * j * k == n:
                tmp = i * j + j * k + k * i

                if minV > tmp:
                    minV = tmp
                    ret[0] = i
                    ret[1] = j
                    ret[2] = k

print(ret[0], ret[1], ret[2])
