def fibonacci(n):
    dp = [0] * (10001)
    dp[1] = dp[2] = 1

    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n]

n = int(input())
print(fibonacci(n))
