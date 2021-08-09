#include <stdio.h>
#include "sqlite3.h"
#include <string>
#include "sql.h"
#include <iostream>
#include "menu.h"

using namespace std;

// "SELECT Name,Number FROM Phonebook";

void SQLCheck() {
	string query = "SELECT COUNT (*) FROM PhoneBook";
	SQLCount(query);
}

void SQLInsert() {
    cout << "adsasd";
	string query = "INSERT INTO PhoneBook VALUES('Sergei', 543, 'My Own Nubmer')";
	SQLCreate(query);
}

void SQLDelete() {
	string query = "";
	SQLCreate(query);
}

void SQLUpdate() {
	string query = "";
	SQLCreate(query);
}

int main(int argc, char** argv) {
	//Создание БД при первом запуске
	string query = "CREATE TABLE IF NOT EXISTS PhoneBook(Name, Number, Desc);";
	SQLCreate(query);

	
    int variant; // выбранный пункт меню
    int size = 0; // количество элементов массива товаров
    int capacity = 1; // ёмкость массива товаров
    do {
        print_menu(); // выводим меню на экран

        variant = get_variant(5); // получаем номер выбранного пункта меню

        switch (variant) {
        case 1:
            SQLInsert();
            break;

        case 2:
           
            break;

        case 3:
            
            break;

        case 4:
           
            break;
        }

        if (variant != 5)
            system("pause"); // задерживаем выполнение, чтобы пользователь мог увидеть результат выполнения выбранного пункта
    } while (variant != 5);


}