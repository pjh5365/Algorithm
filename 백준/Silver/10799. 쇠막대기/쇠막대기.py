line = input()
s = []
ret = 0
for i in range(len(line)):
	if (line[i] == '('):
		s.append('(')
	else:
		s.pop()
		if (line[i - 1] == '('):
			ret += len(s)
		else: 
			ret += 1

print(ret)
