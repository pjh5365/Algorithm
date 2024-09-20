str1 = input()
bomb = input()
s1 = []
s2 = []

for i in str1:
	s1.append(i)
	if (s1[-1] == bomb[-1]):
		isRemoved = True;
		for j in range(len(bomb) - 1, -1, -1):
			if len(s1) > 0 and s1[-1] == bomb[j]:
				s2.append(s1.pop())
			else:
				isRemoved = False
				break
		if isRemoved:
			s2.clear()
		else:
			while len(s2) > 0:
					s1.append(s2.pop())

if len(s1) > 0:
	for i in s1:
		print(i, end='')
else:
	print("FRULA")
