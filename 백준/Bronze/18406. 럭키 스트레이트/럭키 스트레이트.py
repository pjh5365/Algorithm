N = input()
n = list(N)
a = list(map(int, (N[0: len(N) // 2])))
b = list(map(int, (N[len(N) // 2:])))

A = sum(a)
B = sum(b)

if A == B:
    print("LUCKY")
else:
    print("READY")
