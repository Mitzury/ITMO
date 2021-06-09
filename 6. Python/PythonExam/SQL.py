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

def ListItems():
    try:
        connection = MySQLConnection.connection()
        if connection.is_connected():
            cursor = connection.cursor()
            cursor.execute("SELECT ItemName FROM mydb.items")
            ListItem = []
            for row in cursor.fetchall():
                ListItem.append(row[0])
            connection.close()
    except Error as e:
        print(e)
    return ListItem


def AddItems():
    print("Введите имя продукта:")
    ItemName = str(input())
    print("Доступные категории товаров:")
    ListCategory()
    CatName = str(input())
    if CatName in ListCategory():
        print("Введите стоимость:")
        Price = int(input())
        print("Введите дату покупки: гггг-мм-дд")
        iDate = str(input())
        Date = DT.datetime.strptime(iDate, '%Y-%m-%d').date()
        try:
            connection = MySQLConnection.connection()
            cursor = connection.cursor()
            cursor.execute("SELECT id FROM mydb.categories where CatName = '{CatName}'".format(CatName=CatName))
            id = cursor.fetchone()
            for row in id:
                CatN = row
            cursor.execute("INSERT INTO mydb.items (ItemName, Date, Price, CatId) VALUES ('{ItemName}',"
                           "'{Date}', "
                           "'{Price}', "
                           "'{CatId}')".format(ItemName=ItemName,
                                               Date=Date,
                                               Price=Price,
                                               CatId=CatN))
            connection.commit()
            connection.close()
        except Error as e:
            print(e)
    else:
        print("Такой категории нет")


def ListByDate():
    print("Введите дату за которую хотите посмотреть Ваши покупки: гггг-мм-дд")
    iDate = str(input())
    ListDate = DT.datetime.strptime(iDate, '%Y-%m-%d').date()
    try:
        connection = MySQLConnection.connection()
        if connection.is_connected():
            cursor = connection.cursor()
            cursor.execute("SELECT * FROM mydb.items where Date = '{ListDate}'".format(ListDate=ListDate))
            for row in cursor.fetchall():
                print("Item: " + row[1] + " by Price: " + str(row[3]))
            connection.close()

    except Error as e:
        print(e)


def ListByCat():
    print("Введите категориию по которой хотите посмотреть покупки")
    ListCategory()
    CatName = str(input())
    try:
        connection = MySQLConnection.connection()
        if connection.is_connected():
            cursor = connection.cursor()
            cursor.execute("SELECT id FROM mydb.categories where CatName = '{CatName}'".format(CatName=CatName))
            id = cursor.fetchone()
            for row in id:
                CatId = row
            cursor.execute("SELECT * FROM mydb.items where id = {CatId}".format(CatId=CatId))
            for row in cursor.fetchall():
                print("Item: " + row[1] + " by price " + str(row[3]))
            connection.close()

    except Error as e:
        print(e)


def ListByOrder():
    print("Все покупки по возрастанию цены")
    try:
        connection = MySQLConnection.connection()
        if connection.is_connected():
            cursor = connection.cursor()
            cursor.execute("SELECT * FROM mydb.items order by Price")
            for row in cursor.fetchall():
                print("Item: " + row[1] + " by price " + str(row[3]))
            connection.close()
    except Error as e:
        print(e)


def DeleteItem():
    print("Введите имя покупки для удаления")
    ItemName = str(input())

    if ItemName in ListItems():
        try:
            connection = MySQLConnection.connection()
            cursor = connection.cursor()
            cursor.execute("SELECT id FROM mydb.categories where CatName = '{CatName}'".format(CatName=CatName))
            id = cursor.fetchone()
            for row in id:
                CatN = row
            cursor.execute("DELETE * from mydb.items where ItemName = '{ItemName}'".format(ItemName=ItemName))
            connection.commit()
            connection.close()
        except Error as e:
            print(e)
        else:
            print("Такого товара нет")