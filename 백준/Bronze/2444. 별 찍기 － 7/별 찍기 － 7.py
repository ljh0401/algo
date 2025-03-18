S = int(input())
for i in range(0,S):
    print(' '*(S-i-1), '*'*(2*i+1), sep = '')
for j in range(S-2,-1,-1):
    print(' '*(S-j-1), '*'*(2*j+1), sep = '')