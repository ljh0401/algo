N, B = map(int, input().split())
b = []
while N != 0:
    T = N%B
    N = N//B
    if T > 9 :
        T += 55
        T = chr(T)
    b.append(T)
b.reverse()
for i in b:
    print(i, end='')