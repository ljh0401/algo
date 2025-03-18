N, M = input().split()
L = []
K = []
SUM = []
for i in range(0,int(N)):
    L.append(list(input().split()))
for j in range(0,int(N)):
    K.append(list(input().split()))
for s in range(0, int(N)):
    S = []
    for t in range(0, int(M)):
        l = int(L[s][t])+int(K[s][t])
        S += [l]
    SUM.append(S)
for u in range(0,int(N)):
    print(*SUM[u])