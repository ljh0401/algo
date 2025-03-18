a, b = map(int, input().split())
if (a==1 and b==3) or (a==2 and b==1) or (a==3 and b==2):
    print("A")
elif (b==1 and a==3) or (b==2 and a==1) or (b==3 and a==2):
    print("B")
else:
    print("error")
