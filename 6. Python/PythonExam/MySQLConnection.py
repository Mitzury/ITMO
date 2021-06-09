import mysql.connector


# Подключиться к базе данных.
def connection():
    con = mysql.connector.connect(host='127.0.0.1',
                                  user='root',
                                  password='220819891',
                                  db='mydb'
                                  )
    return con
