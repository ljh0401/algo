W = []
for i in range(0, 5):
    W += [list(input())]
for j in range(0, 15):
    for t in range(0, 5):
        try : print(W[t][j], end = '')
        except: continue