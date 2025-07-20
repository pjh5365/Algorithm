T = int(input())
while T:
    T -= 1
    K, num = input().split()
    o = int(num, 8) if max(list(num)) < '8' else 0
    print(int(K), o, int(num), int(num, 16))
