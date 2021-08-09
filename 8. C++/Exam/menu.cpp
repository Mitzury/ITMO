#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include "sql.h"
#include "menu.h"
using namespace std;


void print_menu() {
    system("cls");  // ������� �����
    //�������� �� ������� �������
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
    cin >> variant;// ��������� ������
    
    // ���� ���� �����������, �������� �� ���� � ������ ��������� ���
    while (variant < 1 || variant > count) {
        printf("Incorrect input. Try again: "); // ������� ��������� �� ������
        cin >> variant; // ��������� ������ ��������
    }

    return variant;
}

