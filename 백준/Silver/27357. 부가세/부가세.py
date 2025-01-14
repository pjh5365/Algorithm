import sys, math

input = sys.stdin.readline


def surtax(X, P_sum):
    minF, maxF = None, None
    for F in range(10001):
        tax = P_sum * F / 100
        lower_tax = math.floor(tax * 100) / 100  # 버림
        upper_tax = math.ceil(tax * 100) / 100  # 올림

        lower_X = P_sum + lower_tax
        upper_X = P_sum + upper_tax

        if math.floor(lower_X) == X or math.floor(upper_X) == X:
            if minF is None:  # None 일 경우, 제일 처음 가능한 F를 minF로 설정
                minF = F

            maxF = F

    return minF, maxF


T = int(input())
for _ in range(T):
    N, X = map(int, input().split())
    P = [float(input()) for _ in range(N)]

    P_sum = sum(P)
    minF, maxF = surtax(X, P_sum)
    print(minF, maxF)