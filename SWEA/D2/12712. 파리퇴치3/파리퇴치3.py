T = int(input())

for test_case in range(1,T+1):
  N, M = map(int, input().split())
  a = []
  num = N+2*M
  c = [[0]* num for _ in range(num)]
  max = 0
  for read in range(1, N+1):
      b = list(map(int, input().split()))
      a += [b]
  for i in range(0, N):
      for j in range(0, N):
           c[i+M][j+M] = a[i][j]
  for i in range(M, N+M):
      for j in range(M, N+M):
          tsum = 0
          xsum = 0
          tsum += c[i][j]
          xsum += c[i][j]
          for t in range(1,M):
              xsum += c[i-t][j-t]
              xsum += c[i+t][j+t]
              xsum += c[i-t][j+t]
              xsum += c[i+t][j-t]
              tsum += c[i+t][j]
              tsum += c[i-t][j]
              tsum += c[i][j+t]
              tsum += c[i][j-t]
          if tsum > xsum :
              if tsum > max:
                  max = tsum
          else:      
              if xsum > max:
                  max = xsum 
  print("#%d"%test_case,max)