from random import randint
import time

#Ввод имен играющих
igrok1 = input('Введите имя 1-го игрока ')
igrok2 = input('Введите имя 2-го игрока ')
igrok1_ochki=0
igrok2_ochki=0
for i in range(1,6):
    print("новый раунд под номером: ", i)
    print('Кубик бросает', igrok1)
    time.sleep(2)
    n1 = randint(1, 6)
    print('Выпало:', n1)
    print('Кубик бросает', igrok2)
    time.sleep(2)
    n2 = randint(1, 6)
    print('Выпало:', n2)

    if n1 > n2:
        print('Выиграл', igrok1)
        igrok1_ochki+=1
    elif n1 < n2:
        print('Выиграл', igrok2)
        igrok2_ochki+=1
    else:
        print('Ничья')
        igrok1_ochki+=0.5
        igrok2_ochki+=0.5
if igrok1_ochki>igrok2_ochki:
    print ('Выиграл '+ igrok1+ "с очками: "+ str(igrok1_ochki))
elif igrok1_ochki<igrok2_ochki:
    print ('Выиграл'+igrok2+'очками: ' + str(igrok2_ochki))
else:
    print ('Ничья: ', igrok1_ochki, "+",igrok2_ochki)