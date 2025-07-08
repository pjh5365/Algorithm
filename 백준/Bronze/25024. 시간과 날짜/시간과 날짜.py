T = int(input())
while T:
    T -= 1;
    x, y = map(int, input().split())
    a = b = "No"
    if 0 <= x <= 23 and 0 <= y <= 59:
        a = "Yes"
    if 1 <= x <= 12:
        if (x == 1 or x == 3 or x == 5 or x == 7 or x == 8 or x == 10 or x == 12) and 1 <= y <= 31:
            b = "Yes"
        elif (x == 4 or x == 6 or x == 9 or x == 11) and 1 <= y <= 30:
            b = "Yes"
        elif x == 2 and 1 <= y <= 29:
            b = "Yes"
    print(a, b)
