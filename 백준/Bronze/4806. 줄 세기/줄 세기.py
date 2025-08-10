cnt = 0
while True:
  try:
    i = input()
    cnt += 1
  except EOFError:
    break
print(cnt)
