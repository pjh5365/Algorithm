N, A, B, C = map(int, input().split())

def f(n):
    if n == 0:
        return 1
    else:
        return n * f(n-1)

print(f(N) // (f(A) * f(B) * f(C)))
