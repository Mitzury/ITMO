import gc

import BDcheck
import SQL

gc.disable()
gc.get_stats()

def MainMenu():
    print("#############################")
    print("1. Добавить покупку")
    print("2. Добавить категорию")
    print("3. Посмотреть категории")
    print("4. Посмотреть по дате")
    print("5. Посмотреть по категории")
    print("6. Посмотреть по возрастанию")
    print("7. Удалить покупку")
    print("8. Проверить соединение с БД")
    print("0. Выход")
    print("#############################")


def main():
    cmd = input("Введите команду: ")
    while cmd != "0":
        if cmd == "1":
            SQL.AddItems()
        elif cmd == "2":
            SQL.AddCategory()
        elif cmd == "3":
            SQL.ListCategory()
        elif cmd == "4":
            SQL.ListByDate()
        elif cmd == "5":
            SQL.ListByCat()
        elif cmd == "6":
            SQL.ListByOrder()
        elif cmd == "7":
            SQL.DeleteItem()
        elif cmd == "8":
            BDcheck.con()
        else:
            print("Такой команды нет. Попробуйте еще:")
            MainMenu()
        cmd = input("Введите команду: ")
    return


print("_______________________________________________________________")
print("|Добро пожаловать в консольную программу Домашняя бухгалтерия | \n|Выберите действие |")
MainMenu()
main()
