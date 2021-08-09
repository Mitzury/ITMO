#include <stdio.h>
#include "sqlite3.h"
#include <string>
#include "sql.h"
#include <iostream>
using namespace std;

sqlite3* db = 0; // хэндл объекта соединение к БД
char* err = 0;
int rc;
sqlite3_stmt* result;

void SQLCreate(string query) {

	// открываем соединение
	if (sqlite3_open("PhoneBook.db", &db))
		fprintf(stderr, "Ошибка открытия/создания БД: %s\n", sqlite3_errmsg(db));
	// выполняем SQL
	else if (sqlite3_exec(db, query.c_str(), 0, 0, &err))
	{
		fprintf(stderr, "Ошибка SQL: %sn", err);
		sqlite3_free(err);
	}
	// закрываем соединение
	sqlite3_close(db);
}

void SQLCount(string query) {
	// открываем соединение
	if (sqlite3_open("PhoneBook.db", &db))
		fprintf(stderr, "Ошибка открытия/создания БД: %s\n", sqlite3_errmsg(db));
	// выполняем SQL
	else if  (rc = sqlite3_prepare(db, query.c_str(), -1, &result, NULL));
	{
		// Compruebo que no hay error
		if (rc != SQLITE_OK) {
			fprintf(stderr, "Query error: %s.\n", sqlite3_errmsg(db));
			sqlite3_close(db);

		}
		while (sqlite3_step(result) == SQLITE_ROW) {
			fprintf(stderr, "Values in PhoneBook:  %i\n", sqlite3_column_int(result, 0));
		}
	}
	// Cierro la conexión
	sqlite3_close(db);
}

