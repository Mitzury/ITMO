#pragma once

#include <iostream>
#include <fstream>
#include <string>
#include "Person.h"

using namespace std;

// студент
class Student : public Person {
    int grade; // курс
    string university; // университет
public:
    Student(const string &surname, const string &name, const string &patronymic, int grade, const string &university = "VPU №7"); // конструктор с параметрами

    void Print() const; // вывод студента
    void PrintToFile(ofstream &f) const; // вывод студента в файл
};
