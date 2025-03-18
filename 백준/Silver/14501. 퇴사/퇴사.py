N = int(input())
T = []
for t in range(0, N):
    T += [list(map(int, input().split()))]
t = [0 for _ in range(N+1)]
for i in range(N):
    for j in range(i+T[i][0], N+1):
        if t[j] < t[i] + T[i][1]:
            t[j] = t[i] + T[i][1]
print(max(t))