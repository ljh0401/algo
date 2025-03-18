T = int(input())
for t in range(0, T):
    A, B = map(str, input().split())
    A = int(A)
    B = list(B)
    for i in range(0,len(B)):
        print(B[i]*A, end = '')
    print('')