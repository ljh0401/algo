T = int(input())
sum = 0
for t in range(0,T):
    L = 0
    W = input()
    w = set(list(W))
    D = '*'+W+'*'
    for i in w:
        l = D.replace(i,'-')
        d = list(l.split('-'))
        while '' in d:
            d.remove('')
        if len(d) > 2:
            L = 1
            break
    if L == 1 :
        continue
    else :
        sum += 1  
print(sum)