from mysql.connector import Error

import MySQLConnection


def con():
    try:
        connection = MySQLConnection.connection()
        if connection.is_connected():
            print("Connection Succesfully")
            cursor = connection.cursor()
            cursor.execute("SELECT VERSION()")
            version = cursor.fetchone()
            connection.close()
            print("Datbase version: {}".format(version[0]))
    except Error as e:
        print(e)
