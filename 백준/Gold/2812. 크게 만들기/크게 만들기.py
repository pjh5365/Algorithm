N, K = map(int, input().split())
num = input()
s = []
for i in num:
	while (len(s) != 0 and K > 0):
		if (s[-1] < i):
			s.pop()
			K -= 1
		else:
			break;
	s.append(i)

while K > 0:
	s.pop()
	K -= 1
for i in s:
	print(i, end='')
