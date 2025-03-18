p = input()
P=[]
A = 1
for i in range(0,len(p)):
    P+= [p[i]]
for j in range(0, len(p)//2):
    if P[j] != P[len(p)-j-1]:
        A = 0
        break
print(A)
