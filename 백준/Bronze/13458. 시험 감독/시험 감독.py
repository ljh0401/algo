N = int(input())
A = list(map(int, input().split()))
B, C  =map(int, input().split())
P = 0
for i in A:
    i -= B
    P += 1
    if i >0 :
        P += i // C
        if i % C != 0:
            P += 1
print(P)   