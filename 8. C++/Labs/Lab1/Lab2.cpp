#include <iostream>

int main()
{
    setlocale(LC_ALL, "Russian");
    std::cout << "����������� ����������� ����\n";
    std::cout << "������� ��� yyyy:\n";
    int year;
    std::cin >> year;
    std::cout << "�� �����: " << year;

    if (year % 4 == 0 and year % 100 != 0 or year % 400 == 0)
    {
        std::cout << "��� ��� ����������:\n";
    }
    else
        std::cout << "��� ��� �� ����������\n";
}