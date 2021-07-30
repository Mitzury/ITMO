#include <iostream>
#include <math.h>
using namespace std;

struct Root
{
    double x1;
    double x2;
};

Root getRoots(double, double, double);
void showRoots(Root);

int main()
{
    setlocale(LC_ALL, "Russian");
    double a, b, c;

    cout << "Введите значения квадратного уравнения: \n";
    cin >> a >> b >> c;

    showRoots(getRoots(a, b, c));
}

Root getRoots(double a, double b, double c)
{
    Root r;
    double d = b * b - 4 * a * c;
    if (d > 0)
    {
        r.x1 = ((-b) + sqrt(d)) / (2 * a);
        r.x2 = ((-b) - sqrt(d)) / (2 * a);
        return r;
    }
    else if (d == 0)
    {
        r.x1 = r.x2 = (-b) / (2 * a);
        return r;
    }
}

void showRoots(Root r)
{
    if (r.x1)
    {
        if (r.x1 != r.x2)
        {
            cout << "Дискриминант больше нуля:\n";
            cout << "x1 = " << r.x1 << ", x2 = " << r.x2 << endl;
        }
        else
        {
            cout << "Дискриминант равен нулю:\n";
            cout << "x = " << r.x1 << endl;
        }
    }
    else
    {
        cout << "Дискриминант меньше нуля.\n";
    }
}