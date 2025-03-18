N = int(input())
S = list(map(int, input().split()))
TP = list(map(int, input().split()))
T = 0
for i in S:
    T += (i //TP[0])
    if i%TP[0] > 0 :
        T += 1
print(T)
print(N//TP[1] , N%TP[1])