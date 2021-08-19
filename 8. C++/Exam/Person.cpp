#include "Person.h"

// конструктор с параметрами
Person::Person(const string &surname, const string &name, const string &patronymic) {
    this->surname = surname;
    this->name = name;
    this->patronymic = patronymic;
}

// вывод 
void Person::Print() const {
    cout << surname << " " << name << " " << patronymic;
}

// вывод в файл
void Person::PrintToFile(ofstream &f) const {
    f << surname << ":" << name << ":" << patronymic;
}
