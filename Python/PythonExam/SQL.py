from mysql.connector import Error
import datetime as DT
import MySQLConnection
import gc




def AddCategory():
    print("Введите имя категории:")
    CatName = str(input())
    if CatName == "":
        print("Некоректные данные")
    else:
        try:
            connection = MySQLConnection.connection()
            cursor = connection.cursor()
            cursor.execute("INSERT INTO mydb.categories (CatName) VALUES ('{CatName}')".format(CatName=CatName))
            connection.commit()
            connection.close()
        except Error as e:
            print(e)


def ListCategory():
    try:
        connection = MySQLConnection.connection()
        if connection.is_connected():
            cursor = connection.cursor()
            cursor.execute("SELECT CatName FROM mydb.categories")
            categories = []
            for row in cursor.fetchall():
                categories.append(row[0])
            connection.close()
            print(categories)
    except Error as e:
        print(e)
    return categories


def AddItems():
    print("Введите имя продукта:")
    ItemName = str(input())
    print("Доступные категории товаров:")
    ListCategory()
    CatName = str(input())
    print(CatName)
    if CatName in ListCategory():
        print("Введите стоимость:")
        Price = int(input())
        print("Введите дату покупки: гггг-мм-дд")
        iDate = str(input())
        Date = DT.datetime.strptime(iDate, '%Y-%m-%d').date()
        print(CatName)

        try:
            connection = MySQLConnection.connection()
            cursor = connection.cursor()
            cursor.execute("SELECT id FROM mydb.categories where CatName = '{CatName}'")
            version = cursor.fetchone()
            print(version)
            cursor.execute("INSERT INTO mydb.items ('ItemName', 'Date', 'Price', 'CatId') VALUES ('{ItemName}',"
                           " '{Date}', "
                           "'{Price}', "
                           "'{ItemName}')".format(ItemName=ItemName,
                                                  Date=Date,
                                                  Price=Price,
                                                  CatId=version))
            connection.commit()
            connection.close()
        except Error as e:
            print(e)
    else:
        print("Такой категории нет")
