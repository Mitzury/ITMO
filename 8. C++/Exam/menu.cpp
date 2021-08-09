#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include "sql.h"
#include "menu.h"
using namespace std;


void print_menu() {
    system("cls");  // очищаем экран
    //Проверка на наличие записей
    SQLCheck();
    printf("\nMenu:\n");
    printf("1. Add a phone\n");
    printf("2. Delete a phone\n");
    printf("3. List all phones\n");
    printf("4. Reserved\n");
    printf("5. Exit\n");
    printf(">");
}

int get_variant(int count) {
   
    int variant;
    cin >> variant;// считываем строку
    
    // пока ввод некорректен, сообщаем об этом и просим повторить его
    while (variant < 1 || variant > count) {
        printf("Incorrect input. Try again: "); // выводим сообщение об ошибке
        cin >> variant; // считываем строку повторно
    }

    return variant;
}

