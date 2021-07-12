#include <iostream>

int main()
{
    // Lab 2. Ex. 1

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

    
    // Lab 2. Ex. 2

    std::cout << "Введите три числа и я скажу какое из них наибольшее.\n";
    int a;
    int b;
    int c;

    std::cin >> a;
    std::cin >> b;
    std::cin >> c;

    if (a > b and a > c)
    {
        std::cout << a;
    }
    else if (b > a and b > c)
    {
        std::cout << b;
    }
    else if (c > a and c > b)
    {
        std::cout << c;
    }
    return 0;

}
