T = int(input())
for i in range(0,T):
    Q = 0
    D = 0
    N = 0
    P = 0
    M = int(input())
    Q = M // 25
    M -= Q*25
    if M != 0:
        D = M // 10
        M -= D*10
        if M != 0:
            N = M //5
            M -= N*5
            P = M
    print(Q, D, N, P)