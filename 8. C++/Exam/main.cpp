#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include "Person.h"
#include "Student.h"
#include "Teacher.h"

using namespace std;

// добавление студента
void AddStudent(vector<Person*> &persons) {
    string surname;
    string name;
    string patronymic;
    int grade;
    cout << "Enter surname: ";
    cin >> surname; // считываем фамилию
    cout << "Enter name: ";
    cin >> name; // считываем имя
    cout << "Enter patronymic: ";
    cin >> patronymic; // считываем отчество
    cout << "Enter grade: ";
    cin >> grade; // считываем курс

    persons.push_back(new Student(surname, name, patronymic, grade)); // добавляем студента
}

// получение образовательного учреждения учителя
string GetTeacherUniversity() {
    string university;
    cout << "Enter university (1 - college, 2 - university, 3 - school): ";
    cin >> university;

    if (university == "1")
        return "college";

    if (university == "2")
        return "university";

    if (university == "3")
        return "school";

    return "unknown";
}

// добавление учителя
void AddTeacher(vector<Person*> &persons) {
    string surname;
    string name;
    string patronymic;
    string subject;
    string university;

    cout << "Enter surname: ";
    cin >> surname; // считываем фамилию
    cout << "Enter name: ";
    cin >> name; // считываем имя
    cout << "Enter patronymic: ";
    cin >> patronymic; // считываем отчество
    cout << "Enter subject: ";
    cin >> subject; // считываем предмет
    university = GetTeacherUniversity(); // получаем университет

    persons.push_back(new Teacher(surname, name, patronymic, subject, university)); // добавляем учителя
}

// вывод людей
void PrintPersons(const vector<Person*> &persons) {
    if (persons.size() == 0) { // если нет людей
        cout << "No persons have been added yet" << endl;
        return; // выходим
    }

    for (size_t i = 0; i < persons.size(); i++) {
        persons[i]->Print(); // выводим каждого
    }
}

// сохранение людей в файл
void SavePersons(const vector<Person *> &persons) {
    string path; // путь к файлу
    cout << "Enter path to file: ";
    cin >> path; // считываем путь к файлу

    ofstream f(path); // создаём файл

    for (size_t i = 0; i < persons.size(); i++) {
        persons[i]->PrintToFile(f); // сохраняем каждого человека в файл
    }

    f.close(); // закрываем файл
}

// считывание из файла
void ReadPersonsFromFile(vector<Person *> &persons) {
    string path; // путь к файлу
    cout << "Enter path to file: ";
    cin >> path; // считываем путь к файлу

    ifstream f(path); // открываем файл

    if (!f) { // если файл не открылся
        cout << "Unable to open file '" << path << "'" << endl; // сообщаем об этом
        return; // и выходим
    }

    persons.clear(); // очищаем вектор

    while (!f.eof()) { // пока не кончится файл
        string type; // тип
        string surname; // фамилия
        string name; // имя
        string patronymic; // отчество

        getline(f, type, ':'); // получаем тип
        getline(f, surname, ':'); // получаем фамилию
        getline(f, name, ':'); // получаем имя
        getline(f, patronymic, ':'); // получаем отчество

        if (type == "student") {
            string grade; // курс
            string university;
            getline(f, grade, ':'); // получаем курс
            getline(f, university); // получаем университет

            persons.push_back(new Student(surname, name, patronymic, stoi(grade), university)); // добавляем студента
        }
        else if (type == "teacher") {
            string subject; // предмет
            string university; // университет
            getline(f, subject, ':'); // получаем предмет
            getline(f, university); // получаем университет

            persons.push_back(new Teacher(surname, name, patronymic, subject, university)); // добавляем учителя
        }
    }

    f.close(); // закрываем файл
    cout << "Successfully readed " << persons.size() << " persons" << endl;
}

int main() {
    vector<Person*> persons; // люди
    int item; // считываемый пункт меню

    do {
        cout << endl << "Select item of menu" << endl;
        cout << "1. Add student" << endl;
        cout << "2. Add teacher" << endl;
        cout << "3. Print" << endl;
        cout << "4. Save to file" << endl;
        cout << "5. Read from file" << endl;
        cout << "6. Quit" << endl;
        cout << ">"; // выводим приглашение ко вводу
        cin >> item; // считываем пункт меню

        // пока некорректный ввод
        while (item < 1 || item > 6) {
            cout << "Invalid item, try again: ";
            cin >> item; // считываем пункт меню
        }

        // обрабатываем выбранный пункт меню
        switch (item) {
        case 1: // обрабатываем пункт меню "add student"
            AddStudent(persons);
            cout << "Successfully added" << endl;
            break;

        case 2: // обрабатываем пункт меню "add teacher"
            AddTeacher(persons);
            cout << "Successfully added" << endl;
            break;

        case 3: // обрабатываем пункт меню "print"
            PrintPersons(persons);
            break;

        case 4: // обрабатываем пункт меню "save to file"
            SavePersons(persons);
            cout << "Saved" << endl;
            break;

        case 5: // обрабатываем пункт меню "read from file"
            ReadPersonsFromFile(persons);
            break;
        }
    } while (item != 6); // повторяем, пока не решим выйти
}
