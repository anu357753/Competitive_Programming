def somefunc(n):
    count=0
    while n>0:
        if(n%2==1):
            count+=1
        n=n//2
    return count

def anotherfunc(n):
    l=[]
    while n>=0:
        l.append(somefunc(n))
        n-=1
    return l

d=anotherfunc(15)
l=d[::-1]
print(l)
d=anotherfunc(16)
l=d[::-1]
print(l)
d=anotherfunc(1)
l=d[::-1]
print(l)
d=anotherfunc(25)
l=d[::-1]
print(l)
d=anotherfunc(5)
l=d[::-1]
print(l)
d=anotherfunc(6)
l=d[::-1]
print(l)