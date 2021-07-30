#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    setlocale(LC_ALL, "Russian");

    const int N = 10;
    int a[N] = {1, 10, 2, 9, 8, 3, 7, 4, 6, 5};
    int min = 0;
    int buf = 0;

    ofstream file("sort.txt");
    file.is_open();
    file << "Исходный массив:" << endl;

    for (int i = 0; i < N; i++)
    {
        file << a[i] << " ";
    }

    file << endl;

    for (int i = 0; i < N; i++) {
        //min = i;
        for (int j = i + 1; j < N; j++) {
            min = (a[j] < a[i]) ? j : i;
            if (i != min)
            {
                buf = a[i];
                a[i] = a[min];
                a[min] = buf;
            }
        }
    }

    file << "Отсортированный массив:" << endl;

    for (int i = 0; i < N; i++)
    {
        file << a[i] << " ";
    }

    file.close();
}