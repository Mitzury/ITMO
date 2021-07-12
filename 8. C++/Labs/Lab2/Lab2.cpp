#include <iostream>

int main()
{
    setlocale(LC_ALL, "Russian");
    std::cout << "Определение високовного года\n";
    std::cout << "Введите год yyyy:\n";
    int year;
    std::cin >> year;
    std::cout << "Вы ввели: " << year;

    if (year % 4 == 0 and year % 100 != 0 or year % 400 == 0)
    {
        std::cout << "Год был високосный:\n";
    }
    else
        std::cout << "Год был не високосный\n";
    return 0;

}