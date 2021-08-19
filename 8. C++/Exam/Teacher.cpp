#include "Teacher.h"

// конструктор с параметрами
Teacher::Teacher(const string &surname, const string &name, const string &patronymic, const string &subject, const string &university) : Person(surname, name, patronymic) {
    this->subject = subject;
    this->university = university;
}

// вывод учителя
void Teacher::Print() const {
    cout << "Teacher: ";
    Person::Print();
    cout << ", subject: " << subject;
    cout << ", university: " << university << endl;
}

// вывод учителя в файл
void Teacher::PrintToFile(ofstream &f) const {
    f << "teacher:";
    Person::PrintToFile(f);
    f << ":" << subject;
    f << ":" << university << endl;
}