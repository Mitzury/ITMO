#работа со строками

string1 = "This is a string."
string2 = " This is another string."
string3 = string1+string2
print(string3)
print(len(string3))
print(string3.lower())
print(string3.upper())
print(string3.title())
print(string3.strip('.'))
d = "qwerty"
ch = d[2]
print(ch)
string4= string3[1:3]
print(string4)
str5=string3[1:] 
str6=string3[:3] 
str7=string3[:]
str8=string3[1:5:2]
print(str5, str6,str7,str8)
#работа с числами
a = 30
b = 2
print(a/b)
print(a%b)
print(a**b)
a=4
b=5.5
c=a/b
d=b**a
f=b%2
print(c, d,f)
#преобразование данных
param = "string" + str(15)
print(param)
n1 = input("Enter the first number: ")
n2 = input("Enter the second number: ")
n3 = float(n1) + float(n2)
print(n1 + " plus " + n2 + " = ", n3)
a = 1/3
print("{:7.3f}".format(a))
a = 2/3
b = 2/9
print("{:7.3f} {:7.3f}".format(a, b))
print("{:10.3e} {:10.3e}".format(a, b))
#списки
list1 = [82,8,23,97,92,44,17,39,11,12]
dir(list1)
#help(list1)
import math
#help(list1.insert)
#help(list1.append)
#help(list1.sort)
#help(list1.remove)
#help(list1.reverse)
list1[3]=1000
print(list1)
list1.append(100)
print(list1)
list1.insert(1, 444)
print(list1)
del list1[5]
print(list1)
del list1[-1]
print(list1)
list1.sort(reverse=True)
print(list1)
list2 = [3,5,6,2,33,6,11]
list3 = sorted(list2)
print(list3)
print(dir(tuple))
help(list3.count)
help(list3.index)
#кортежи
seq = (2,8,23,97,92,44,17,39,11,12)
print(seq.count(8))
print(seq.index(44))
listseq = list(seq)
print(listseq)
print(type(listseq))
listseq.append(100)
print(listseq)
listseq.sort(reverse=True)
print(listseq)
#Словари
D = {'food': 'Apple', 'quantity': 4, 'color': 'Red'}
print(D['food'])
D['quantity'] += 10
print(D)

dp = {}
length = int(input("Введите длину словаря:"))
for element in range(0,length):
 dp[input()] = input()
 print(dp)
 #Вложенность хранения данных
 rec = {'name': {'firstname': 'Bob', 'lastname': 'Smith'},
       'job': ['dev', 'mgr'],
       'age': 25}
print('Имя сотрудника: '+rec['name']['firstname']+' Фамилия сотрудника: '+ rec['name']['lastname'])
print('Имя сотрудника: '+rec['name']['firstname'])
print("Должности: {job}".format(**rec))

rec['job'].append('janitor')
print(rec['job'])

print("Имя  фамилия: {0}: \n Должности: {1} \n Возраст: {2}".format(rec['name'],rec['job'],rec['age'] ))