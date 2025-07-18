s = input()

K = ['K', 'O', 'R', 'E', 'A']
Y = ['Y', 'O', 'N', 'S', 'E', 'I']
for i in s:
    if i == K[0] :
        K.remove(i)
        if len(K) == 0:
            print("KOREA")
            break
    if i == Y[0]:
        Y.remove(i)
        if len(Y) == 0:
            print("YONSEI")
            break
