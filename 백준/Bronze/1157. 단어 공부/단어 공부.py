W = input()
D = {}
for w in W.upper():
    if w in D :
        D[w] += 1
    else :
        D[w] = 1
M = max(D.values())
M_K = [key for key, value in D.items() if value == M]
if len(M_K) > 1:
    print('?')
else :
    print(M_K[0])