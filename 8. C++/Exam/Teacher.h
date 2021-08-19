#pragma once

#include <iostream>
#include <fstream>
#include <string>
#include "Person.h"

using namespace std;

// учитель
class Teacher : public Person {
    string subject; // предмет
    string university; // университет
public:
    Teacher(const string &surname, const string &name, const string &patronymic, const string &subject, const string &university); // конструктор с параметрами

    void Print() const; // вывод
    void PrintToFile(ofstream &f) const; // вывод студента в файл
};