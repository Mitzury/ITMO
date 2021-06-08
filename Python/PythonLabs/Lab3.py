import math
import random as ran
import statistics as stat
print(help(math))
print(dir(math))

list = [13,23,38,44,155,68,72,81,90,100]
print(list)
print("Сумма цифр: ", math.fsum(list))
print("Среднее: ", stat.mean(list))
print("Медиана: ", stat.median(list))
print("Стандартное отклонение: ", stat.stdev(list))

print("Random integer between 1 and 100: ", ran.randint(1,100))