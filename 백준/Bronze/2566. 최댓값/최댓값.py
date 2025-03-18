S = []
for i in range(0, 9):
    s = list(map(int,input().split()))
    S += s
A = S.index(max(S))

print(max(S))
print(A//9+1, A%9+1)