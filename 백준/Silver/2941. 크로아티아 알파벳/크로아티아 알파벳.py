C = input()
C_W = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
S = 0
for c in C_W:
    S += C.count(c)
    C = C.replace(c," ")
C = C.replace(" ","")
if len(C) != 0:
    S += len(C)

print(S)