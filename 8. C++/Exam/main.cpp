#include <stdio.h>
#include "sqlite3.h"
#include <string>
#include "sql.h"
#include <iostream>
using namespace std;

// "SELECT Name,Number FROM Phonebook";

void SQLCheck() {
	string query = "SELECT COUNT (*) FROM PhoneBook";
	SQLCount(query);
}

void SQLInsert() {
	string query = "INSERT INTO PhoneBook VALUES('Sergei', 543, 'My Own Nubmer')";
	SQLCreate(query);
}

int main(int argc, char** argv) {
	//Создание БД при первом запуске
	string query = "CREATE TABLE IF NOT EXISTS PhoneBook(Name, Number, Desc);";
	SQLCreate(query);
	cout << "Welcome to my PhoneBook" << "\n";
	//Проверка на наличие записей
	SQLCheck();
	

}