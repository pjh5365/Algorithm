N = int(input())
arr = list(map(int, input().split()))
max_num = arr[0]
min_num = arr[0]

for num in arr:
	if num > max_num:
		max_num = num
	elif num < min_num:
		min_num = num

print(min_num, max_num)
