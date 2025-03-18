def remove_list(L, D):
    l = L[:]
    for i in range(0, len(L)):
        a = L[i]
        if a > D :
            l.remove(a)
    return l

def find_D (L, D):
    t = 20000000
    for i in range(0, 2 ** N):
        temp = 0
        for j in range(0, len(L)):
            if i & 2 ** j:
                temp += L[j]
        if temp <= D:
            d = D-temp
            t = min(t, d)
    return t
            

T = int(input())
for test_case in range(1, T + 1):
    N, B = map(int, input().split())
    L = list(map(int, input().split()))
    S = sum(L)
    D = S-B
    rlist = []
    result = 0
    L = remove_list(L,D)
    if len(L) == 0:
        result = D
        print(f"#{test_case}",result)
        continue
    result = find_D(L,D)
    print(f"#{test_case}",result)