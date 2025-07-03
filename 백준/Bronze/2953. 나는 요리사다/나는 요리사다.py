arr = [list(map(int, input().split())) for _ in range(5)]
score = [0] * 5
maxNum = 0
maxScore = 0
for i in range(5):
	for j in arr[i]:
		score[i] += j

	if (score[i] > maxScore):
		maxNum = i;
		maxScore = score[i];
print(maxNum + 1, maxScore)
