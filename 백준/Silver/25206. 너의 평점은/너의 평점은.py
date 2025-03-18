G = {'A+':'4.5', 'A0':'4.0', 'B+':'3.5', 'B0':'3.0', 'C+':'2.5', 'C0':'2.0', 'D+':'1.5', 'D0':'1.0', 'F':'0.0'}
S = 0
s = 0
for t in range(0, 20):
    A = list(map(str, input().split()))
    if A[2] == 'P':
        continue
    B = float(A[1])*float(G[A[2]])
    S += float(A[1])
    s += B
print(s/S)