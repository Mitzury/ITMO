#include <iostream>

int main()
{
    //// Lab 2. Ex. 1

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

    // Lab 2. Ex. 3

    std::cout << "Задача о размене монет\n";
    std::cout << "Введите сумму которую Вам разменять: (x.xx) \n";
    double summ;
    std::cin >> summ;

    double coin10 = summ / 10;
    std::cout << "Монет по 10р.: " << trunc(coin10) << "\n";
    summ = summ - trunc(coin10) * 10;
    double coin5 = summ / 5;
        
    std::cout << "Монет по 5р.: " << trunc(coin5) << "\n";
    summ = summ - trunc(coin5) * 5;
    double coin05 = summ / 0.5;
        
    std::cout << "Монет по 50коп.: " << trunc(coin05) << "\n";
    summ = summ - trunc(coin05) * 0.5;
    double coin01 = summ / 0.1;
        
    std::cout << "Монет по 10коп.: " << trunc(coin01) << "\n";
    summ = summ - trunc(coin01) * 0.1;
    double coin001 = summ / 0.01;
        
    std::cout << "Монет по 1коп.: " << trunc(coin001) << "\n";
    summ = summ - coin001 * 0.01;

    std::cout << "Остаток: " << summ;


}
