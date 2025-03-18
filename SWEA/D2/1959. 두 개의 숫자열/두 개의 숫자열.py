T= int(input())
for test_case in range(1,T+1):
    n, m = map(int, input().split())
    N = list(map(int, input().split()))
    M = list(map(int, input().split()))
    sum = 0 
    if len(N) > len(M) :
        for j in range(0, len(N)-len(M)+1):
            ex = 0
            for i in range(0,len(M)):
                ex += M[i]*N[i+j]
            if ex > sum:
                sum = ex
    elif len(N) < len(M):
        for j in range(0, len(M)-len(N)+1):
            ex = 0
            for i in range(0,len(N)):
                ex += N[i]*M[i+j]
            if ex > sum:
                sum = ex
    else:
        ex = 0
        for i in range(0,len(N)):
            ex += N(i)*M(i)
        if ex > sum :
            sum = ex
    print("#%d" %test_case, sum)
            