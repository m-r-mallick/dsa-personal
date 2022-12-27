m = int(input("Number of rows, m = "))
n = int(input("Number of columns, n = "))
a = []
for i in range(m):
    b = []
    for j in range(n):
        print("Entry in row: %d column: %d" % (i, j))
        b.append(int(input()))
    a.append(b)

print(a)
