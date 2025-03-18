A=[]
for i in range(0, 9):
    A += [int(input())]
B = max(A)
C = A.index(B)+1
print(B, C, sep ='\n')