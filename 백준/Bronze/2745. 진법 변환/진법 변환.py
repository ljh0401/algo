A, B = input().split()
B = int(B)
A = list(A)
j = 0
answer = 0
for i in range(len(A)-1, -1, -1):
    a = B**j
    if (ord(A[i])-64) > 0:
        answer += (ord(A[i])-55)*a
    else:
        answer += (ord(A[i])-48)*a
    j += 1
print(answer)