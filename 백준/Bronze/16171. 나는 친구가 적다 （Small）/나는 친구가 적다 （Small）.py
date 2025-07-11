S = input()
K = input()
idx = 0
tmp = ""
for i in S:
    if '0'<= i <= '9':
        continue
    tmp += i
if K in tmp:
    print(1)
else:
    print(0)
