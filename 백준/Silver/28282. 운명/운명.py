import sys
input = sys.stdin.readline

X, K = map(int, input().split())
A = list(map(int, input().split()))
left = [0] * (K + 1)
right = [0] * (K + 1)
for i in range(X):
    left[A[i]] += 1
for i in range(X, 2 * X):
    right[A[i]] += 1

ret = 0
for i in range(K + 1):
    ret += left[i] * (X - right[i])
print(ret)
