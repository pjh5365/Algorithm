import sys
N = int(sys.stdin.readline())
s = []
for i in range(N):
	line = sys.stdin.readline().split()

	if line[0] == "push":
		get = int(line[1])
		s.append(get)

	elif line[0] == "pop":
		if len(s) == 0:
			print(-1)
		else:
			print(s.pop())

	elif line[0] == "size":
		print(len(s))

	elif line[0] == "empty":
		if len(s) == 0:
			print(1)
		else:
			print(0)

	elif line[0] == "top":
		if len(s) == 0:
			print(-1)
		else:
			print(s[-1])
	