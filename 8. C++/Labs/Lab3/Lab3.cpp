#include <iostream>

int main()
{
    std::cout << "Программа вычисления площади сложной фигуры! Пятиугольник.\n";
    std::cout << "Введите координаты вершин пятиугольника\n";
    int x, y, x1, y1;


    for (int i = 1; i <= 5; i++)
    {
        std::cout << "Введите Х" << i << "й вершины\n ";
        std::cin >> x;
        std::cout << "Введите Y" << i << "й вершины\n ";
        std::cin >> y;

        sqrt_figure(x, y);
    }
 
}

void sqrt_figure(double x, double y)
{

}