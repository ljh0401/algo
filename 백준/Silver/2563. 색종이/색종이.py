T = int(input())
C = [[0 for _ in range(100)] for _ in range(100)]
SUM = 0
for i in range(0, T):
    C1, C2 = map(int, input().split())
    for i in range(C1, C1+10):
        for j in range(C2, C2+10):
            if C[i][j] == 0:
                C[i][j] = 1
                SUM += 1
print(SUM)