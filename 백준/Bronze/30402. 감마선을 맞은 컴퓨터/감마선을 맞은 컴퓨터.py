import sys
input = sys.stdin.readline


def find():
    for i in range(15):
        l = list(input().split())
        for j in l:
            if j == 'w':
                print("chunbae")
                return
            elif j == 'b':
                print("nabi")
                return
            elif j == 'g':
                print("yeongcheol")
                return

find()
