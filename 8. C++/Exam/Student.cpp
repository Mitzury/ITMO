#include "Student.h"

// конструктор с параметрами
Student::Student(const string &surname, const string &name, const string &patronymic, int grade, const string &university) : Person(surname, name, patronymic) {
    this->grade = grade;
    this->university = university;
}

// вывод студента
void Student::Print() const {
    cout << "Student: ";
    Person::Print();
    cout << ", grade: " << grade;
    cout << ", university: " << university << endl;
}

// вывод студента в файл
void Student::PrintToFile(ofstream &f) const {
    f << "student:";
    Person::PrintToFile(f);
    f << ":" << grade;
    f << ":" << university << endl;
}