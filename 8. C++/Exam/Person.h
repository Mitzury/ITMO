#pragma once

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

// человек
class Person {
protected:
    string surname; // фамилия
    string name; // имя
    string patronymic; // отчество
public:
    Person(const string &surname, const string &name, const string &patronymic); // конструктор с параметрами

    virtual void Print() const; // вывод
    virtual void PrintToFile(ofstream &f) const; // вывод в файл
};