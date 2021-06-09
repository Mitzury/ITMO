from random import randint
import time
import module1


def cubeThrowing():
    igrok1_ochki=0
    igrok2_ochki=0
    a=module1.inputName()
    igrok1=a[0]
    igrok2=a[1]
    print(a)
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
    print(f"1 кубик = {a[0], igrok1_ochki } | 2 кубик = {a[1], igrok2_ochki}")
b=cubeThrowing()

input()